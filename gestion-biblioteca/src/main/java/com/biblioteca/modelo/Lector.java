package com.biblioteca.modelo;

import javax.persistence.*;

@Entity
public class Lector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String apellido;

	@Column(nullable = false, unique = true)
	private String email;

	// Commit 1: Añadir clase Lector
	// Constructor vacío
	public Lector() {
	}

	// Commit 2: Añadir constructor con parámetros
	// Constructor con parámetros
	public Lector(String nombre, String apellido, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	// Commit 3: Implementar getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
