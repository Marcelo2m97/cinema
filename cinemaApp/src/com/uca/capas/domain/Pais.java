package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="pais")
public class Pais {

	@Id
	@GeneratedValue(generator="pais_c_pais_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="pais_c_pais_seq", sequenceName="public.pais_c_pais_seq", allocationSize=1)
	@Column(name="c_pais")
	private Integer id;
	
	@Column(name="pais_nombre")
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
