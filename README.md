# Gestión de Biblioteca

Este es un proyecto de gestión de biblioteca desarrollado en Java utilizando Hibernate como framework de persistencia. El proyecto permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en libros y lectores, así como también gestionar préstamos de libros.

## Configuración

Para ejecutar este proyecto, necesitarás tener instalado lo siguiente:

- Java JDK 8 o superior
- Maven
- MySQL Server

### Configuración de la base de datos

1. Crea una base de datos MySQL llamada `biblioteca`.
2. Ejecuta el script `create_tables.sql` para crear las tablas necesarias en la base de datos.

### Configuración de Hibernate

Asegúrate de que el archivo `hibernate.cfg.xml` esté correctamente configurado con la información de conexión a tu base de datos MySQL.

## Configuración de Variables de Entorno

Para que la aplicación se conecte correctamente a la base de datos MySQL, es necesario configurar las siguientes variables de entorno en el arhivo `hibernate.cfg.xml`:

- `DB_BASEDATA_NAME`: El nombre de la base de datos MySQL a la que se conectará la aplicación.
- `DB_USER_NAME`: El nombre de usuario de MySQL con permisos para acceder a la base de datos.
- `DB_PASSWORD`: La contraseña del usuario de MySQL.

Asegúrate de asignar valores adecuados a estas variables de entorno antes de ejecutar la aplicación.

### Ejecución

1. Clona este repositorio en tu máquina local.
2. Navega al directorio del proyecto.
3. Ejecuta el siguiente comando para compilar el proyecto y generar el archivo JAR:

    ```
    mvn clean package
    ```

4. Una vez generado el archivo JAR, ejecútalo con el siguiente comando:

    ```
    java -jar gestion-biblioteca.jar
    ```

## Uso

Una vez que el proyecto esté en funcionamiento, puedes realizar las siguientes operaciones:

- Agregar, editar y eliminar libros.
- Agregar, editar y eliminar lectores.
- Registrar préstamos de libros.
- Registrar devoluciones de libros.
- Consultar libros prestados a un lector específico.
- Consultar libros disponibles para préstamo.
- Consultar el historial de préstamos por lector.


## Ejecución de pruebas

Para ejecutar las pruebas en este proyecto, sigue estos pasos:

1. Asegúrate de haber compilado el proyecto con Maven utilizando el siguiente comando:

    ```
    mvn clean package
    ```

2. Una vez compilado el proyecto, ejecuta el siguiente comando para ejecutar las pruebas:

    ```
    mvn test
    ```

Esto ejecutará todas las pruebas en el proyecto y mostrará los resultados en la consola. Asegúrate de que todas las pruebas pasen correctamente antes de realizar cambios importantes en el código.

## Contribuciones

Si encuentras algún error o tienes alguna sugerencia de mejora, por favor envía un mail a enriquegomezlucena@gmail.es

## Licencia

Todos los Derechos de Autor Pertenecen a Enrique José Gómez Lucena
