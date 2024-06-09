import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { useSelector } from "react-redux";

const MovieDetail = () => {
  const { id } = useParams();
  const user = useSelector((state) => state.user);
  const [movie, setMovie] = useState(null);
  const [reviews, setReviews] = useState([]);
  const [newReview, setNewReview] = useState("");
  const [userRating, setUserRating] = useState(0);
  const [averageRating, setAverageRating] = useState(0);

  useEffect(() => {
    if (!user) return;

    fetch(`http://localhost:8080/api/filmstar/movies/${id}`, {
      headers: {
        Authorization: "Bearer " + user.user.accessToken,
      },
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        setMovie(data);
        setReviews(data.reviews || []);
        setAverageRating(data.averageRating || 0);
      })
      .catch((error) => console.error("Error fetching movie:", error));
  }, [user, id]);

  const handleReviewSubmit = (event) => {
    event.preventDefault();
    if (!newReview.trim()) return;

    const review = {
      comment: newReview,
    };

    fetch(`http://localhost:8080/api/filmstar/movies/${id}/reviews`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: "Bearer " + user.user.accessToken,
      },
      body: JSON.stringify(review),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        fetchMovieDetails(); // Fetch updated movie details after submitting review
      })
      .catch((error) => console.error("Error adding review:", error));

    setNewReview("");
  };

  const handleRatingSubmit = (event) => {
    event.preventDefault();

    // Send user's rating to the server
    fetch(`http://localhost:8080/api/filmstar/movies/${id}/ratings`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: "Bearer " + user.user.accessToken,
      },
      body: JSON.stringify({ rating: userRating }),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        fetchMovieDetails(); // Fetch updated movie details after submitting rating
      })
      .catch((error) => console.error("Error adding rating:", error));
  };

  const fetchMovieDetails = () => {
    fetch(`http://localhost:8080/api/filmstar/movies/${id}`, {
      headers: {
        Authorization: "Bearer " + user.user.accessToken,
      },
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        setMovie(data);
        setReviews(data.reviews || []);
        setAverageRating(data.averageRating || 0);
      })
      .catch((error) => console.error("Error fetching movie:", error));
  };

  if (!movie) {
    return <h1 className="dark:text-white">La película no se encontró.</h1>;
  }

  // Función para generar los íconos de estrellas basados en el promedio de calificaciones
  const renderRatingStars = (averageRating) => {
    const roundedRating = Math.round(averageRating);
    const stars = [];

    for (let i = 0; i < roundedRating; i++) {
      stars.push(<span key={i} className="text-yellow-500">&#9733;</span>);
    }

    for (let i = roundedRating; i < 10; i++) {
      stars.push(<span key={i} className="text-gray-400">&#9733;</span>);
    }

    return stars;
  };

  // Renderizar el componente con las estrellas
  return (
    <div className="py-2">
      <div className="max-w-4xl mx-auto">
        <div className="bg-white dark:bg-gray-800 shadow-md rounded-lg overflow-hidden">
          <div className="p-4">
            <div className="flex flex-col items-center"> {/* Modificado aquí */}
              <div className="flex-shrink-0 w-40 h-60 rounded-lg overflow-hidden
shadow-2xl">
                <img
                  src={movie.posterImg}
                  alt={movie.title}
                  className="w-full h-full object-cover rounded-lg"
                />
              </div>
              <div className="flex items-center mt-4">
            <span className="mr-1">{renderRatingStars(averageRating)}</span>
            <span className="text-gray-700 dark:text-gray-300">({Math.round(averageRating)})</span>
          </div>
            </div>
            <br />
            <div>
              <h3 className="text-xl font-semibold mb-2 text-gray-700 dark:text-white">
                {movie.title}
              </h3>
              <p className="text-gray-700 dark:text-gray-300 mb-2">
                <span className="text-gray-700 dark:text-white">Director:</span>{" "}
                {movie.director.name} {movie.director.surname}
              </p>
              <p className="text-gray-700 dark:text-gray-300 mb-2">
                <span className="text-gray-700 dark:text-white">Year:</span> {movie.year}
              </p>
              <p className="text-gray-700 dark:text-gray-300">
                {movie.overview}
              </p>
            </div>
          </div>
        </div>
        <div className="bg-white dark:bg-gray-800 shadow-md rounded-lg overflow-hidden mt-4 p-4">
          <h3 className="text-xl font-semibold mb-4 text-gray-700 dark:text-white">Add a Review</h3>
          <form onSubmit={handleReviewSubmit}>
            <div className="mb-4">
              <textarea
                className="w-full p-3 border border-gray-300 dark:border-gray-700 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 dark:bg-gray-700 dark:text-gray-200"
                placeholder="Write your review..."
                value={newReview}
                onChange={(e) => setNewReview(e.target.value)}
              />
            </div>
            <button
              type="submit"
              className="bg-blue-500 text-white px-6 py-2 rounded-lg hover:bg-blue-600 transition duration-300"
            >
              Submit
            </button>
          </form>
        </div>
        <div className="bg-white dark:bg-gray-800 shadow-md rounded-lg overflow-hidden mt-4 p-4">
          <h3 className="text-xl font-semibold mb-4 text-gray-700 dark:text-white">Reviews</h3>
          {reviews.length > 0 ? (
            reviews.map((review) => (
              <div key={review.id} className="mb-4">
                <div className="bg-gray-100 dark:bg-gray-700 p-4 rounded-lg shadow-sm">
                  <p className="text-gray-800 dark:text-gray-100">
                    <strong className="text-blue-600 dark:text-blue-400">{review.reviewer.username.value}</strong>: {review.comment}
                  </p>
                </div>
              </div>
            ))
          ) : (
            <p className="text-gray-700 dark:text-gray-300">No reviews available.</p>
          )}
        </div>
        <div className="bg-white dark:bg-gray-800 shadow-md rounded-lg overflow-hidden mt-4 p-4">
          <h3 className="text-xl font-semibold mb-4 text-gray-700 dark:text-white">Add a Rating</h3>
          <form onSubmit={handleRatingSubmit}>
            <div className="mb-4">
            <input
              type="number"
              min="0"
              max="10"
              step="0.1"
              value={isNaN(userRating) ? '' : userRating} // Si userRating es NaN, establecer cadena vacía
              onChange={(e) => setUserRating(parseFloat(e.target.value))}
              className="w-full p-3 border border-gray-300 dark:border-gray-700 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 dark:bg-gray-700 dark:text-gray-200"
              placeholder="Enter your rating (0-10)"
            />
            </div>
            <button
              type="submit"
              className="bg-blue-500 text-white px-6 py-2 rounded-lg hover:bg-blue-600 transition duration-300"
            >
              Submit Rating
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default MovieDetail;
