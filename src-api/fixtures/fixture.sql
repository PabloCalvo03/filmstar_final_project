USE filmstar_db;
-- Insertar director 1
INSERT INTO directors (id, name, surname)
VALUES (1, 'Christopher', 'Nolan');

-- Insertar director 2
INSERT INTO directors (id, name, surname)
VALUES (2, 'Quentin', 'Tarantino');

-- Insertar director 3
INSERT INTO directors (id, name, surname)
VALUES (3, 'Francis Ford', 'Coppola');

-- Insertar director 4
INSERT INTO directors (id, name, surname)
VALUES (4, 'Steven', 'Spielberg');

-- Insertar director 5
INSERT INTO directors (id, name, surname)
VALUES (5, 'Martin', 'Scorsese');

-- Insertar director 6
INSERT INTO directors (id, name, surname)
VALUES (6, 'Alfred', 'Hitchcock');

-- Insertar director 7
INSERT INTO directors (id, name, surname)
VALUES (7, 'Stanley', 'Kubrick');

-- Insertar director 8
INSERT INTO directors (id, name, surname)
VALUES (8, 'James', 'Cameron');

-- Insertar director 9
INSERT INTO directors (id, name, surname)
VALUES (9, 'Peter', 'Jackson');

-- Insertar director 10
INSERT INTO directors (id, name, surname)
VALUES (10, 'Ridley', 'Scott');

-- Insertar director 11
INSERT INTO directors (id, name, surname)
VALUES (11, 'David', 'Fincher');

-- Insertar director 12
INSERT INTO directors (id, name, surname)
VALUES (12, 'Tim', 'Burton');

-- Insertar director 13
INSERT INTO directors (id, name, surname)
VALUES (13, 'Clint', 'Eastwood');

-- Insertar director 14
INSERT INTO directors (id, name, surname)
VALUES (14, 'George', 'Lucas');

-- Insertar director 15
INSERT INTO directors (id, name, surname)
VALUES (15, 'Michael', 'Bay');

-- Insertar director 16
INSERT INTO directors (id, name, surname)
VALUES (16, 'Woody', 'Allen');

-- Insertar director 17
INSERT INTO directors (id, name, surname)
VALUES (17, 'Akira', 'Kurosawa');

-- Insertar director 18
INSERT INTO directors (id, name, surname)
VALUES (18, 'Hayao', 'Miyazaki');

-- Insertar director 19
INSERT INTO directors (id, name, surname)
VALUES (19, 'Joel', 'Coen');

-- Insertar director 20
INSERT INTO directors (id, name, surname)
VALUES (20, 'Frank', 'Darabont');

-- Insertar director 21
INSERT INTO directors (id, name, surname)
VALUES (21, 'Ethan', 'Coen');

-- Insertar director 22
INSERT INTO directors (id, name, surname)
VALUES (22, 'Robert', 'Zemeckis');

-- Insertar director 23
INSERT INTO directors (id, name, surname)
VALUES (23, 'Lana', 'Wachowski');

-- Insertar director 24
INSERT INTO directors (id, name, surname)
VALUES (24, 'Jonathan', 'Demme');

-- Insertar película 1
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (1, 'Inception', 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.', 'https://image.tmdb.org/t/p/w1280/edv5CZvWj09upOsy2Y6IwDhK8bt.jpg', 1, 'AVAILABLE', 2010);

-- Insertar película 2
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (2, 'The Dark Knight', 'When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.', 'https://www.themoviedb.org/t/p/w1280/qJ2tW6WMUDux911r6m7haRef0WH.jpg', 1, 'AVAILABLE', 2008);

-- Insertar película 3
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (3, 'Pulp Fiction', 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.', 'https://www.themoviedb.org/t/p/w1280/vQWk5YBFWF4bZaofAbv0tShwBvQ.jpg', 2, 'AVAILABLE', 1994);

-- Insertar película 4
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (4, 'The Godfather', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', 'https://www.themoviedb.org/t/p/w1280/3Tf8vXykYhzHdT0BtsYTp570JGQ.jpg', 3, 'AVAILABLE', 1972);

-- Insertar película 5
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (5, 'Schindler''s List', 'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.', 'https://www.themoviedb.org/t/p/w1280/sF1U4EUQS8YHUYjNl3pMGNIQyr0.jpg', 4, 'AVAILABLE', 1993);

-- Insertar película 6
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (6, 'The Shawshank Redemption', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', 'https://www.themoviedb.org/t/p/w1280/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg', 20, 'AVAILABLE', 1994);

-- Insertar película 7
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (7, 'Fight Club', 'An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.', 'https://www.themoviedb.org/t/p/w1280/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg', 11, 'AVAILABLE', 1999);

-- Insertar película 8
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (8, 'Forrest Gump', 'The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.', 'https://www.themoviedb.org/t/p/w1280/arw2vcBveWOVZr6pxd9XTd1TdQa.jpg', 22, 'AVAILABLE', 1994);

-- Insertar película 9
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (9, 'The Matrix', 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.', 'https://www.themoviedb.org/t/p/w1280/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg', 23, 'AVAILABLE', 1999);

-- Insertar película 10
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (10, 'The Lord of the Rings: The Fellowship of the Ring', 'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.', 'https://www.themoviedb.org/t/p/w1280/6oom5QYQ2yQTMJIbnvbkBL9cHo6.jpg', 9, 'AVAILABLE', 2001);

-- Insertar película 11
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (11, 'The Departed', 'An undercover cop and a mole in the police attempt to identify each other while infiltrating an Irish gang in South Boston.', 'https://www.themoviedb.org/t/p/w1280/nT97ifVT2J1yMQmeq20Qblg61T.jpg', 5, 'AVAILABLE', 2006);

-- Insertar película 12
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (12, 'Goodfellas', 'The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate.', 'https://www.themoviedb.org/t/p/w1280/aKuFiU82s5ISJpGZp7YkIr3kCUd.jpg', 5, 'AVAILABLE', 1990);

-- Insertar película 13
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (13, 'The Silence of the Lambs', 'A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.', 'https://www.themoviedb.org/t/p/w1280/uS9m8OBk1A8eM9I042bx8XXpqAq.jpg', 24, 'AVAILABLE', 1991);

-- Insertar película 14
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (14, 'Saving Private Ryan', 'Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.', 'https://www.themoviedb.org/t/p/w1280/uqx37cS8cpHg8U35f9U5IBlrCV3.jpg', 4, 'AVAILABLE', 1998);

-- Insertar película 15
INSERT INTO movies (id, title, overview, poster_img, director_id, status, year)
VALUES (15, 'The Green Mile', 'The lives of guards on Death Row are affected by one of their charges: a black man accused of child murder and rape, yet who has a mysterious gift.', 'https://www.themoviedb.org/t/p/w1280/8VG8fDNiy50H4FedGwdSVUPoaJe.jpg', 20, 'AVAILABLE', 1999);

-- Insertar usuario
INSERT INTO users (id, email, username, password, role)
VALUES (2, 'pablocalvoj@gmail.com', 'PabloCalvo03', '$2a$12$bWFyGjTfr2Kjy1VEo9xlSOtmGjPaSNHUm3nTYPBeFVRW5x3zxXTv2', 'USER');

-- Insertar usuario administrador
INSERT INTO users (id, email, username, password, role)
VALUES (1, 'adminuser@gmail.com', 'AdminUser', '$2a$12$bWFyGjTfr2Kjy1VEo9xlSOtmGjPaSNHUm3nTYPBeFVRW5x3zxXTv2', 'ADMIN');
