// ./redux/reducers/userReducer.js

// Definir los tipos de acciones
const LOGIN = 'LOGIN';
const LOGOUT = 'LOGOUT';
const GET_USER = 'GET_USER';

// Obtener el estado de usuario almacenado en localStorage si existe
const initialState = {
    user: localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : null,
};

const userReducer = (state = initialState, action) => {
    switch (action.type) {
        case LOGIN:
            localStorage.setItem('user', JSON.stringify(action.payload));
            return {
                ...state,
                user: action.payload,
            };
        case LOGOUT:
            localStorage.removeItem('user');
            return {
                ...state,
                user: null,
            };
        case GET_USER:
            return localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : null;
        default:
            return state;
    }
};

export default userReducer;
