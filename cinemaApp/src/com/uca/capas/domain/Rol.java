package com.uca.capas.domain;

import javax.persistence.*;

@Entity
@Table(name = "rol", schema = "public")
public class Rol {
    @Id
    @GeneratedValue(generator = "rol_c_rol_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "rol_c_rol_seq", sequenceName = "rol_c_rol_seq")
    @Column(name = "c_rol")
    private Long idRol;

    @Column(name = "rol_nombre")
    private String nombreRol;

    public Rol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Rol(){}

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
