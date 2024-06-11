import React, { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';

const DirectorAdmin = () => {
    const user = useSelector(state => state.user);
    const navigate = useNavigate();

    const [directors, setDirectors] = useState([]);
    const [loading, setLoading] = useState(true);
    const [currentPage, setCurrentPage] = useState(0);
    const [hasMore, setHasMore] = useState(true);

    useEffect(() => {
        if (!user) return;

        const fetchDirectors = async (page) => {
            try {
                const response = await fetch(`http://localhost:8080/api/backoffice/directors?page=${page}&size=20`, {
                    headers: {
                        Authorization: "Bearer " + user.user.accessToken,
                    }
                });

                if (response.ok) {
                    const data = await response.json();
                    setDirectors(prevDirectors => {
                        const newDirectors = data.directors.filter(newDirector => 
                            !prevDirectors.some(director => director.id === newDirector.id)
                        );
                        return [...prevDirectors, ...newDirectors];
                    });
                    setHasMore(data.after !== null);
                } else {
                    console.error('Failed to fetch directors');
                }
            } catch (error) {
                console.error('Error fetching directors:', error);
            } finally {
                setLoading(false);
            }
        };

        fetchDirectors(currentPage);
    }, [user, currentPage]);

    const handleEdit = (directorId) => {
        navigate(`/edit-director/${directorId}`);
    };

    const handleAction = async (directorId, status) => {
        const confirmAction = window.confirm(`Are you sure you want to ${status === 'AVAILABLE' ? 'deactivate' : 'activate'} this director?`);
        if (!confirmAction) return;

        try {
            const response = await fetch(`http://localhost:8080/api/backoffice/directors/${directorId}/${status === 'AVAILABLE' ? 'deactivate' : 'activate'}`, {
                method: 'POST',
                headers: {
                    Authorization: "Bearer " + user.user.accessToken,
                }
            });

            if (response.ok) {
                const updatedDirectors = directors.map(director => {
                    if (director.id === directorId) {
                        return {
                            ...director,
                            status: status === 'AVAILABLE' ? 'UNAVAILABLE' : 'AVAILABLE'
                        };
                    }
                    return director;
                });
                setDirectors(updatedDirectors);
            } else {
                console.error('Failed to perform director action');
            }
        } catch (error) {
            console.error('Error performing director action:', error);
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

    if (loading && directors.length === 0) {
        return <div>Loading...</div>;
    }

    return (
        <div className="py-2">
            <h1 className="text-3xl font-semibold pb-4 text-gray-800 dark:text-white">Director List</h1>
            {directors.length === 0 ? (
                <p className="text-gray-600 dark:text-gray-300">No directors found.</p>
            ) : (
                <ul className="space-y-4">
                    {directors.map(director => (
                        <li key={director.id} className="flex bg-white dark:bg-gray-800 items-center justify-between py-2 px-4 border border-gray-300 dark:border-gray-700 rounded-lg">
                            <div>
                                <h2 className="text-lg font-semibold text-gray-800 dark:text-white">{director.name} {director.surname}</h2>
                                <p className="text-gray-600 dark:text-gray-300">ID: {director.id}</p> {/* Mostrar el ID del director */}
                            </div>
                            <div className="flex-shrink-0">
                                <button onClick={() => handleEdit(director.id)} className="text-blue-500 hover:text-blue-700 dark:text-blue-400 dark:hover:text-blue-300">Edit</button>
                                <button onClick={() => handleAction(director.id, director.status)} className={`ml-2 ${
                                    director.status === 'AVAILABLE' ? 'text-red-500 hover:text-red-700 dark:text-red-400 dark:hover:text-red-300' : 'text-green-500 hover:text-green-700 dark:text-green-400 dark:hover:text-green-300'
                                }`}>
                                    {director.status === 'AVAILABLE' ? 'Deactivate' : 'Activate'}
                                </button>
                            </div>
                        </li>
                    ))}
                    {loading && directors.length > 0 && <div>Loading more directors...</div>}
                </ul>
            )}
        </div>
    );
};

export default DirectorAdmin;
