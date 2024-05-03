// store.js
import { createStore, combineReducers } from 'redux';

// Reducer para el estado del usuario
const userReducer = (state = null, action) => {
  switch (action.type) {
    case 'LOGIN':
      return action.payload;
    case 'LOGOUT':
      return null;
    default:
      return state;
  }
};

// Combinar todos los reducers
const rootReducer = combineReducers({
  user: userReducer,
});

// Crear el store de Redux
const store = createStore(rootReducer);

export default store;
