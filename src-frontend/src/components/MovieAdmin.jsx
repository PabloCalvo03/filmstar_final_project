import React, { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';

const MovieAdmin = () => {
    const user = useSelector(state => state.user);
    const navigate = useNavigate(); 

    const [movies, setMovies] = useState([]);
    const [loading, setLoading] = useState(true);
    const [currentPage, setCurrentPage] = useState(0);
    const [hasMore, setHasMore] = useState(true);

    useEffect(() => {
        if(!user) return;

        const fetchMovies = async (page) => {
            try {
                const response = await fetch(`http://localhost:8080/api/backoffice/movies?page=${page}&size=10`, {
                    headers: {
                        Authorization: "Bearer " + user.user.accessToken,
                    }
                });

                if (response.ok) {
                    const data = await response.json();
                    setMovies(prevMovies => {
                        const newMovies = data.movies.filter(newMovie => 
                            !prevMovies.some(movie => movie.id === newMovie.id)
                        );
                        return [...prevMovies, ...newMovies];
                    });
                    setHasMore(data.after !== null);
                } else {
                    console.error('Failed to fetch movies');
                }
            } catch (error) {
                console.error('Error fetching movies:', error);
            } finally {
                setLoading(false);
            }
        };

        fetchMovies(currentPage);
    }, [user, currentPage]);

    const handleEdit = (movieId) => {
        navigate(`/edit-movie/${movieId}`);
    };

    const handleAction = async (movieId, status) => {
        const confirmAction = window.confirm(`Are you sure you want to ${status === 'AVAILABLE' ? 'deactivate' : 'activate'} this movie?`);
        if (!confirmAction) return;
    
        try {
            const response = await fetch(`http://localhost:8080/api/backoffice/movies/${movieId}/${status === 'AVAILABLE' ? 'deactivate' : 'activate'}`, {
                method: 'POST',
                headers: {
                    Authorization: "Bearer " + user.user.accessToken,
                }
            });
            if (response.ok) {
                console.log('Movie action successful');
                const updatedMovies = movies.map(movie => {
                    if (movie.id === movieId) {
                        return {
                            ...movie,
                            status: status === 'AVAILABLE' ? 'UNAVAILABLE' : 'AVAILABLE'
                        };
                    }
                    return movie;
                });
                setMovies(updatedMovies);
            } else {
                console.error('Failed to perform movie action');
            }
        } catch (error) {
            console.error('Error performing movie action:', error);
        }
    };

    const handleScroll = () => {
        if ((window.innerHeight + document.documentElement.scrollTop) >= document.documentElement.offsetHeight - 1) {
            if (hasMore && !loading) {
                setCurrentPage(prevPage => prevPage + 1);
            }
        }
    };

    useEffect(() => {
        window.addEventListener('scroll', handleScroll);
        return () => window.removeEventListener('scroll', handleScroll);
    }, [hasMore, loading]);

    if (loading && movies.length === 0) {
        return <div>Loading...</div>;
    }

    return (
        <div className="py-2">
            <h1 className="text-3xl font-semibold pb-4 text-gray-800 dark:text-white">Movie List</h1>
            {movies.length === 0 ? (
                <p className="text-gray-600 dark:text-gray-300">No movies found.</p>
            ) : (
                <ul className="space-y-4">
                    {movies.map(movie => (
                        <li key={movie.id} className="flex bg-white dark:bg-gray-800 items-center justify-between py-2 px-4 border border-gray-300 dark:border-gray-700 rounded-lg">
                            <div>
                                <h2 className="text-lg font-semibold text-gray-800 dark:text-white">{movie.title}</h2>
                                <p className="text-gray-600 dark:text-gray-300">{movie.overview}</p>
                            </div>
                            <div className="flex-shrink-0">
                                <button onClick={() => handleEdit(movie.id)} className="text-blue-500 hover:text-blue-700 dark:text-blue-400 dark:hover:text-blue-300">Edit</button>
                                <button onClick={() => handleAction(movie.id, movie.status)} className={`ml-2 ${
                                    movie.status === 'AVAILABLE' ? 'text-red-500 hover:text-red-700 dark:text-red-400 dark:hover:text-red-300' : 'text-green-500 hover:text-green-700 dark:text-green-400 dark:hover:text-green-300'
                                }`}>
                                    {movie.status === 'AVAILABLE' ? 'Deactivate' : 'Activate'}
                                </button>
                            </div>
                        </li>
                    ))}
                    {loading && movies.length > 0 && <div>Loading more movies...</div>}
                </ul>
            )}
        </div>
    );
};

export default MovieAdmin;
