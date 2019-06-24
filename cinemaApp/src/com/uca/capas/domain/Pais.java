package com.uca.capas.domain;

import javax.persistence.*;

@Entity
@Table(name = "pais", schema = "public")
public class Pais {
    @Id
    @GeneratedValue(generator = "pais_c_pais_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "pais_c_pais_seq", sequenceName = "pais_c_pais_seq")
    @Column(name = "c_pais")
    private Long idPais;

    @Column(name = "pais_nombre")
    private String nombrePais;

    public Pais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public Pais(){}

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
}
