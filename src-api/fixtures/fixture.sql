USE filmstar_db;

-- Insertar director 1
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f29b4e-ef47-11ec-8ea0-0242ac120002', 'Christopher', 'Nolan', 'AVAILABLE');

-- Insertar director 2
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f29f10-ef47-11ec-8ea0-0242ac120002', 'Quentin', 'Tarantino', 'AVAILABLE');

-- Insertar director 3
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2a0d0-ef47-11ec-8ea0-0242ac120002', 'Francis Ford', 'Coppola', 'AVAILABLE');

-- Insertar director 4
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2a290-ef47-11ec-8ea0-0242ac120002', 'Steven', 'Spielberg', 'AVAILABLE');

-- Insertar director 5
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2a458-ef47-11ec-8ea0-0242ac120002', 'Martin', 'Scorsese', 'AVAILABLE');

-- Insertar director 6
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2a618-ef47-11ec-8ea0-0242ac120002', 'Alfred', 'Hitchcock', 'AVAILABLE');

-- Insertar director 7
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2a7d8-ef47-11ec-8ea0-0242ac120002', 'Stanley', 'Kubrick', 'AVAILABLE');

-- Insertar director 8
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2a998-ef47-11ec-8ea0-0242ac120002', 'James', 'Cameron', 'AVAILABLE');

-- Insertar director 9
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2ab58-ef47-11ec-8ea0-0242ac120002', 'Peter', 'Jackson', 'AVAILABLE');

-- Insertar director 10
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2ad18-ef47-11ec-8ea0-0242ac120002', 'Ridley', 'Scott', 'AVAILABLE');

-- Insertar director 11
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2aed8-ef47-11ec-8ea0-0242ac120002', 'David', 'Fincher', 'AVAILABLE');

-- Insertar director 12
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2b098-ef47-11ec-8ea0-0242ac120002', 'Tim', 'Burton', 'AVAILABLE');

-- Insertar director 13
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2b258-ef47-11ec-8ea0-0242ac120002', 'Clint', 'Eastwood', 'AVAILABLE');

-- Insertar director 14
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2b418-ef47-11ec-8ea0-0242ac120002', 'George', 'Lucas', 'AVAILABLE');

-- Insertar director 15
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2b5d8-ef47-11ec-8ea0-0242ac120002', 'Michael', 'Bay', 'AVAILABLE');

-- Insertar director 16
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2b798-ef47-11ec-8ea0-0242ac120002', 'Woody', 'Allen', 'AVAILABLE');

-- Insertar director 17
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2b958-ef47-11ec-8ea0-0242ac120002', 'Akira', 'Kurosawa', 'AVAILABLE');

-- Insertar director 18
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2bb18-ef47-11ec-8ea0-0242ac120002', 'Hayao', 'Miyazaki', 'AVAILABLE');

-- Insertar director 19
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2bcd8-ef47-11ec-8ea0-0242ac120002', 'Joel', 'Coen', 'AVAILABLE');

-- Insertar director 20
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2be98-ef47-11ec-8ea0-0242ac120002', 'Frank', 'Darabont', 'AVAILABLE');

-- Insertar director 21
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2c058-ef47-11ec-8ea0-0242ac120002', 'Ethan', 'Coen', 'AVAILABLE');

-- Insertar director 22
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2c218-ef47-11ec-8ea0-0242ac120002', 'Robert', 'Zemeckis', 'AVAILABLE');

-- Insertar director 23
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2c3d8-ef47-11ec-8ea0-0242ac120002', 'Lana', 'Wachowski', 'AVAILABLE');

-- Insertar director 24
INSERT INTO directors (id, name, surname, status)
VALUES ('d1f2c598-ef47-11ec-8ea0-0242ac120002', 'Jonathan', 'Demme', 'AVAILABLE');

-- Insertar película 1
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('59ef30c4-8c7d-4578-a178-865477220fb9', 'Inception', 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.', 'https://image.tmdb.org/t/p/w1280/edv5CZvWj09upOsy2Y6IwDhK8bt.jpg', 'd1f29b4e-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 2010);

-- Insertar película 2
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('af8f515f-0b27-4e0f-9077-5f067f684803', 'The Dark Knight', 'When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.', 'https://www.themoviedb.org/t/p/w1280/qJ2tW6WMUDux911r6m7haRef0WH.jpg', 'd1f29b4e-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 2008);

-- Insertar película 3
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('e0227007-e477-4f99-9fbe-e559c875f1e8', 'Pulp Fiction', 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.', 'https://www.themoviedb.org/t/p/w1280/vQWk5YBFWF4bZaofAbv0tShwBvQ.jpg', 'd1f29f10-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 1994);

-- Insertar película 4
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('de60b4a3-7fa8-46e2-a965-0b15ef13d41b', 'The Godfather', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', 'https://www.themoviedb.org/t/p/w1280/3Tf8vXykYhzHdT0BtsYTp570JGQ.jpg', 'd1f2a0d0-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 1972);

-- Insertar película 5
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('a162f139-36b3-45cd-b913-69bcb77c460a', 'Schindler''s List', 'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.', 'https://www.themoviedb.org/t/p/w1280/sF1U4EUQS8YHUYjNl3pMGNIQyr0.jpg', 'd1f2a290-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 1993);

-- Insertar película 6
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('07f82ea9-f259-4f21-805b-a46c72c6ff7d', 'The Shawshank Redemption', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', 'https://www.themoviedb.org/t/p/w1280/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg', 'd1f2be98-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 1994);

-- Insertar película 7
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('8e45e514-1428-4b70-955d-c32cd75619d5', 'Fight Club', 'An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.', 'https://www.themoviedb.org/t/p/w1280/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg', 'd1f2aed8-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 1999);

-- Insertar película 8
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('c0e9a308-c56d-4f1a-9799-469e9a788c03', 'Forrest Gump', 'The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.', 'https://www.themoviedb.org/t/p/w1280/arw2vcBveWOVZr6pxd9XTd1TdQa.jpg', 'd1f2c218-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 1994);

-- Insertar película 9
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('3f6ad4a0-67ad-41a1-bfc2-9ab8de11e4b6', 'The Matrix', 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.', 'https://www.themoviedb.org/t/p/w1280/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg', 'd1f2c3d8-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 1999);

-- Insertar película 10
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('60f65e33-0123-4f4f-9703-9e9c015f9ef2', 'The Lord of the Rings: The Fellowship of the Ring', 'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.', 'https://www.themoviedb.org/t/p/w1280/6oom5QYQ2yQTMJIbnvbkBL9cHo6.jpg', 'd1f2ab58-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 2001);

-- Insertar película 11
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('650a62c8-69de-480d-99a1-9285cd4b079a', 'The Departed', 'An undercover cop and a mole in the police attempt to identify each other while infiltrating an Irish gang in South Boston.', 'https://www.themoviedb.org/t/p/w1280/nT97ifVT2J1yMQmeq20Qblg61T.jpg', 'd1f2a458-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 2006);

-- Insertar película 12
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('076707b8-1a0d-44f2-98ec-fa2fdb3cd864', 'Goodfellas', 'The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate.', 'https://www.themoviedb.org/t/p/w1280/aKuFiU82s5ISJpGZp7YkIr3kCUd.jpg', 'd1f2a458-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 1990);

-- Insertar película 13
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('076707b8-1a0d-44f2-98ec-fa2fdb3cd861', 'The Silence of the Lambs', 'A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.', 'https://www.themoviedb.org/t/p/w1280/uS9m8OBk1A8eM9I042bx8XXpqAq.jpg', 'd1f2c598-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 1991);

-- Insertar película 14
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('45b9156c-01d2-4000-96b5-4365c4f81fce', 'Saving Private Ryan', 'Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.', 'https://www.themoviedb.org/t/p/w1280/uqx37cS8cpHg8U35f9U5IBlrCV3.jpg', 'd1f2a290-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 1998);

-- Insertar película 15
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES ('6759cbbe-b568-441f-8733-7e03dd5fe2fa', 'The Green Mile', 'The lives of guards on Death Row are affected by one of their charges: a black man accused of child murder and rape, yet who has a mysterious gift.', 'https://www.themoviedb.org/t/p/w1280/8VG8fDNiy50H4FedGwdSVUPoaJe.jpg', 'd1f2be98-ef47-11ec-8ea0-0242ac120002', 'AVAILABLE', 1999);

-- Insertar usuario
INSERT INTO users (id, email, username, password, role)
VALUES (1, 'pablocalvoj@gmail.com', 'PabloCalvo03', '$2a$12$bWFyGjTfr2Kjy1VEo9xlSOtmGjPaSNHUm3nTYPBeFVRW5x3zxXTv2', 'USER');

-- Insertar usuario administrador
INSERT INTO users (id, email, username, password, role)
VALUES (2, 'adminuser@gmail.com', 'AdminUser', '$2a$12$bWFyGjTfr2Kjy1VEo9xlSOtmGjPaSNHUm3nTYPBeFVRW5x3zxXTv2', 'ADMIN');

