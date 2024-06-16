import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

const Signup = () => {
  const navigate = useNavigate();
  const [email, setEmail] = useState('');
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [invitationCode, setInvitationCode] = useState('');
  const [error, setError] = useState('');
  const [isSubmitting, setIsSubmitting] = useState(false);

  const validateEmail = (email) => {
    const emailRegex = /^[a-zA-Z0-9_+&*-]+(?:\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,7}$/;
    return emailRegex.test(email);
  };

  const validatePassword = (password) => {
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{10,}$/;
    return passwordRegex.test(password);
  };

  const validateForm = () => {
    if (!email || !username || !password || !invitationCode) {
      setError('Please fill out all fields.');
      return false;
    }
    if (!validateEmail(email)) {
      setError('Please enter a valid email.');
      return false;
    }
    if (!validatePassword(password)) {
      setError('Password must be at least 10 characters long, including one uppercase letter, one lowercase letter, and one digit.');
      return false;
    }
    return true;
  };

  const handleSignup = async () => {
    if (!validateForm()) return;

    setIsSubmitting(true);

    try {
      const response = await fetch('http://localhost:8080/api/signup', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email, username, password, invitationCode }),
      });

      if (!response.ok) {
        const errorData = await response.json();
        if (errorData.message === 'Invalid invitation code') {
          throw new Error('Invalid invitation code.');
        }
        throw new Error('Could not complete the registration.');
      }
      navigate('/login');
    } catch (error) {
      setError(error.message);
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100 dark:bg-zinc-900 dark:text-white">
      <div className="bg-white dark:bg-gray-800 p-8 rounded-lg shadow-md w-80">
        <h2 className="text-2xl font-bold mb-4 text-center text-black dark:text-white">Sign Up</h2>
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          className="dark:bg-gray-700 dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg px-3 py-2 mb-4 focus:outline-none focus:border-blue-500 w-full"
        />
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          className="dark:bg-gray-700 dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg px-3 py-2 mb-4 focus:outline-none focus:border-blue-500 w-full"
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          className="dark:bg-gray-700 dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg px-3 py-2 mb-4 focus:outline-none focus:border-blue-500 w-full"
        />
        <input
          type="text"
          placeholder="Invitation Code"
          value={invitationCode}
          onChange={(e) => setInvitationCode(e.target.value)}
          className="dark:bg-gray-700 dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg px-3 py-2 mb-4 focus:outline-none focus:border-blue-500 w-full"
        />
        {error && <p className="text-red-500 mb-4">{error}</p>}
        <button
          onClick={handleSignup}
          className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600 focus:outline-none focus:bg-blue-600 w-full"
          disabled={isSubmitting}
        >
          {isSubmitting ? 'Signing up...' : 'Sign Up'}
        </button>
        <div className="mt-4 text-center">
          <Link to="/login" className="text-blue-400 hover:underline">Already have an account? Log in</Link>
        </div>
      </div>
    </div>
  );
};

export default Signup;
