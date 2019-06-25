package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="reservacion")
public class Reservacion {

	@Id
	@GeneratedValue(generator="reservacion_c_reservacion_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="reservacion_c_reservacion_seq", sequenceName="public.reservacion_c_reservacion_seq", allocationSize=1)
	@Column(name="c_reservacion")
	private Integer id;
	
	@Column(name="exhibicion_asiento")
	private Integer asientos;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_usuario")
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_exhibicion")
	private Exhibicion exhibicion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAsientos() {
		return asientos;
	}

	public void setAsientos(Integer asientos) {
		this.asientos = asientos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Exhibicion getExhibicion() {
		return exhibicion;
	}

	public void setExhibicion(Exhibicion exhibicion) {
		this.exhibicion = exhibicion;
	}
}
