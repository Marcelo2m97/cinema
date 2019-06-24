package com.uca.capas.domain;

import javax.persistence.*;

@Entity
@Table(name = "estado", schema = "public")
public class Estado {
    @Id
    @GeneratedValue(generator = "estado_c_estado_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "estado_c_estado_seq",sequenceName = "estado_c_estado_seq")
    @Column(name = "c_estado")
    private Long idEstado;

    @Column(name = "estado_nombre")
    private String nombreEstado;

    public Estado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public Estado(){}

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
}
