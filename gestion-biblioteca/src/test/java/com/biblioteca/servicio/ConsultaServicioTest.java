package com.biblioteca.servicio;

import com.biblioteca.modelo.Lector;
import com.biblioteca.modelo.Libro;
import com.biblioteca.modelo.Prestamo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ConsultaServicioTest {

    private static SessionFactory sessionFactory;
    private static ConsultaServicio consultaServicio;

    @BeforeAll
    static void setupClass() {
        // Configuración inicial común a todas las pruebas
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        consultaServicio = new ConsultaServicio(sessionFactory);
    }

    @BeforeEach
    void setup() {
        // Configurar el servicio antes de cada prueba
        consultaServicio = new ConsultaServicio(sessionFactory);
    }

    @AfterEach
    void tearDown() {
        // Cerrar la sesión después de cada prueba para limpiar el estado
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @AfterAll
    static void tearDownClass() {
        // Opcional: realizar cualquier limpieza final si es necesario
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    void testLibrosPrestadosALector() {
        Lector lector = new Lector();
        lector.setId(1L);  // Asegúrate de que este ID exista en la base de datos de pruebas
        List<Libro> libros = consultaServicio.librosPrestadosALector(lector);
        assertFalse(libros.isEmpty(), "Debe haber al menos un libro prestado a este lector");
    }

    @Test
    void testLibrosDisponiblesParaPrestamo() {
        List<Libro> libros = consultaServicio.librosDisponiblesParaPrestamo();
        assertFalse(libros.isEmpty(), "Debe haber libros disponibles para préstamo");
    }

    @Test
    void testHistorialPrestamosPorLector() {
        Lector lector = new Lector();
        lector.setId(1L);  // Asegúrate de que este ID exista en la base de datos de pruebas
        List<Prestamo> prestamos = consultaServicio.historialPrestamosPorLector(lector);
        assertFalse(prestamos.isEmpty(), "Debe haber un historial de préstamos para este lector");
    }
}
