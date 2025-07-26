# Challenge Literatura 📚

Un sistema de gestión de libros desarrollado en Java con Spring Boot que permite buscar, almacenar y consultar información sobre libros y autores utilizando la API de Gutendex.

## 🚀 Características

- **Búsqueda de libros**: Busca libros por título usando la API de Gutendex
- **Gestión de autores**: Lista y filtra autores por año de vida
- **Filtrado por idioma**: Busca libros por idioma específico (Inglés, Español, Francés, Finlandés)
- **Base de datos**: Almacena libros y autores en PostgreSQL
- **Interfaz de consola**: Menú interactivo fácil de usar

## 🛠️ Tecnologías Utilizadas

- **Java 24**
- **Spring Boot 3.5.3**
- **Spring Data JPA**
- **PostgreSQL**
- **Jackson** (para manejo de JSON)
- **Gson** (para parsing de JSON)
- **Maven** (gestión de dependencias)

## 📋 Prerrequisitos

- Java JDK 24 o superior
- PostgreSQL
- Maven 3.6+

## ⚙️ Configuración

### 1. Base de Datos

Crea una base de datos PostgreSQL llamada `libros` y configura las siguientes variables de entorno:

```bash
DB_HOST=localhost:5432
DB_PASSWORD=tu_password_postgresql
```

### 2. Configuración de la aplicación

El archivo `application.properties` ya está configurado para usar las variables de entorno:

```properties
spring.datasource.url=jdbc:postgresql://${DB_HOST}/libros
spring.datasource.username=postgres
spring.datasource.password=${DB_PASSWORD}
```

## 🚀 Instalación y Ejecución

### En Windows:

1. **Clona el repositorio**:
   ```powershell
   git clone https://github.com/sanntr/Challenge_literatura.git
   cd Challenge_literatura
   ```

2. **Configura las variables de entorno**:
   ```powershell
   $env:DB_HOST="localhost:5432"
   $env:DB_PASSWORD="tu_password"
   ```


### En Linux/Mac:

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/sanntr/Challenge_literatura.git
   cd Challenge_literatura
   ```

2. **Configura las variables de entorno**:
   ```bash
   export DB_HOST="localhost:5432"
   export DB_PASSWORD="tu_password"
   ```



## 📱 Uso de la Aplicación

Al ejecutar la aplicación, verás un menú con las siguientes opciones:

```
--------
Elija la opción a través de su número:
1- buscar libro por título
2- listar libros registrados
3- listar autores registrados
4- listar autores vivos en un determinado año
5- listar libros por idioma
0 - salir
```

### Funcionalidades Detalladas:

1. **Buscar libro por título**: Busca un libro en la API de Gutendex y lo guarda en la base de datos
2. **Listar libros registrados**: Muestra todos los libros almacenados en la base de datos
3. **Listar autores registrados**: Muestra todos los autores almacenados
4. **Listar autores vivos**: Filtra autores que estaban vivos en un año específico
5. **Listar libros por idioma**: Filtra libros por idioma seleccionado

## 🏗️ Estructura del Proyecto

```
src/main/java/com/alura/challenge/
├── ChallengeApplication.java          # Clase principal
├── console/
│   └── Principal.java                 # Interfaz de usuario por consola
├── Dto/                              # Data Transfer Objects
│   ├── DtoAutor.java
│   ├── DtoLibro.java
│   └── ...
├── model/                            # Entidades JPA
│   ├── Autor.java
│   └── Libro.java
├── repository/                       # Repositorios JPA
│   ├── AutorRepository.java
│   └── LibroRepository.java
└── service/                          # Servicios de negocio
    ├── ConversionDatos.java
    ├── GutendexApiClient.java
    └── LibrosService.java
```

## 🔧 API Externa

Este proyecto utiliza la [API de Gutendex](https://gutendex.com/) para obtener información sobre libros de dominio público.

## 🤝 Contribución

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto es parte del Challenge de Alura Latam.

## 👨‍💻 Autor

- **GitHub**: [@sanntr](https://github.com/sanntr)

## 📞 Soporte

Si tienes alguna pregunta o encuentras algún problema, por favor crea un issue en el repositorio.

---

⭐ Si este proyecto te fue útil, no olvides darle una estrella en GitHub!
