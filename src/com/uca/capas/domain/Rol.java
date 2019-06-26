package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="rol")
public class Rol {

	@Id
	@GeneratedValue(generator="rol_c_rol_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="rol_c_rol_seq", sequenceName="public.rol_c_rol_seq", allocationSize=1)
	@Column(name="c_rol")
	private Integer id;
	
	@Column(name="rol_nombre")
	private String nombre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
