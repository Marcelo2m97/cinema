package com.uca.capas.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.uca.capas.utils.EntityUtils;

@Entity
@Table(schema="public", name="sala")
public class Sala {

	@Id
	@GeneratedValue(generator="sala_c_sala_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="sala_c_sala_seq", sequenceName="public.sala_c_sala_seq", allocationSize=1)
	@Column(name="c_sala")
	private Integer id;
	
	@Column(name="sala_numero")
	private Integer numero;
	
	@Column(name="sala_descripcion")
	private String descripcion;
	
	@Column(name="sala_capacidad")
	private Integer capacidad;
	
	@Column(name="sala_activo")
	private boolean activo;
	
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

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Calendar getFechaModificacion() {
		return fechaModificacion;
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
	
	public String getActivoDelegate() {
		return EntityUtils.activoToString(activo);
	}
	
	public String getFechaCreacionDelegate() {
		return EntityUtils.dateToString(fechaCreacion);
	}
	
	public String getFechaModificacionDelegate() {
		return EntityUtils.dateToString(fechaModificacion);
	}
}
