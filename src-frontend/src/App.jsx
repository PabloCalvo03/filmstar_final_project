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
import Layout from './layouts/Layout';
import MovieEditForm from './components/MovieEditForm';

function App() {
  return (
    <Router>
      <UserTokenLoader />
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route
          path="/*"
          element={
            <ProtectedRoute>
              <Layout>
                <Routes>
                  <Route path="/home" element={<Home />} />
                  <Route path="/" element={<Home />} />
                  <Route path="/movie/:id" element={<DetailsOfMovie />} />
                  <Route path="/invite-friend" element={<InviteFriend />} />
                  <Route path="/create-movie" element={<ProtectedAdminRoute><CreateMovie /></ProtectedAdminRoute>} />
                  <Route path="/create-movie" element={<ProtectedAdminRoute><MovieEditForm /></ProtectedAdminRoute>} />
                  <Route path="/edit-movie/:movieId" element={<ProtectedAdminRoute><MovieEditForm /></ProtectedAdminRoute>} />
                  <Route path="/admin-movies" element={<ProtectedAdminRoute><AdminMovieCRUD /></ProtectedAdminRoute>} />
                </Routes>
              </Layout>
            </ProtectedRoute>
          }
        />
      </Routes>
    </Router>
  );
}

export default App;