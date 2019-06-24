package com.uca.capas.domain;

import javax.persistence.*;

@Entity
@Table(name = "ciudad", schema = "public")
public class Ciudad {
    @Id
    @GeneratedValue(generator = "ciudad_c_ciudad_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "ciudad_c_ciudad_seq",sequenceName = "ciudad_c_ciudad_seq")
    @Column(name = "c_ciudad")
    private Long idCiudad;

    @Column(name = "ciudad_nombre")
    private String nombreCiudad;

    public Ciudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Ciudad(){}

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
}
