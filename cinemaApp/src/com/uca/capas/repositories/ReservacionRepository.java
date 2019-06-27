package com.uca.capas.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.domain.Reservacion;

public interface ReservacionRepository extends JpaRepository<Reservacion, Integer>{

	@Query(value = "SELECT * FROM public.reservacion WHERE c_usuario = :idUsuario AND reservacion_fecha BETWEEN :startDate AND :endDate", nativeQuery=true)
	public List<Reservacion> findBetweenDates(@Param("idUsuario") Integer idUsuario, @Param("startDate")Date startDate, @Param("endDate")Date endDate);
}
