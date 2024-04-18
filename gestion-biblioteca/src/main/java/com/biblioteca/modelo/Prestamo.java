package com.biblioteca.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Prestamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id", referencedColumnName = "id", nullable = false)
    private Libro libro;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lector_id", referencedColumnName = "id", nullable = false)
    private Lector lector;
    
    @Column(name = "fecha_prestamo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;

    // Commit 1: Añadir clase Prestamo
    // Constructor vacío necesario para JPA
    public Prestamo() {}

    // Commit 2: Añadir constructor completo
    // Constructor con parámetros
    public Prestamo(Libro libro, Lector lector, Date fechaPrestamo, Date fechaDevolucion) {
        this.libro = libro;
        this.lector = lector;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    // Commit 3: Implementar getters y setters
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo != null ? new Date(fechaPrestamo.getTime()) : null;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = (fechaPrestamo != null) ? new Date(fechaPrestamo.getTime()) : null;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion != null ? new Date(fechaDevolucion.getTime()) : null;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = (fechaDevolucion != null) ? new Date(fechaDevolucion.getTime()) : null;
    }
}
