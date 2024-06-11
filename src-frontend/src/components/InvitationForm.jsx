import { useState } from "react";
import { useSelector } from "react-redux";

const InvitationForm = () => {
    const [firstname, setFirstname] = useState("");
    const [lastname, setLastname] = useState("");
    const [invitationCode, setInvitationCode] = useState("");
    const [errorFirstname, setErrorFirstname] = useState("");
    const [errorLastname, setErrorLastname] = useState("");
    const user = useSelector((state) => state.user);

    const isStringOnlyLetters = (str) => {
        return /^[a-zA-Z]+$/.test(str);
    };

    const validateInputs = () => {
        let valid = true;

        if (!firstname) {
            setErrorFirstname("First name must be provided.");
            valid = false;
        } else if (!isStringOnlyLetters(firstname)) {
            setErrorFirstname("First name must contain only letters.");
            valid = false;
        } else {
            setErrorFirstname("");
        }

        if (!lastname) {
            setErrorLastname("Last name must be provided.");
            valid = false;
        } else if (!isStringOnlyLetters(lastname)) {
            setErrorLastname("Last name must contain only letters.");
            valid = false;
        } else {
            setErrorLastname("");
        }

        return valid;
    };

    const handleFormSubmit = async (e) => {
        e.preventDefault();

        if (!validateInputs()) {
            return;
        }

        try {
            const response = await fetch("http://localhost:8080/api/movierecords/invite-friend", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + user.user.accessToken
                },
                body: JSON.stringify({
                    firstname,
                    lastname
                })
            });

            if (!response.ok) {
                throw new Error("Error al solicitar el código de invitación");
            }

            const data = await response.json();
            setInvitationCode(data.code);
            setErrorFirstname("");
            setErrorLastname("");
        } catch (error) {
            setErrorFirstname(error.message);
        }
    };

    return (
        <>
            <div className="py-2 flex flex-col justify-center items-center h-screen">
                <div className="bg-white dark:bg-gray-800 shadow-md rounded-lg overflow-hidden w-80">
                    <div className="p-6">
                        <h2 className="text-2xl font-bold mb-4 text-center dark:text-white">Invite friend</h2>
                        <form className="flex flex-col" onSubmit={handleFormSubmit}>
                            <div className="mb-4">
                                <input
                                    type="text"
                                    placeholder="Name of the user:"
                                    value={firstname}
                                    onChange={(e) => setFirstname(e.target.value)}
                                    className="dark:bg-gray-700 dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg px-3 py-2 mb-2 focus:outline-none focus:border-blue-500 w-full"
                                />
                                {errorFirstname && <p className="text-red-500 text-sm">{errorFirstname}</p>}
                            </div>
                            <div className="mb-4">
                                <input
                                    type="text"
                                    placeholder="Surname of the user:"
                                    value={lastname}
                                    onChange={(e) => setLastname(e.target.value)}
                                    className="dark:bg-gray-700 dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg px-3 py-2 mb-2 focus:outline-none focus:border-blue-500 w-full"
                                />
                                {errorLastname && <p className="text-red-500 text-sm">{errorLastname}</p>}
                            </div>
                            <button
                                type="submit"
                                className="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded focus:outline-none focus:bg-blue-600"
                            >
                                Invite
                            </button>
                        </form>
                    </div>
                </div>
                {invitationCode && (
                    <div className="flex justify-center items-center mt-4 w-80">
                        <div className="bg-white dark:bg-gray-800 shadow-md rounded-lg overflow-hidden w-80">
                            <div className="p-6">
                                <p className="text-xl font-semibold text-gray-400 mb-2 text-center">Invitation code:</p>
                                <p className="bg-gray-200 dark:bg-gray-600 dark:text-white text-lg px-4 py-2 rounded-md text-center">{invitationCode}</p>
                            </div>
                        </div>
                    </div>
                )}
            </div>
        </>
    );
};

export default InvitationForm;
