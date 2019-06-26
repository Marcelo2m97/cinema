package com.uca.capas.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "usuario", schema = "public")
public class Usuario {
    @Id
    @GeneratedValue(generator = "usuario_c_usuario_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "usuario_c_usuario_seq", sequenceName = "usuario_c_usuario_seq")
    @Column(name = "c_usuario")
    private Long idUsuario;

    @Column(name = "u_nombre")
    private String nombreUsuario;

    @Column(name = "u_apellido")
    private String apellidoUsuario;

    @Column(name = "u_fechaNacimiento")
    private Date birthDateUsuario;

/*<<<<<<< HEAD
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

	public boolean isSesion() {
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
=======*/
    @Column(name = "u_direccion")
    private String direccionUsuario;

    @Column(name = "u_username")
    private String usernameUsuario;

    @Column(name = "u_password")
    private String passwordUsuario;

    @Column(name = "u_activo")
    private Boolean activoUsuario;

    @Column(name = "u_sesion")
    private Boolean sesionUsuario;

    @Column(name = "u_saldo")
    private BigDecimal saldoUsuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_pais")
    private Pais paisUsuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_estado")
    private Estado estadoUsuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_ciudad")
    private Ciudad ciudadUsuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_rol")
    private Rol rolUsuario;

    public Usuario(String nombreUsuario, String apellidoUsuario, Date birthDateUsuario, String direccionUsuario, String usernameUsuario, String passwordUsuario, Boolean activoUsuario, Boolean sesionUsuario, BigDecimal saldoUsuario, Pais paisUsuario, Estado estadoUsuario, Ciudad ciudadUsuario, Rol rolUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.birthDateUsuario = birthDateUsuario;
        this.direccionUsuario = direccionUsuario;
        this.usernameUsuario = usernameUsuario;
        this.passwordUsuario = passwordUsuario;
        this.activoUsuario = activoUsuario;
        this.sesionUsuario = sesionUsuario;
        this.saldoUsuario = saldoUsuario;
        this.paisUsuario = paisUsuario;
        this.estadoUsuario = estadoUsuario;
        this.ciudadUsuario = ciudadUsuario;
        this.rolUsuario = rolUsuario;
    }

    public Usuario(){}

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public Date getBirthDateUsuario() {
        return birthDateUsuario;
    }

    public void setBirthDateUsuario(Date birthDateUsuario) {
        this.birthDateUsuario = birthDateUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public String getUsernameUsuario() {
        return usernameUsuario;
    }

    public void setUsernameUsuario(String usernameUsuario) {
        this.usernameUsuario = usernameUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public Boolean getActivoUsuario() {
        return activoUsuario;
    }

    public void setActivoUsuario(Boolean activoUsuario) {
        this.activoUsuario = activoUsuario;
    }

    public Boolean getSesionUsuario() {
        return sesionUsuario;
    }

    public void setSesionUsuario(Boolean sesionUsuario) {
        this.sesionUsuario = sesionUsuario;
    }

    public BigDecimal getSaldoUsuario() {
        return saldoUsuario;
    }

    public void setSaldoUsuario(BigDecimal saldoUsuario) {
        this.saldoUsuario = saldoUsuario;
    }

    public Pais getPaisUsuario() {
        return paisUsuario;
    }

    public void setPaisUsuario(Pais paisUsuario) {
        this.paisUsuario = paisUsuario;
    }

    public Estado getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Estado estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Ciudad getCiudadUsuario() {
        return ciudadUsuario;
    }

    public void setCiudadUsuario(Ciudad ciudadUsuario) {
        this.ciudadUsuario = ciudadUsuario;
    }

    public Rol getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(Rol rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
}
