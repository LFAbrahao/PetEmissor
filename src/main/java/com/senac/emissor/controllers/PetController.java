package com.senac.emissor.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.emissor.entities.Pet;
import com.senac.emissor.service.PetService;

@RestController
@RequestMapping("pet")
public class PetController {
	
	private final PetService petService;
	
	public PetController(PetService pratoService) {
		this.petService = pratoService;
	}
	
	@PostMapping(value="adicionarPet")
	public ResponseEntity<Pet> adicionarPet(@RequestBody Pet pet){
		Pet tempPet=petService.adicionarPet(pet);
		return ResponseEntity.ok(tempPet);
	}
}
