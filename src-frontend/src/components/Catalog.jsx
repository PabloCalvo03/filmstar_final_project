import { useEffect, useState } from "react";
import { useSelector } from 'react-redux'; // Importar useSelector para acceder al estado de Redux
import SearchBar from "./SearchBar";
import MovieCard from "./MovieCard";

const Main = () => {
  const user = useSelector(state => state.user);
  const [movies, setMovies] = useState([]);
  useEffect(() => {
    if (!user) return; // Salir si no hay un token de usuario
    fetch("http://localhost:8080/api/movierecords/movies", {
      headers: {
        Authorization: "Bearer " + user.user.accessToken, // Usar el token de usuario en la cabecera de autorización
      },
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => setMovies(data))
      .catch(error => console.error('Error fetching movies:', error));
  }, [user]);

  const fetchSearch = async (inputValue, abortController) => {
    if(!user) return
    try {
      const response = await fetch(`http://localhost:8080/api/movierecords/movies/query?query=${inputValue}`, {
        signal: abortController.signal,
        headers: {
          Authorization: "Bearer " + user.user.accessToken // Agregar el token de acceso al encabezado de autorización
        }
      });

      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
  
      const data = await response.json();
      setMovies(data);
    } catch (error) {
      if (error.name === 'AbortError') {
        // La solicitud fue cancelada
        console.log('Search request was aborted');
      } else {
        // Error de red u otro error
        console.error('Error searching movies:', error);
      }
    }
  };

  return (
    
      <div className="py-2">
        <h1 className="text-3xl font-[600] dark:text-white">Explore</h1>
        <br />
        <SearchBar by="title" setMovies={setMovies} fetchSearch={fetchSearch}></SearchBar>
        <br />
        <div className="grid grid-cols-2 gap-4 lg:grid-cols-5 md:grid-cols-2 justify-items-center">
          {movies.map((movie) => <MovieCard movie={movie} key={movie.id}/>)}
        </div>
      </div>
  );
};

export default Main;