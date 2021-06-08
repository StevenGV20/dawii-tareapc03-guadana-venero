package com.tareapc03.guadana.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tareapc03.guadana.entity.Mascota;
import com.tareapc03.guadana.service.MascotaService;

@RestController
@RequestMapping("/api/mascota")
public class MascotaController {

	@Autowired
	private MascotaService service;
	
	@GetMapping("/")
	@ResponseBody
	public List<Mascota> listaMascota(){
		return service.listaMascota();
	}
	
	@GetMapping("/{nombre}")
	@ResponseBody
	public List<Mascota> bsucaMascotaByName(@PathVariable("nombre") String nombre){
		return service.bsucaMascotaByName(nombre);
	}
	
	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<?> registraMascota(@RequestBody Mascota bean) {
		try {
			return ResponseEntity.ok(service.mantenerMascota(bean));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/")
	@ResponseBody
	public ResponseEntity<?> actualizaMascota(@RequestBody Mascota bean) {
		try {
			Optional<Mascota> option=service.buscaById(bean.getCodigo());
			if(option.isEmpty()) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(service.mantenerMascota(bean));
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
