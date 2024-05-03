import { useState } from 'react';
import { Link } from 'react-router-dom';

const MovieCard = ({ movie }) => {
  const maxLength = 20;
  const truncatedTitle =
    movie.title.length > maxLength
      ? movie.title.substring(0, maxLength) + '...'
      : movie.title;

  const [imageLoaded, setImageLoaded] = useState(false);

  const handleImageLoad = () => {
    setImageLoaded(true);
  };

  return (
    <Link to={`/movie/${movie.id}`} className="block w-full h-full">
      <div
        className={`max-w-sm bg-gray-200 border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700 ${
          imageLoaded ? '' : 'hidden'
        }`}
      >
        <img
          className={`w-full h-auto rounded-t-lg ${!imageLoaded ? 'hidden' : ''}`}
          src={movie.posterImg}
          alt={movie.title}
          onLoad={handleImageLoad}
        />
        <div className="p-4 text-center">
          <h5 className="mb-2 text-base sm:text-sm md:text-md lg:text-md font-bold text-gray-900 dark:text-white truncate">
            {/* Aquí se aplican las clases responsivas con el tamaño del texto de menor a mayor */}
            {truncatedTitle}
          </h5>
        </div>
      </div>
    </Link>
  );
};

export default MovieCard;
