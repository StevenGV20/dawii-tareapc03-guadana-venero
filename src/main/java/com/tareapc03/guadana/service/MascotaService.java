package com.tareapc03.guadana.service;

import java.util.List;
import java.util.Optional;

import com.tareapc03.guadana.entity.Mascota;

public interface MascotaService {

	public abstract List<Mascota> listaMascota();
	public abstract List<Mascota> bsucaMascotaByName(String nombre);
	public abstract Mascota mantenerMascota(Mascota bean);
	public abstract Optional<Mascota> buscaById(int id);
	
}
