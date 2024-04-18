# DAM-ILERNA-ACCESO-A-DATOS-PAC-DESARROLLO-UF-3
GESTION DE BIBLIOTECA

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

## Ejecución

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

## Contribuciones

Si encuentras algún error o tienes alguna sugerencia de mejora, por favor envía un mail a enriquegomezlucena@gmail.es

## Licencia

Todos los Derechos de Autor Pertenecen a Enrique José Gómez Lucena

