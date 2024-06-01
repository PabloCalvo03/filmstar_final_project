import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

const Signup = () => {
  const navigate = useNavigate();
  const [email, setEmail] = useState('');
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [invitationCode, setInvitationCode] = useState('');
  const [error, setError] = useState('');

  const handleSignup = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/signup', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email, username, password, invitationCode }),
      });

      if (!response.ok) {
        throw new Error('Credenciales inválidas');
      }
      navigate('/login');
    } catch (error) {
      setError(error.message);
    }
  };

  return (
    <div className="flex items-center justify-center min-h-screen dark:bg-zinc-900 text-white">
      <div className="bg-gray-800 p-8 rounded-lg shadow-md w-80">
        <h2 className="text-2xl font-bold mb-4 text-center">Registrarse</h2>
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          className="dark:bg-gray-700 dark:text-white border border-gray-900 rounded-lg px-3 py-2 mb-4 focus:outline-none focus:border-blue-500 w-full"
        />
        <input
          type="text"
          placeholder="Nombre de usuario"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          className="dark:bg-gray-700 dark:text-white border border-gray-900 rounded-lg px-3 py-2 mb-4 focus:outline-none focus:border-blue-500 w-full"
        />
        <input
          type="password"
          placeholder="Contraseña"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          className="dark:bg-gray-700 dark:text-white border border-gray-900 rounded-lg px-3 py-2 mb-4 focus:outline-none focus:border-blue-500 w-full"
        />
        <input
          type="text"
          placeholder="Código de invitación"
          value={invitationCode}
          onChange={(e) => setInvitationCode(e.target.value)}
          className="dark:bg-gray-700 dark:text-white border border-gray-900 rounded-lg px-3 py-2 mb-4 focus:outline-none focus:border-blue-500 w-full"
        />
        {error && <p className="text-red-500 mb-4">{error}</p>}
        <button
          onClick={handleSignup}
          className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600 focus:outline-none focus:bg-blue-600 w-full"
        >
          Registrarse
        </button>
        <div className="mt-4 text-center">
          <Link to="/login" className="text-blue-400 hover:underline">Si ya tienes cuenta, inicia sesión</Link>
        </div>
      </div>
    </div>
  );
};

export default Signup;