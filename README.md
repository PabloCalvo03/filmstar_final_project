# FilmStar

#### Curso Escolar 2023-2024
#### Autor: [Pablo Calvo Jiménez](https://github.com/PabloCalvo03)
#### Tutor: [Antonio Gabriel Gonzalez Casado](https://github.com/antonio-gabriel-gonzalez-casado)
#### Fecha de Inicio: 15-03-2024
#### Fecha de Finalización: 12-06-2024

## Breve descripción del proyecto

FilmStar es una aplicación web desarrollada con el propósito de revolucionar la forma en que los usuarios interactúan con películas. Inspirada por las deficiencias observadas en plataformas populares como Filmaffinity, FilmStar introduce varias características únicas que no solo mejoran la experiencia del usuario sino que también añaden un nivel de exclusividad que es raro en el mercado actual. 


El objetivo principal de FilmStar es proporcionar una plataforma cerrada y exclusiva para amantes del cine, donde puedan descubrir, valorar, y comentar películas. Al implementar un sistema de registro por invitación, FilmStar busca mantener un alto nivel de calidad en las valoraciones y comentarios, evitando así el ruido y las opiniones sin fundamento que afectan a otras plataformas abiertas. Además, FilmStar incorpora un diseño moderno y responsivo, con soporte para modos oscuro y claro, mejorando la experiencia de usuario en diferentes entornos de iluminación.

## Estructura del Proyecto

En este apartado el alumno explicará el contenido del repositorio y de todas las carpetas relevantes del mismo. Para facilitar la gestión de la entrega, todo el código y documentación debe estar en este repositorio.

Por lo anterior, un proyecto que contenga un Frontend en una tecnología o framework (por ejemplo Angular) y una API REST en otra tecnología o framework (Springboot, Express) deberá tener la siguiente estructura de directorios en el repositorio de entrega:

- src-api
  - src
    - main
      - java
        - com.filmstar
          - apps
          - domain
          - application
          - infrastructure
          - FilmstarApplication.java
- src-frontend
  - src
    - assets
    - components
    - layouts
    - loaders
    - pages
    - redux
    - routes
    - app.jsx
- docs
- README.md

### Ejecución del proyecto con Docker en Linux y Mac

1. Asegúrate de tener Docker instalado en tu sistema Unix. Puedes verificar si está instalado ejecutando `docker --version` en tu terminal. Si no está instalado, puedes seguir las [instrucciones de instalación](https://docs.docker.com/get-docker/) en el sitio web oficial de Docker.

2. Descarga o clona el proyecto.

3. Abre una terminal y navega hasta el directorio raíz del proyecto utilizando el comando `cd`.

4. Una vez en el directorio del proyecto, navega hacia src-api y ejecuta el comando `make start`.
   
5. Con el contenedor corriendo, habra fallado ya que no existe base de datos, deberas hacer `make migrate`.
   
6. Tras esto lanza de nuevo `make start` y con esto ya tendríamos el backend corriendo.
   
7. Ahora ve hacia atras y metete en src-frontend y igual, haz `make start`.
   
8. Y ya estaría todo listo para probar!

El `Makefile` es lo que uso para hacer make... es para poner alias a los comandos y poder hacer comandos encadenados de forma muy simple

### Ejecución del proyecto con Docker en Windows

1. Asegúrate de tener Docker instalado en tu sistema Unix. Puedes verificar si está instalado ejecutando `docker --version` en tu terminal. Si no está instalado, puedes seguir las [instrucciones de instalación](https://docs.docker.com/get-docker/) en el sitio web oficial de Docker.

2. Descarga o clona el proyecto.

3. Abre una terminal y navega hasta el directorio raíz del proyecto utilizando el comando `cd`.

4. Una vez en el directorio del proyecto, navega hacia src-api y ejecuta el comando `docker compose up --build`.

5. Con el contenedor corriendo, habra fallado ya que no existe base de datos, deberas hacer `docker exec -i src-api-mysqldb-1 mysql -u root -proot filmstar_db < ./fixtures/fixture.sql`.
