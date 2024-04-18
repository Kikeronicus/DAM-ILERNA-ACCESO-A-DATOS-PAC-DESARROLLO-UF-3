package com.biblioteca.modelo;

import javax.persistence.*;

@Entity
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String titulo;

	@Column(nullable = false)
	private String autor;

	@Column(name = "ano_publicacion", nullable = false)
	private Integer anoPublicacion;

	@Column(nullable = false)
	private Boolean disponible;

	// Commit 1: Añadir clase Libro
	// Constructor vacío necesario para JPA
	public Libro() {
	}

	// Commit 2: Añadir constructor completo
	// Constructor completo para facilitar la creación de objetos
	public Libro(String titulo, String autor, Integer anoPublicacion, Boolean disponible) {
		this.titulo = titulo;
		this.autor = autor;
		this.anoPublicacion = anoPublicacion;
		this.disponible = disponible;
	}

	// Commit 3: Implementar getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getAnoPublicacion() {
		return anoPublicacion;
	}

	public void setAnoPublicacion(Integer anoPublicacion) {
		this.anoPublicacion = anoPublicacion;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
}
