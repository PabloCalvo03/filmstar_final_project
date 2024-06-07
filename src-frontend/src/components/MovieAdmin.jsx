import React, { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';

const MovieAdmin = () => {
    const user = useSelector(state => state.user);
    const navigate = useNavigate(); 

    const [movies, setMovies] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        if(!user) return;
        const fetchMovies = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/backoffice/movies', {
                    headers: {
                        Authorization: "Bearer " + user.user.accessToken,
                    }
                });
                if (response.ok) {
                    const data = await response.json();
                    setMovies(data);
                } else {
                    console.error('Failed to fetch movies');
                }
            } catch (error) {
                console.error('Error fetching movies:', error);
            } finally {
                setLoading(false);
            }
        };

        fetchMovies();
    }, [user]);


    const handleEdit = (movieId) => {
        navigate(`/create-movie/${movieId}`);
    };

    const handleDelete = async (movieId) => {
        const confirmDelete = window.confirm('Are you sure you want to delete this movie?');
        if (!confirmDelete) return;

        try {
            const response = await fetch(`http://localhost:8080/api/backoffice/movies/${movieId}`, {
                method: 'DELETE',
                headers: {
                    Authorization: "Bearer " + user.user.accessToken,
                }
            });
            if (response.ok) {
                // Remove the deleted movie from the list
                setMovies(prevMovies => prevMovies.filter(movie => movie.id !== movieId));
                console.log('Movie deleted successfully');
            } else {
                console.error('Failed to delete movie');
            }
        } catch (error) {
            console.error('Error deleting movie:', error);
        }
    };

    if (loading) {
        return <div>Loading...</div>;
    }

    return (
        <div className="container mx-auto px-4 py-8 rounded-lg shadow-md">
            <h1 className="text-3xl font-semibold pb-4 text-gray-800 dark:text-white">Movie List</h1>
            {movies.length === 0 ? (
                <p className="text-gray-600 dark:text-gray-300">No movies found.</p>
            ) : (
                <ul className="space-y-4">
                    {movies.map(movie => (
                        <li key={movie.id} className="flex dark:bg-gray-800 items-center justify-between py-2 px-4 border border-gray-300 dark:border-gray-700 rounded-lg">
                            <div>
                                <h2 className="text-lg font-semibold text-gray-800 dark:text-white">{movie.title}</h2>
                                <p className="text-gray-600 dark:text-gray-300">{movie.overview}</p>
                            </div>
                            <div className="flex-shrink-0">
                                <button onClick={() => handleEdit(movie.id)} className="text-blue-500 hover:text-blue-700 dark:text-blue-400 dark:hover:text-blue-300">Edit</button>
                                <button onClick={() => handleDelete(movie.id)} className="text-red-500 hover:text-red-700 ml-2 dark:text-red-400 dark:hover:text-red-300">Delete</button>
                            </div>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default MovieAdmin;
