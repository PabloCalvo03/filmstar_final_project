import React, { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';

const MovieAdmin = () => {
    const user = useSelector(state => state.user);
    const navigate = useNavigate(); 

    const [movies, setMovies] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
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
        navigate(`/edit/${movieId}`);
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
        <div>
            <h1 className="text-3xl font-[600] dark:text-white pb-2">Movie List</h1>
            {movies.length === 0 ? (
                <p>No movies found.</p>
            ) : (
                <ul>
                    {movies.map(movie => (
                        <li key={movie.id} className="flex items-center justify-between py-2 border-b border-gray-200">
                            <div>
                                <h2>{movie.title}</h2>
                                <p>{movie.overview}</p>
                            </div>
                            <div>
                                <button onClick={() => handleEdit(movie.id)}>Edit</button>
                                <button onClick={() => handleDelete(movie.id)}>Delete</button>
                            </div>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default MovieAdmin;
