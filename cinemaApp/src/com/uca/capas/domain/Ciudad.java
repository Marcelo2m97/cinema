package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="ciudad")
public class Ciudad {

	@Id
	@GeneratedValue(generator="ciudad_c_ciudad_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="ciudad_c_ciudad_seq", sequenceName="public.ciudad_c_ciudad_seq", allocationSize=1)
	@Column(name="c_ciudad")
	private Integer id;
	
	@Column(name="ciudad_nombre")
	private String nombre;
}
