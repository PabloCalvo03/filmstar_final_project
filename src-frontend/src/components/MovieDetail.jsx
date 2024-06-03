import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { useSelector } from "react-redux";
const MovieDetail = () => {
  const { id } = useParams();
  const user = useSelector((state) => state.user);
  const [movie, setMovie] = useState(null);

  useEffect(() => {
    if (!user) return; // Salir si no hay un token de usuario
    fetch(`http://localhost:8080/api/filmstar/movies/${id}`, {
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
      .then((data) => setMovie(data))
      .catch((error) => console.error("Error fetching movie:", error));
  }, [user]);

  if (!movie) {
    return <h1 className="dark:text-white">La película no se encontró.</h1>;
  }

  // Aquí puedes mostrar los detalles de la película
  return (
    <div className="py-2">
      <div className="max-w-4xl mx-auto">
        <div className="dark:bg-gray-800 shadow-md rounded-lg overflow-hidden">
          <div className="p-4">
            <div className="flex flex-col">
              <div className="flex flex-row justify-center">
                <div className="flex-shrink-0 w-40 h-60 rounded-lg overflow-hidden shadow-2xl">
                  <img
                    src={movie.posterImg}
                    alt={movie.title}
                    className="w-full h-full object-cover rounded-lg"
                  />
                </div>
              </div>

              <br />
              <div>
                <h3 className="text-xl font-semibold mb-2 text-white">
                  {movie.title}
                </h3>
                <p className="text-gray-700 dark:text-gray-300 mb-2">
                  <span className="text-white">Director:</span>{" "}
                  {movie.director.name} {movie.director.surname}
                </p>
                <p className="text-gray-700 dark:text-gray-300 mb-2">
                  <span className="text-white">Year:</span> {movie.year}
                </p>
                <p className="text-gray-700 dark:text-gray-300">
                  {movie.overview}
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default MovieDetail;
