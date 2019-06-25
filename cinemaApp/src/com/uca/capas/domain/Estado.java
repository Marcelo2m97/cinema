package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="estado")
public class Estado {

	@Id
	@GeneratedValue(generator="estado_c_estado_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="estado_c_estado_seq", sequenceName="public.estado_c_estado_seq", allocationSize=1)
	@Column(name="c_estado")
	private Integer id;
	
	@Column(name="estado_nombre")
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
