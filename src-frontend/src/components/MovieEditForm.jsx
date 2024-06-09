import React, { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import { useNavigate, useParams } from 'react-router-dom';

const MovieEditForm = () => {
    const user = useSelector(state => state.user);
    const navigate = useNavigate();
    const { movieId } = useParams();
    console.log(movieId)
    const [movieData, setMovieData] = useState({
        id: '',
        title: '',
        overview: '',
        year: '',
        posterImg: '',
        directorId: ''
    });
    const [errors, setErrors] = useState({});

    useEffect(() => {
        if(!user) return;
        const fetchMovieData = async () => {
            try {
                const response = await fetch(`http://localhost:8080/api/filmstar/movies/${movieId}`, {
                    headers: {
                        'Authorization': `Bearer ${user.user.accessToken}`
                    }
                });
                if (!response.ok) {
                    throw new Error('Failed to fetch movie data');
                }
                const data = await response.json();
                console.log(data)

                setMovieData({
                    id: data.id,
                    title: data.title,
                    overview: data.overview,
                    year: data.year,
                    posterImg: data.posterImg,
                    directorId: data.director.id
                });
                setOriginalMovieData(data);
            } catch (error) {
                console.error(error);
            }
        };
        fetchMovieData()
    }, [movieId]);

    const handleChange = (e) => {
        const { name, value } = e.target;
    
        if (name === 'directorId') {
            setMovieData({
                ...movieData,
                directorId: value
            });
        } else {
            setMovieData({
                ...movieData,
                [name]: value
            });
        }
    };

    const validateForm = () => {
        let newErrors = {};

        if (!movieData.title) {
            newErrors.title = 'Title is required';
        } else if (movieData.title.length > 20) {
            newErrors.title = 'Title cannot exceed 20 characters';
        }

        if (!movieData.overview) {
            newErrors.overview = 'Overview is required';
        } else if (movieData.overview.length > 500) {
            newErrors.overview = 'Overview cannot exceed 500 characters';
        }

        if (!movieData.year) {
            newErrors.year = 'Release Year is required';
        } else if (!/^\d{4}$/.test(movieData.year)) {
            newErrors.year = 'Release Year must be a 4-digit number';
        }

        if (!movieData.posterImg) {
            newErrors.posterImg = 'Poster Image URL is required';
        } else if (!/^https:\/\/image\.tmdb\.org\/t\/p\/w\d+\/.+\.(jpg|jpeg|png)$/.test(movieData.posterImg)) {
            newErrors.posterImg = 'Poster Image URL must be a valid URL from image.tmdb.org';
        }

        if (!movieData.directorId) {
            newErrors.directorId = 'Director ID is required';
        }

        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!validateForm()) {
            return;
        }

        try {
            const response = await fetch("http://localhost:8080/api/backoffice/movies", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${user.user.accessToken}`
                },
                body: JSON.stringify(movieData)
            });

            if (!response.ok) {
                throw new Error('Failed to update movie');
            }

            navigate('/');
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div className='py-2'>
            <h1 className="text-3xl font-[600] dark:text-white pb-2">Edit Movie</h1>
            <form onSubmit={handleSubmit} className="w-full mx-auto py-2" noValidate>
                {[
                    { id: 'title', label: 'Title', placeholder: 'Enter movie title...' },
                    { id: 'overview', label: 'Overview', placeholder: 'Enter movie overview...' },
                    { id: 'year', label: 'Release Year', placeholder: 'Enter release year...' },
                    { id: 'posterImg', label: 'Poster Image URL', placeholder: 'Enter poster image URL...' },
                    { id: 'directorId', label: 'Director ID', placeholder: 'Enter director ID...' }
                ].map((field) => (
                    <div key={field.id} className="relative mb-4">
                        <input
                            type="text"
                            id={field.id}
                            name={field.id}
                            value={movieData[field.id]}
                            className="block w-full p-4 text-sm text-gray-900 border border-gray-300 rounded-lg bg-white focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                            placeholder={field.placeholder}
                            onChange={handleChange}
                        />
                        {errors[field.id] && <p className="text-red-500 text-xs mt-1">{errors[field.id]}</p>}
                    </div>
                ))}
                <button type="submit" className="w-full px-4 py-2 text-sm font-medium text-white bg-green-500 rounded-lg hover:bg-green-600 focus:outline-none focus:ring-2 focus:ring-green-500 focus:ring-opacity-50">
                    Update
                </button>
            </form>
        </div>
    );
};

export default MovieEditForm;
