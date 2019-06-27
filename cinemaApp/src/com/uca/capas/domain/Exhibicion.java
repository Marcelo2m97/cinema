package com.uca.capas.domain;

import java.util.Calendar;

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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.uca.capas.utils.EntityUtils;

@Entity
@Table(schema="public" , name="exhibicion")
public class Exhibicion {

	@Id
	@GeneratedValue(generator="exhibicion_c_exhibicion_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="exhibicion_c_exhibicion_seq", sequenceName="public.exhibicion_c_exhibicion_seq", allocationSize=1)
	@Column(name="c_exhibicion")
	private Integer id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="exhibicion_fecha")
	private Calendar fecha;
	
	@Column(name="exhibicion_horario")
	private String horario;
	
	@Column(name="exhibicion_asientosdisponibles")
	private Integer asientos;
	
	@Column(name="exhibicion_activo")
	private boolean activo;
	
	@Column(name="exhibicion_creacion")
	private Calendar fechaCreacion;
	
	@Column(name="exhibicion_modificacion")
	private Calendar fechaModificacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_usuariocreacion")
	private Usuario usuarioCreacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_usuariomodificacion")
	private Usuario usuarioModificacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_sala")
	private Sala sala;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_pelicula")
	private Pelicula pelicula;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_formato")
	private Formato formato;
	
	@Transient
	private Integer idSala;
	
	@Transient
	private Integer idPelicula;
	
	@Transient
	private Integer idFormato;

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

	public Integer getAsientos() {
		return asientos;
	}

	public void setAsientos(Integer asientos) {
		this.asientos = asientos;
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

	public Usuario getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Usuario getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(Usuario usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
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

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
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

	public Integer getIdFormato() {
		return idFormato;
	}

	public void setIdFormato(Integer idFormato) {
		this.idFormato = idFormato;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	public String getFechaDelegate() {
		return EntityUtils.dateToString2(fecha);
	}
}
