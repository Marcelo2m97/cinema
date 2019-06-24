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
@Table(schema="public", name="pelicula")
public class Pelicula {
	
	@Id
	@Column(name="c_pelicula")
	private Integer id;
	
	@Column(name="pelicula_nombre")
	private String nombre;
	
	@Column(name="pelicula_descripcion")
	private String descripcion;
	
	@Column(name="pelicula_activo")
	private boolean activo;
	
	@Column(name="pelicula_imagen")
	private String imagen;
	
	@Column(name="pelicula_creacion")
	private Calendar fechaCreacion;
	
	@Column(name="pelicula_ultimamodificacion")
	private Calendar fechaModificacion;
	
	@Column(name="c_usuariocreacion")
	private Integer usuarioCreacion;
	
	@Column(name="c_usuariomodificacion")
	private Integer usuarioModificacion;
	
	@OneToMany(mappedBy="pelicula", fetch=FetchType.LAZY)
	private List<Exhibicion> exhibiciones;

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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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
