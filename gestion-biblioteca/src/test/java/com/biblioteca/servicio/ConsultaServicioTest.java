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

    // Commit 1: Configuración inicial común a todas las pruebas
    @BeforeAll
    static void setupClass() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        consultaServicio = new ConsultaServicio(sessionFactory);
    }

    // Commit 2: Configurar el servicio antes de cada prueba
    @BeforeEach
    void setup() {
        consultaServicio = new ConsultaServicio(sessionFactory);
    }

    // Commit 3: Cerrar la sesión después de cada prueba para limpiar el estado
    @AfterEach
    void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    // Commit 4: Opcional: realizar cualquier limpieza final si es necesario
    @AfterAll
    static void tearDownClass() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    // Commit 5: Implementar prueba para libros prestados a un lector específico
    @Test
    void testLibrosPrestadosALector() {
        Lector lector = new Lector();
        lector.setId(1L);  
        List<Libro> libros = consultaServicio.librosPrestadosALector(lector);
        assertFalse(libros.isEmpty(), "Debe haber al menos un libro prestado a este lector");
    }

    // Commit 6: Implementar prueba para libros disponibles para préstamo
    @Test
    void testLibrosDisponiblesParaPrestamo() {
        List<Libro> libros = consultaServicio.librosDisponiblesParaPrestamo();
        assertFalse(libros.isEmpty(), "Debe haber libros disponibles para préstamo");
    }

    // Commit 7: Implementar prueba para historial de préstamos por lector
    @Test
    void testHistorialPrestamosPorLector() {
        Lector lector = new Lector();
        lector.setId(1L);  
        List<Prestamo> prestamos = consultaServicio.historialPrestamosPorLector(lector);
        assertFalse(prestamos.isEmpty(), "Debe haber un historial de préstamos para este lector");
    }
}
