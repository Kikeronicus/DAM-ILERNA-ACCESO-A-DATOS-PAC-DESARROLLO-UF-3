package com.biblioteca.servicio;

import com.biblioteca.modelo.Libro;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibroServicioTest {

    private static SessionFactory sessionFactory;
    private static LibroServicio libroServicio;

    @BeforeAll
    static void setup() {
        // Configurar la SessionFactory
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        libroServicio = new LibroServicio(sessionFactory);
    }

    @Test
    void testCrearLibro() {
        Libro libro = new Libro("1984", "George Orwell", 1949, true);
        Libro guardado = libroServicio.crearLibro(libro);
        assertNotNull(guardado.getId(), "El libro debe tener un ID después de ser guardado");
    }

    @Test
    void testActualizarLibro() {
        Libro libro = libroServicio.crearLibro(new Libro("1984", "George Orwell", 1949, true));
        libro.setTitulo("1984 Updated");
        libroServicio.actualizarLibro(libro);
        Libro actualizado = libroServicio.obtenerLibro(libro.getId());
        assertEquals("1984 Updated", actualizado.getTitulo(), "El título del libro debe ser actualizado");
    }

    @Test
    void testEliminarLibro() {
        Libro libro = libroServicio.crearLibro(new Libro("To Delete", "Author", 2021, true));
        libroServicio.eliminarLibro(libro);
        assertNull(libroServicio.obtenerLibro(libro.getId()), "El libro debe ser eliminado");
    }

    @AfterAll
    static void tearDown() {
        // Cerrar la SessionFactory
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
