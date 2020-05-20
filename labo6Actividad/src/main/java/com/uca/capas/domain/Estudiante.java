package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="nombre")
	@Size(message="El campo Nombre no debe tener mas de 25 caracteres", max = 25)
	@NotEmpty(message="Este campo no puede estar vacío") 
	private String nombre;
	
	@Column(name="apellido")
	@Size(message="El campo Apellido no debe tener mas de 25 caracteres", max = 25)
	@NotEmpty(message="Este campo no puede estar vacío") 
	private String apellido;
	
	@Column(name="carne")
	@NotNull(message="Este campo no puede estar vacío") 
	@Pattern(regexp="\\d{8}", message = "El campo Carné debe tener 8 dígitos.")
	private String carne;
	
	@Column(name="carrera")
	@NotEmpty(message="Este campo no puede estar vacío") 
	@Size(message="El campo Carrera no debe tener mas de 40 caracteres", max = 40)
	private String carrera;
	 
	public Estudiante() {
		
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	public String getCarne() {
		return carne;
	}
	public void setCarne(String carne) {
		this.carne = carne;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
}
