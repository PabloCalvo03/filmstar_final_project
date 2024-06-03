import { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { login } from '../redux/actions/userActions';
import { useNavigate } from 'react-router-dom'; // Importa useNavigate desde react-router-dom

const UserTokenLoader = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate(); // Obtiene la función de navegación

  useEffect(() => {
    const user = JSON.parse(localStorage.getItem('user'));
    if (user) {
      // Convertir expirationDate a un objeto Date
      const expirationDate = new Date(user.expirationDate);
      
      // Verificar si el token ha expirado
      if (expirationDate.getTime() <= new Date().getTime()) {
        // Token ha expirado, borrar del localStorage y redirigir al usuario al inicio de sesión
        localStorage.removeItem('user');
        navigate('/login'); // Redirige al usuario a la ruta de inicio de sesión
      } else {
        // Token válido, iniciar sesión
        dispatch(login({ accessToken: user.accessToken, expirationDate: user.expirationDate, role: user.role }));
      }
    }
  }, [dispatch, navigate]); 

  return null;
};

export default UserTokenLoader;
