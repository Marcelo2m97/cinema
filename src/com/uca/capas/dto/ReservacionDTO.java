package com.uca.capas.dto;

import java.math.BigDecimal;

public class ReservacionDTO {

	private Integer id;
	
	private Integer asientos;
		
	private BigDecimal saldo;
	
	private BigDecimal subtotal;
	
	private BigDecimal saldoRestante;

	private BigDecimal granTotal;

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

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getSaldoRestante() {
		return saldoRestante;
	}

	public void setSaldoRestante(BigDecimal saldoRestante) {
		this.saldoRestante = saldoRestante;
	}

	public BigDecimal getGranTotal() {
		return granTotal;
	}

	public void setGranTotal(BigDecimal granTotal) {
		this.granTotal = granTotal;
	}

	public Integer getIdExhibicion() {
		return idExhibicion;
	}

	public void setIdExhibicion(Integer idExhibicion) {
		this.idExhibicion = idExhibicion;
	}
}
