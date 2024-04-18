package com.biblioteca.servicio;

import com.biblioteca.modelo.Libro;
import com.biblioteca.modelo.Lector;
import com.biblioteca.modelo.Prestamo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class PrestamoServicio {

    private SessionFactory sessionFactory;

    // Commit 1: Añadir constructor PrestamoServicio
    public PrestamoServicio(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Commit 2: Implementar método crearPrestamo
    public Prestamo crearPrestamo(Libro libro, Lector lector) {
        if (libro == null || lector == null || !libro.getDisponible()) {
            throw new IllegalArgumentException("El libro no está disponible o el lector/libro es nulo.");
        }
        
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Prestamo prestamo = new Prestamo();
        try {
            tx = session.beginTransaction();
            
            libro.setDisponible(false);  // Actualizar la disponibilidad del libro
            session.update(libro);
            
            prestamo.setLibro(libro);
            prestamo.setLector(lector);
            prestamo.setFechaPrestamo(new Date());  // La fecha actual
            // La fecha de devolución puede establecerse más tarde
            
            session.save(prestamo);
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
        
        return prestamo;
    }

    // Commit 3: Implementar método registrarDevolucion
    public void registrarDevolucion(Prestamo prestamo) {
        if (prestamo == null) {
            throw new IllegalArgumentException("El préstamo no puede ser nulo.");
        }
        
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            Libro libro = prestamo.getLibro();
            libro.setDisponible(true);  // El libro vuelve a estar disponible
            session.update(libro);
            
            prestamo.setFechaDevolucion(new Date());  // Registrar la fecha actual como fecha de devolución
            session.update(prestamo);
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
