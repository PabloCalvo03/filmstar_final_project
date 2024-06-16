import React, { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import { useNavigate, useParams } from 'react-router-dom';

const DirectorEditForm = () => {
    const user = useSelector(state => state.user);
    const navigate = useNavigate();
    const { directorId } = useParams(); // Cambié a directorId
    console.log(directorId);
    
    const [directorData, setDirectorData] = useState({
        id: '',
        name: '',
        surname: ''
    });
    const [errors, setErrors] = useState({});

    useEffect(() => {
        if (!user) return;
        const fetchDirectorData = async () => {
            try {
                const response = await fetch(`http://localhost:8080/api/filmstar/directors/${directorId}`, {
                    headers: {
                        'Authorization': `Bearer ${user.user.accessToken}`
                    }
                });
                if (!response.ok) {
                    throw new Error('Failed to fetch director data');
                }
                const data = await response.json();
                console.log(data);

                setDirectorData({
                    id: data.id,
                    name: data.name,
                    surname: data.surname
                });
            } catch (error) {
                console.error(error);
            }
        };
        fetchDirectorData();
    }, [directorId, user]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setDirectorData({
            ...directorData,
            [name]: value
        });
    };

    const validateForm = () => {
        let newErrors = {};

        if (!directorData.name) {
            newErrors.name = 'Name is required';
        } else if (directorData.name.length > 30) {
            newErrors.name = 'Name cannot exceed 30 characters';
        }

        if (!directorData.surname) {
            newErrors.surname = 'Surname is required';
        } else if (directorData.surname.length > 30) {
            newErrors.surname = 'Surname cannot exceed 30 characters';
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
            const response = await fetch(`http://localhost:8080/api/backoffice/directors`, {
                method: 'PUT', 
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${user.user.accessToken}`
                },
                body: JSON.stringify(directorData)
            });

            if (!response.ok) {
                throw new Error('Failed to update director');
            }

            navigate('/');
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div className='py-2'>
            <h1 className="text-3xl font-semibold dark:text-white pb-2">Edit Director</h1>
            <form onSubmit={handleSubmit} className="w-full mx-auto py-2" noValidate>
                {[
                    { id: 'name', label: 'Name', placeholder: 'Enter director name...' },
                    { id: 'surname', label: 'Surname', placeholder: 'Enter director surname...' }
                ].map((field) => (
                    <div key={field.id} className="relative mb-4">
                        <input
                            type="text"
                            id={field.id}
                            name={field.id}
                            value={directorData[field.id]}
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

export default DirectorEditForm;
