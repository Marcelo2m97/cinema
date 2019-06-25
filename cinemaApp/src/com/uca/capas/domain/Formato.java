package com.uca.capas.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="formato")
public class Formato {

	@Id
	@GeneratedValue(generator="formato_c_formato_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="formato_c_formato_seq", sequenceName="public.formato_c_formato_seq", allocationSize=1)
	@Column(name="c_formato")
	private Integer id;
	
	@Column(name="formato_nombre")
	private String nombre;
	
	@Column(name="formato_precio")
	private BigDecimal precio;

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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
}
