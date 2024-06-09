import React, { useState, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { login } from '../redux/actions/userActions';
import { useNavigate, Link } from 'react-router-dom';

const Login = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const user = useSelector(state => state.user);
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  useEffect(() => {
    if (user) {
      navigate('/home');
    }
  }, [user, navigate]);

  const handleLogin = async () => {
    // Validate that the username and password fields are not empty
    if (!username || !password) {
      setError('Please fill in both username and password.');
      return;
    }

    try {
      const response = await fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
      });

      if (response.status === 401) {
        throw new Error('Incorrect username or password.');
      }

      if (!response.ok) {
        throw new Error('Something went wrong. Please try again later.');
      }

      const userData = await response.json();
      dispatch(login(userData));
      
      // Save the token in localStorage
      localStorage.setItem('user', JSON.stringify(userData));
    } catch (error) {
      if (error.message === 'Failed to fetch') {
        setError('Unable to connect to the server. Please check your internet connection and try again.');
      } else {
        setError(error.message);
      }
    }
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100 dark:bg-zinc-900 text-white">
      <div className="bg-white dark:bg-gray-800 p-8 rounded-lg shadow-md w-80">
        <h2 className="text-2xl font-bold mb-4 text-center text-black dark:text-white">Login</h2>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          className="dark:bg-gray-700 text-black dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg px-3 py-2 mb-4 focus:outline-none focus:border-blue-500 w-full"
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          className="dark:bg-gray-700 text-black dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg px-3 py-2 mb-4 focus:outline-none focus:border-blue-500 w-full"
        />
        {error && <p className="text-red-500 mb-4">{error}</p>}
        <button
          onClick={handleLogin}
          className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600 focus:outline-none focus:bg-blue-600 w-full"
        >
          Login
        </button>
        <div className="mt-4 text-center">
          <Link to="/signup" className="text-blue-400 hover:underline">Sign up with invitation code</Link>
        </div>
      </div>
    </div>
  );
};

export default Login;
