package com.uca.capas.domain;

import java.math.BigDecimal;
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

import com.uca.capas.utils.EntityUtils;

@Entity
@Table(schema="public", name="reservacion")
public class Reservacion {

	@Id
	@GeneratedValue(generator="reservacion_c_reservacion_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="reservacion_c_reservacion_seq", sequenceName="public.reservacion_c_reservacion_seq", allocationSize=1)
	@Column(name="c_reservacion")
	private Integer id;
	
	@Column(name="reservacion_asientos")
	private Integer asientos;
	
	@Column(name="reservacion_saldo")
	private BigDecimal saldo;
	
	@Column(name="reservacion_fecha")
	private Calendar fecha;
	
	@Column(name="reservacion_subtotal")
	private BigDecimal subtotal;
	
	@Transient
	private BigDecimal saldoUsado;
	
	@Transient
	private BigDecimal saldoRestante;
	
	@Column(name="reservacion_grantotal")
	private BigDecimal total;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_usuario")
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_exhibicion")
	private Exhibicion exhibicion;
	
	@Transient
	private Integer idExhibicion;

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

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
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

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getIdExhibicion() {
		return idExhibicion;
	}

	public void setIdExhibicion(Integer idExhibicion) {
		this.idExhibicion = idExhibicion;
	}

	public BigDecimal getSaldoRestante() {
		return saldoRestante;
	}

	public void setSaldoRestante(BigDecimal saldoRestante) {
		this.saldoRestante = saldoRestante;
	}

	public BigDecimal getSaldoUsado() {
		return saldoUsado;
	}

	public void setSaldoUsado(BigDecimal saldoUsado) {
		this.saldoUsado = saldoUsado;
	}
	
	public String getFechaDelegate() {
		return EntityUtils.dateToString(fecha);
	}
	
	public String getIdDelegate() {
		String formatted = String.format("%08d", id);
		return formatted;
	}
}
