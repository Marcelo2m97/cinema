package com.uca.capas.domain;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.uca.capas.utils.EntityUtils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "usuario", schema = "public")
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

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="u_fechaNacimiento")
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
	
	@Column(name="u_fechacreacion")
	private Calendar fechaCreacion;
	
	@Column(name="u_fechamodificacion")
	private Calendar fechaModificacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_usuariocreacion")
	private Usuario usuarioCreacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_usuariomodificacion")
	private Usuario usuarioModificacion;
	
	@Column(name="u_mensaje")
	private String mensaje;
	
	@Transient
	private Integer idPais;
	
	@Transient
	private Integer idEstado;
	
	@Transient
	private Integer idCiudad;
	
	@Transient
	private Integer idRol;

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

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public Integer getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getFechaCreacionDelegate() {
		return EntityUtils.dateToString(fechaCreacion);
	}
	
	public String getFechaModificacionDelegate() {
		return EntityUtils.dateToString(fechaModificacion);
	}
	
	public String getFechaNacimientoDelegate() {
		return EntityUtils.dateToString(fechaNacimiento);
	}
}
