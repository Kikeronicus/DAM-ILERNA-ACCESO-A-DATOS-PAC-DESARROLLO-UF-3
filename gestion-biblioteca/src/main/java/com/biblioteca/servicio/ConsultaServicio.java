package com.biblioteca.servicio;

import com.biblioteca.modelo.Libro;
import com.biblioteca.modelo.Lector;
import com.biblioteca.modelo.Prestamo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ConsultaServicio {

    private SessionFactory sessionFactory;

    // Commit 1: Añadir constructor ConsultaServicio
    public ConsultaServicio(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Commit 2: Implementar método librosPrestadosALector
    // Consulta libros prestados a un lector específico
    public List<Libro> librosPrestadosALector(Lector lector) {
        Session session = sessionFactory.openSession();
        try {
            String hql = "SELECT p.libro FROM Prestamo p WHERE p.lector = :lector AND p.fechaDevolucion IS NULL";
            Query<Libro> query = session.createQuery(hql, Libro.class);
            query.setParameter("lector", lector);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    // Commit 3: Implementar método librosDisponiblesParaPrestamo
    // Consulta libros disponibles para préstamo
    public List<Libro> librosDisponiblesParaPrestamo() {
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM Libro l WHERE l.disponible = true";
            Query<Libro> query = session.createQuery(hql, Libro.class);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    // Commit 4: Implementar método historialPrestamosPorLector
    // Consulta el historial de préstamos por lector
    public List<Prestamo> historialPrestamosPorLector(Lector lector) {
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM Prestamo p WHERE p.lector = :lector ORDER BY p.fechaPrestamo DESC";
            Query<Prestamo> query = session.createQuery(hql, Prestamo.class);
            query.setParameter("lector", lector);
            return query.getResultList();
        } finally {
            session.close();
        }
    }
}
