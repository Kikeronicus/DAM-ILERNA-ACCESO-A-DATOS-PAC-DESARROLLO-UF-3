package com.biblioteca.servicio;

import com.biblioteca.modelo.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LibroServicio {

    private SessionFactory sessionFactory;

    // Commit 1: Añadir constructor LibroServicio
    public LibroServicio(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Commit 2: Implementar método crearLibro
    public Libro crearLibro(Libro libro) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(libro);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
        return libro;
    }

    // Commit 3: Implementar método obtenerLibro
    public Libro obtenerLibro(Long id) {
        Session session = sessionFactory.openSession();
        Libro libro = null;
        try {
            libro = session.get(Libro.class, id);
        } finally {
            session.close();
        }
        return libro;
    }

    // Commit 4: Implementar método actualizarLibro
    public void actualizarLibro(Libro libro) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(libro);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Commit 5: Implementar método eliminarLibro
    public void eliminarLibro(Libro libro) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(libro);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
