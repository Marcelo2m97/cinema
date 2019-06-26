package com.uca.capas.domain;

import javax.persistence.*;

import com.uca.capas.utils.EntityUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "usuario", schema = "public")
public class Usuario {
    @Id
    @GeneratedValue(generator="usuario_c_usuario_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="usuario_c_usuario_seq", sequenceName="public.usuario_c_usuario_seq", allocationSize=1)
    @Column(name = "c_usuario")
    private Integer id;

    @Column(name = "u_nombre")
    private String nombre;

    @Column(name = "u_apellido")
    private String apellido;

    @Column(name = "u_fechaNacimiento")
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
	
	public Usuario(){
    	
    }
	
    public Usuario(String nombreUsuario, String apellidoUsuario, Calendar birthDateUsuario, String direccionUsuario, String usernameUsuario, String passwordUsuario, Boolean activoUsuario, Boolean sesionUsuario, BigDecimal saldoUsuario, Pais paisUsuario, Estado estadoUsuario, Ciudad ciudadUsuario, Rol rolUsuario) {
        this.nombre = nombreUsuario;
        this.apellido = apellidoUsuario;
        this.fechaNacimiento = birthDateUsuario;
        this.direccion = direccionUsuario;
        this.username = usernameUsuario;
        this.password = passwordUsuario;
        this.activo = activoUsuario;
        this.sesion = sesionUsuario;
        this.saldo = saldoUsuario;
        this.pais = paisUsuario;
        this.estado = estadoUsuario;
        this.ciudad = ciudadUsuario;
        this.rol = rolUsuario;
    }

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean getSesion() {
		return sesion;
	}

	public void setSesion(boolean sesion) {
		this.sesion = sesion;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Reservacion> getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(List<Reservacion> reservaciones) {
		this.reservaciones = reservaciones;
	}
	
	public String getActivoDelegate() {
		return EntityUtils.activoToString(activo);
	}
}
