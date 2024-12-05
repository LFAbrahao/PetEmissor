package com.senac.emissor.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.emissor.entities.Pet;

@Service
public class PetService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public Pet adicionarPet(Pet pet) {
		rabbitTemplate.convertAndSend("fila-ecommerce",pet);
        return pet;
	}
}
