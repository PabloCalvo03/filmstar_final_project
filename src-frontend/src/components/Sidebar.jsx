import ProfilePreview from "./ProfilePreview";
import { logout } from "../redux/actions/userActions"; // Importa la acción de logout
import { useDispatch, useSelector } from "react-redux"; // Importa el hook useDispatch
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

const Sidebar = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const user = useSelector((state) => state.user);

  const [darkMode, setDarkMode] = useState(false);

  const toggleDarkMode = () => {
    const newDarkMode = !darkMode;
    setDarkMode(newDarkMode);
    if (newDarkMode) {
      document.documentElement.classList.add('dark');
      localStorage.setItem('theme', 'dark');
    } else {
      document.documentElement.classList.remove('dark');
      localStorage.setItem('theme', 'light');
    }
  };

  useEffect(() => {
    const savedTheme = localStorage.getItem('theme');
    if (savedTheme === 'dark') {
      setDarkMode(true);
      document.documentElement.classList.add('dark');
    }
  }, []);

  const handleLogout = () => {
    dispatch(logout());
    localStorage.removeItem("user");
    navigate("/login");
  };

  const handleCreateMovie = () => {
    navigate("/create-movie");
  };

  const handleInviteFriend = () => {
    navigate("/invite-friend");
  };

  const handleHome = () => {
    navigate("/home");
  };

  const handleAdminMovies = () => {
    navigate("/admin-movies");
  };

  return (
    <>
      <aside
        id="sidebar-multi-level-sidebar"
        className="fixed top-0 left-0 z-40 w-64 h-screen transition-transform -translate-x-full sm:translate-x-0"
        aria-label="Sidebar"
      >
        <div className="h-full flex flex-col px-3 py-4 overflow-y-auto bg-gray-200 dark:bg-gray-800">
          <ul className="space-y-2 font-medium flex-grow">
            <li>
              <ProfilePreview />
            </li>
            <li>
              <a
                className="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
                onClick={handleHome}
              >
                <svg
                  className="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                  aria-hidden="true"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="currentColor"
                  viewBox="0 0 20 20"
                >
                  <path d="M10 20v-6h4v6h5v-8h3L12 3 2 12h3v8z" />
                </svg>
                <span className="flex-1 ms-3 whitespace-nowrap">Home</span>
              </a>
            </li>
            <hr className="border-black dark:border-white"/>
            {user && user.user.role === "ADMIN" && (
              <>
                <li>
                  <a
                    className="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
                    onClick={handleCreateMovie}
                  >
                    <svg
                      className="w-5 h-5 text-gray-400 dark:text-grey-400"
                      aria-hidden="true"
                      xmlns="http://www.w3.org/2000/svg"
                      width="10"
                      height="20"
                      fill="currentColor"
                      viewBox="0 0 24 20"
                    >
                      <path
                        fillRule="evenodd"
                        d="M7.05 4.05A7 7 0 0 1 19 9c0 2.407-1.197 3.874-2.186 5.084l-.04.048C15.77 15.362 15 16.34 15 18a1 1 0 0 1-1 1h-4a1 1 0 0 1-1-1c0-1.612-.77-2.613-1.78-3.875l-.045-.056C6.193 12.842 5 11.352 5 9a7 7 0 0 1 2.05-4.95ZM9 21a1 1 0 0 1 1-1h4a1 1 0 1 1 0 2h-4a1 1 0 0 1-1-1Zm1.586-13.414A2 2 0 0 1 12 7a1 1 0 1 0 0-2 4 4 0 0 0-4 4 1 1 0 0 0 2 0 2 2 0 0 1 .586-1.414Z"
                        clipRule="evenodd"
                      />
                    </svg>

                    <span className="flex-1 ms-3 whitespace-nowrap">
                      Create Movie
                    </span>
                  </a>
                </li>
                <li>
                  <a
                    className="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
                    onClick={handleAdminMovies}
                  >
                    <svg
                      className="w-5 h-5 text-gray-400 dark:text-grey-400"
                      aria-hidden="true"
                      xmlns="http://www.w3.org/2000/svg"
                      fill="none"
                      viewBox="0 0 24 24"
                      stroke="currentColor"
                    >
                      <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        strokeWidth={2}
                        d="M5 13l4 4L19 7"
                      />
                    </svg>
                    <span className="flex-1 ms-3 whitespace-nowrap">
                      Admin Movies
                    </span>
                  </a>
                </li>
              </>
            )}
            <li>
              <a
                className="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
                onClick={handleInviteFriend}
              ><svg
              className="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
              aria-hidden="true"
              xmlns="http://www.w3.org/2000/svg"
              fill="currentColor"
              viewBox="0 0 20 20"
            >
              <path d="M5 5V.13a2.96 2.96 0 0 0-1.293.749L.879 3.707A2.96 2.96 0 0 0 .13 5H5Z" />
              <path d="M6.737 11.061a2.961 2.961 0 0 1 .81-1.515l6.117-6.116A4.839 4.839 0 0 1 16 2.141V2a1.97 1.97 0 0 0-1.933-2H7v5a2 2 0 0 1-2 2H0v11a1.969 1.969 0 0 0 1.933 2h12.134A1.97 1.97 0 0 0 16 18v-3.093l-1.546 1.546c-.413.413-.94.695-1.513.81l-3.4.679a2.947 2.947 0 0 1-1.85-.227 2.96 2.96 0 0 1-1.635-3.257l.681-3.397Z" />
              <path d="M8.961 16a.93.93 0 0 0 .189-.019l3.4-.679a.961.961 0 0 0 .49-.263l6.118-6.117a2.884 2.884 0 0 0-4.079-4.078l-6.117 6.117a.96.96 0 0 0-.263.491l-.679 3.4A.961.961 0 0 0 8.961 16Zm7.477-9.8a.958.958 0 0 1 .68-.281.961.961 0 0 1 .682 1.644l-.315.315-1.36-1.36.313-.318Zm-5.911 5.911 4.236-4.236 1.359 1.359-4.236 4.237-1.7.339.341-1.699Z" />
            </svg>
                
                <span className="flex-1 ms-3 whitespace-nowrap">
                  Invite friend
                </span>
              </a>
            </li>
            <li>
              <a
                className="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group"
                onClick={handleLogout}
              >
                <svg
                  className="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                  aria-hidden="true"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 18 16"
                >
                  <path
                    stroke="currentColor"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth="2"
                    d="M1 8h11m0 0L8 4m4 4-4 4m4-11h3a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2h-3"
                  />
                </svg>
                <span className="flex-1 ms-3 whitespace-nowrap">Logout</span>
              </a>
            </li>
          </ul>
          <div className="mt-auto pt-4">
            <a
              className="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group w-100"
              onClick={toggleDarkMode}
            >
              {darkMode ? (
                <svg
                  className="flex-shrink-0 w-5 h-5 text-yellow-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                  aria-hidden="true"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="currentColor"
                  viewBox="0 0 20 20"
                >
                  <path
                    fillRule="evenodd"
                    d="M10 18c-4.4183 0-8-3.5817-8-8s3.5817-8 8-8c4.4183 0 8 3.5817 8 8s-3.5817 8-8 8zM0 10c0 5.5229 4.4771 10 10 10s10-4.4771 10-10S15.5229 0 10 0 0 4.4771 0 10z"
                    clipRule="evenodd"
                  />
                  <circle cx="10" cy="10" r="5" />
                </svg>
              ) : (
                <svg
                  className="flex-shrink-0 w-5 h-5 text-gray-900 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                  aria-hidden="true"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="currentColor"
                  viewBox="0 0 20 20"
                >
                  <path
                    fillRule="evenodd"
                    d="M13.79 10.636l3.535-3.536 1.415 1.415-3.535 3.536-1.415-1.415zM10 18c-4.418 0-8-3.582-8-8 0-3.325 2.05-6.168 4.95-7.333a.75.75 0 0 1 .549.02c.148.06.284.142.404.248.513.413.844.972 1.004 1.581.019.098.089.188.187.248C9.834 4.064 9.917 4 10 4c3.309 0 6 2.691 6 6 0 3.309-2.691 6-6 6zm0-14c-4.418 0-8 3.582-8 8 0 3.157 1.857 5.847 4.513 7.083-.029-.023-.057-.048-.086-.071-.142-.113-.264-.247-.367-.395-.316-.43-.506-.972-.546-1.583-.002-.025-.016-.047-.016-.073C6.006 14.24 6 14.122 6 14c0-3.309 2.691-6 6-6 1.18 0 2.274.428 3.117 1.133l.009-.006.014.014c.3.332.705.518 1.15.518 1.104 0 2-.896 2-2 0-.446-.15-.857-.4-1.191l-.031-.044L15.2 4.564 13.79 3.15 12.376 4.564l.426.426C11.266 4.243 10.648 4 10 4z"
                    clipRule="evenodd"
                  />
                </svg>
              )}
              <span className="flex-1 ms-3 whitespace-nowrap">{darkMode ? "Light Mode" : "Dark Mode"}</span>
            </a>
          </div>
        </div>
      </aside>
    </>
  );
};

export default Sidebar;
