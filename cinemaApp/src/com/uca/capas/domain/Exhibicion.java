package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="public" , name="exhibicion")
public class Exhibicion {

	@Id
	@Column(name="c_exhibicion")
	private Integer id;
	
	@Column(name="exhibicion_horario")
	private String horario;
	
	@Column(name="exhibicion_formato")
	private String formato;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_sala")
	private Sala sala;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_pelicula")
	private Pelicula pelicula;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
}
