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
@Table(schema="public", name="pelicula")
public class Pelicula {
	
	@Id
	@GeneratedValue(generator="pelicula_c_pelicula_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="pelicula_c_pelicula_seq", sequenceName="public.pelicula_c_pelicula_seq", allocationSize=1)
	@Column(name="c_pelicula")
	private Integer id;
	
	@Column(name="pelicula_nombre")
	private String nombre;
	
	@Column(name="pelicula_descripcion")
	private String descripcion;
	
	@Column(name="pelicula_imagen")
	private String imagen;
	
	@Column(name="pelicula_activo")
	private boolean activo;
	
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
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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
