import { useState } from 'react';
import { Link } from 'react-router-dom';
import loadingGif from '../assets/Gif_Loading.gif'; // Ajusta el path según tu estructura de carpetas

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
        className={`max-w-sm border border-gray-200 rounded-lg bg-white shadow dark:bg-gray-800 dark:border-gray-700`}
      >
        {!imageLoaded && (
          <div className="relative w-full h-64 flex justify-center items-center">
            <div className="absolute inset-0 flex flex-col justify-center items-center">
              <img src={loadingGif} alt="Loading..." className="w-16 h-16" />
            </div>
          </div>
        )}
        <img
          className={`w-full rounded-t-lg ${!imageLoaded ? 'hidden' : ''}`}
          src={movie.posterImg}
          alt={movie.title}
          onLoad={handleImageLoad}
        />
        <div className="p-4 text-center">
          <h5 className="mb-2 text-xs sm:text-sm md:text-md lg:text-md font-bold text-gray-900 dark:text-white truncate">
            {truncatedTitle}
          </h5>
        </div>
      </div>
    </Link>
  );
};

export default MovieCard;
