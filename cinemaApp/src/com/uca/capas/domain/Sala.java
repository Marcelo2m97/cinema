package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="sala")
public class Sala {

	@Id
	@Column(name="c_sala")
	private Integer id;
	
	@Column(name="sala_numero")
	private Integer numero;
	
	@Column(name="sala_descripcion")
	private String descripcion;
	
	@Column(name="sala_activo")
	private boolean activo;
	
	@Column(name="sala_capacidad")
	private Integer capacidad;
	
	@Column(name="sala_creacion")
	private Calendar fechaCreacion;
	
	@Column(name="sala_ultimamodificacion")
	private Calendar fechaModificacion;
	
	@Column(name="c_usuariocreacion")
	private Integer usuarioCreacion;
	
	@Column(name="c_usuariomodificacion")
	private Integer usuarioModificacion;
	
	@OneToMany(mappedBy="sala", fetch=FetchType.LAZY)
	private List<Exhibicion> exhibiciones;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean getActivo() {
		return activo;
	}
	
	public String getActivoDelegate() {
		if (activo) {
			return "Activo";
		}
		return "Inactivo";
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}
	
	public String getFechaCreacionDelegate() {
		if (fechaCreacion == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(fechaCreacion.getTime());
		return date;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Calendar getFechaModificacion() {
		return fechaModificacion;
	}
	
	public String getFechaModificacionDelegate() {
		if (fechaModificacion == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(fechaModificacion.getTime());
		return date;
	}

	public void setFechaModificacion(Calendar fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Integer getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(Integer usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Integer getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(Integer usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public List<Exhibicion> getExhibiciones() {
		return exhibiciones;
	}

	public void setExhibiciones(List<Exhibicion> exhibiciones) {
		this.exhibiciones = exhibiciones;
	}
}
