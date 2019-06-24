package com.uca.capas.dto;

public class ExhibicionDTO {

	private Integer id;
	
	private String horario;
	
	private String formato;
	
	private Integer idSala;
	
	private Integer idPelicula;

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

	public Integer getIdSala() {
		return idSala;
	}

	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}

	public Integer getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Integer idPelicula) {
		this.idPelicula = idPelicula;
	}
}
