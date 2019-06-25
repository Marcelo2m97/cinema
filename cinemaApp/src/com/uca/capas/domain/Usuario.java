package com.uca.capas.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(generator="usuario_c_usuario_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="usuario_c_usuario_seq", sequenceName="public.usuario_c_usuario_seq", allocationSize=1)
	@Column(name="c_usuario")
	private Integer id;
	
	@Column(name="u_nombre")
	private String nombre;
	
	@Column(name="u_apellido")
	private String apellido;
	
	@Column(name="u_fechanacimiento")
	private Calendar fechaNacimiento;
	
	@Column(name="u_direccion")
	private String direccion;
	
	@Column(name="u_username")
	private String username;
	
	@Column(name="u_password")
	private String password;
	
	@Column(name="u_saldo")
	private BigDecimal saldo;
	
	@Column(name="u_activo")
	private boolean activo;
	
	@Column(name="u_sesion")
	private boolean sesion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_pais")
	private Pais pais;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_estado")
	private Estado estado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_ciudad")
	private Ciudad ciudad;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_rol")
	private Rol rol;
	
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<Reservacion> reservaciones;
}
