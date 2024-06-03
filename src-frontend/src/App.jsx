import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from "./pages/Home";
import Login from "./pages/Login";
import UserTokenLoader from "./loaders/UserTokenLoader"; // Importa el componente UserTokenLoader
import ProtectedRoute from './routes/ProtectedRoute';
import Signup from './pages/Signup';
import DetailsOfMovie from './pages/DetailsOfMovie';
import InviteFriend from './pages/InviteFriend';
import ProtectedAdminRoute from './routes/ProtectedAdminRoute';
import CreateMovie from './pages/CreateMovie';
import AdminMovieCRUD from './pages/AdminMovieCRUD';

function App() {
  return (
    <Router>
      <UserTokenLoader /> 
      <Routes>
      <Route
          path="/home"
          element={
            <ProtectedRoute>
              <Home />
            </ProtectedRoute>
          }
        />
        <Route
          path="/"
          element={
            <ProtectedRoute>
              <Home />
            </ProtectedRoute>
          }
        />
        <Route 
          path="/movie/:id" 
          element={
            <ProtectedRoute>
              <DetailsOfMovie/>
            </ProtectedRoute>
          } 
        />
        <Route 
          path="/invite-friend" 
          element={
            <ProtectedRoute>
              <InviteFriend/>
            </ProtectedRoute>
          } 
        />
        <Route 
          path="/create-movie" 
          element={
            <ProtectedAdminRoute>
              <CreateMovie/>
            </ProtectedAdminRoute>
          } 
        />
        <Route 
          path="/admin-movies" 
          element={
            <ProtectedAdminRoute>
              <AdminMovieCRUD/>
            </ProtectedAdminRoute>
          } 
        />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        </Routes>
    </Router>
  );
}

export default App;