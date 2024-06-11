import React, { useState } from 'react';
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { v4 as uuidv4 } from 'uuid';

const DirectorForm = () => {
    const user = useSelector(state => state.user);
    const navigate = useNavigate(); 

    const [directorData, setDirectorData] = useState({
        name: '',
        surname: ''
    });
    const [errors, setErrors] = useState({});

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
        } else if (directorData.name.length > 50) {
            newErrors.name = 'Name cannot exceed 50 characters';
        }

        if (!directorData.surname) {
            newErrors.surname = 'Surname is required';
        } else if (directorData.surname.length > 50) {
            newErrors.surname = 'Surname cannot exceed 50 characters';
        }

        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!validateForm()) {
            return;
        }

        const id = uuidv4();
        const directorDataWithId = { id, ...directorData };

        const response = await fetch('http://localhost:8080/api/backoffice/directors', {
            method: 'POST',
            headers: {
                Authorization: "Bearer " + user.user.accessToken,
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(directorDataWithId)
        });

        if (response.ok) {
            const data = await response.json();
            console.log('Director created:', data);
            navigate('/'); 
        } else {
            const errorData = await response.json();
            console.error('Error creating director:', errorData);
        }
    };

    return (
        <div className='py-2'>
            <h1 className="text-3xl font-[600] dark:text-white pb-2">Create Director</h1>
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
                            className="block w-full p-4 text-sm text-gray-900 border border-gray-300 rounded-lg bg-white focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                            placeholder={field.placeholder}
                            value={directorData[field.id]}
                            onChange={handleChange}
                        />
                        {errors[field.id] && <p className="text-red-500 text-xs mt-1">{errors[field.id]}</p>}
                    </div>
                ))}
                <button type="submit" className="w-full px-4 py-2 text-sm font-medium text-white bg-blue-500 rounded-lg hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-opacity-50">
                    Create
                </button>
            </form>
        </div>
    );
};

export default DirectorForm;
