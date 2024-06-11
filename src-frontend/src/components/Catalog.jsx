import React, { useEffect, useState, useRef } from "react";
import { useSelector } from 'react-redux';
import SearchBar from "./SearchBar";
import MovieCard from "./MovieCard";

const Main = () => {
  const user = useSelector(state => state.user);
  const [movies, setMovies] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [currentPage, setCurrentPage] = useState(0);
  const [hasMore, setHasMore] = useState(true);
  const [isSearching, setIsSearching] = useState(false);
  const [searchQuery, setSearchQuery] = useState('');
  const fetchingRef = useRef(false);

  useEffect(() => {
    if (user) fetchMovies(0, true);
  }, [user]);

  const fetchMovies = async (page, reset = false) => {
    if (!user || fetchingRef.current || (isSearching && page > 0)) return;
  
    fetchingRef.current = true;
    setIsLoading(true);
  
    try {
      let url = `http://localhost:8080/api/filmstar/movies?page=${page}&size=10`;
      if (isSearching && page === 0) {
        url = `http://localhost:8080/api/filmstar/movies/query?query=${searchQuery}&page=${page}&size=10`;
      }
  
      const response = await fetch(url, {
        headers: {
          Authorization: `Bearer ${user.user.accessToken}`,
        },
      });
  
      if (!response.ok) throw new Error("Network response was not ok");
  
      const data = await response.json();
      const fetchedMovies = data.movies || [];
  
      // Filtrar películas duplicadas antes de actualizar el estado
      const uniqueMovies = reset
        ? fetchedMovies
        : fetchedMovies.filter(movie => !movies.some(existingMovie => existingMovie.id === movie.id));
  
      setMovies(prevMovies => reset ? uniqueMovies : [...prevMovies, ...uniqueMovies]);
      setHasMore(data.after !== null);
      setCurrentPage(page);
    } catch (error) {
      console.error('Error fetching movies:', error);
    } finally {
      setIsLoading(false);
      fetchingRef.current = false;
    }
  };
  
  
  
  const fetchSearch = async (inputValue) => { // Simplificado, no necesitamos abortController aquí
    if (!user) return;

    setIsSearching(true);
    setIsLoading(true);
    setSearchQuery(inputValue); // Actualizar la consulta de búsqueda

    try {
      const response = await fetch(`http://localhost:8080/api/filmstar/movies/query?query=${inputValue}&page=0&size=10`, {
        headers: {
          Authorization: `Bearer ${user.user.accessToken}`,
        },
      });

      if (!response.ok) throw new Error("Network response was not ok");

      const data = await response.json();
      const searchedMovies = data.movies || [];

      setMovies(searchedMovies);
      setHasMore(data.after !== null);
      setCurrentPage(0);
    } catch (error) {
      console.error('Error searching movies:', error);
    } finally {
      setIsLoading(false);
      setIsSearching(false);
    }
  };  

  const handleSearch = (inputValue) => {
    setSearchQuery(inputValue);
    setIsSearching(true);
    setCurrentPage(0);
    fetchSearch(inputValue); // Llamar a fetchSearch aquí para realizar la búsqueda
  };

  const handleScroll = () => {
    if (!isLoading && !isSearching && hasMore && (window.innerHeight + document.documentElement.scrollTop) >= document.documentElement.offsetHeight - 1) {
      setCurrentPage(prevPage => prevPage + 1);
    }
  };

  useEffect(() => {
    window.addEventListener('scroll', handleScroll);
    return () => window.removeEventListener('scroll', handleScroll);
  }, [isLoading, hasMore, isSearching]);

  useEffect(() => {
    if (!isSearching && currentPage > 0) {
      fetchMovies(currentPage);
    }
  }, [currentPage, isSearching, searchQuery]); // Añadir searchQuery como dependencia

  return (
    <div className="py-2">
      <h1 className="text-3xl font-[600] dark:text-white">Explore</h1>
      <br />
      <SearchBar by="title" setMovies={setMovies} fetchSearch={fetchSearch} handleSearch={handleSearch}></SearchBar> {/* Pasar handleSearch aquí */}
      <br />
      {isLoading && movies.length === 0 ? (
        <p>Loading movies...</p>
      ) : (
        <div className="grid grid-cols-2 gap-4 lg:grid-cols-5 md:grid-cols-2 place-items-center">
          {movies.length === 0 ? (
            <p className="text-black dark:text-white">No movies found.</p>
          ) : (
            movies.map((movie) => (
              <MovieCard movie={movie} key={movie.id} />
            ))
          )}
        </div>
      )}
      {isLoading && movies.length > 0 && <p>Loading more movies...</p>}
    </div>
  );
}

export default Main;
