package com.restapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.dao.PersonaDAO;
import com.restapi.model.Persona;


@RestController
@CrossOrigin
@RequestMapping("personas") // Ruta principal http://localhost:8080/personas
public class PersonaRest {

	@Autowired
	private PersonaDAO personaDAO; // injecto las dependencias de la interface PersonaDAO que trae jparespository
	
	
	//METODOS HTTP - SOLICITUD AL SERVIDOR
	
	// estados: 200 ok - 500 error logica - 404 error rutas
	
	@PostMapping("/guardar") // Ruta secundaria http://localhost:8080/personas/guardar
	public void guardar(@RequestBody Persona persona) {
		personaDAO.save(persona);
	}
	
	
	@GetMapping("/listar")
	public List<Persona> listar(){
		return personaDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void borrar(@PathVariable("id") Integer id) {
		personaDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public void actualizar(@PathVariable("id") Integer id, @RequestBody Persona persona) {
		boolean existencia;
		existencia = personaDAO.existsById(id);
		if (existencia == true) {
			personaDAO.save(persona);
		}
		System.out.println("No existe");
	}
}
	

