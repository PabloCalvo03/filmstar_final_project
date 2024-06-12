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

En el caso anterior, si se quiere desplegar de forma automatizada a partir del control de versiones, lo habitual es que estén los dos proyectos en repositorios separados. Por lo que se deberá configurar el despliegue automático para indicarle la raíz del código fuente de cada proyecto (si es posible) o hacer dos folks del repositorio principal uno para la API y otro para el frontend y adaptar los directorios para poder realizar el despliegue automático.

En un proyecto monolítico (tecnología servidor: Springboot, Django, Express, PHP,... con un sistema de templates propio para el frontend: Thymeleaf, jinja, ejs,...) deberá tener la siguiente estructura en el repositorio de entrega:

- src
- docs
- README.md
