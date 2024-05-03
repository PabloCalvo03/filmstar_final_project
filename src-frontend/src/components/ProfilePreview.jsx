import { useEffect, useState } from "react";
import { useSelector } from "react-redux";

const ProfilePreview = ({ avatar}) => {
    const user = useSelector(state => state.user);
    const [userProfile, setUserProfile] = useState(null);
    useEffect(() => {
      if(!user) return;
        fetch(`http://localhost:8080/api/users/me`, {
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
          
          .then((data) => {setUserProfile(data)})
          
          .catch(error => console.error('Error fetching user:', error));
      }, [user]);

    return (
        <>{userProfile && (
            <div className="flex pb-[15px]">
              <img src={avatar} alt="Avatar" className="w-[35px] rounded-lg" />
              <div className="flex flex-col ml-[15px] justify-around">
                <h3 className="font-bold text-[12px] dark:text-white">{userProfile.username}</h3>
                <p className="text-[#111111] text-[12px] dark:text-white">{userProfile.email}</p>
              </div>
            </div>
          )}
        </>
    );
};

export default ProfilePreview;