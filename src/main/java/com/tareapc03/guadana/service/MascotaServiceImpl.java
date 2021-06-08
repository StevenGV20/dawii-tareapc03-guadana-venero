package com.tareapc03.guadana.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tareapc03.guadana.entity.Mascota;
import com.tareapc03.guadana.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService{

	@Autowired
	private MascotaRepository repository;
	
	@Override
	public List<Mascota> listaMascota() {
		return repository.findAll();
	}

	@Override
	public List<Mascota> bsucaMascotaByName(String nombre) {
		return repository.buscaMascotaByName(nombre+"%");
	}

	@Override
	public Mascota mantenerMascota(Mascota bean) {
		return repository.save(bean);
	}

	@Override
	public Optional<Mascota> buscaById(int id) {
		return repository.findById(id);
	}

	
}
