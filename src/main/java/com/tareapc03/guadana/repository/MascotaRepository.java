package com.tareapc03.guadana.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tareapc03.guadana.entity.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Integer>{

	@Query("Select m from Mascota m where m.nombre like :nombre")
	public List<Mascota> buscaMascotaByName(@Param("nombre") String nombre);
}
