package com.senac.emissor.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pet implements Serializable {
	
	@Id
	@GeneratedValue
	private int petID;
	
	private String petNome;

	public int getPetID() {
		return petID;
	}

	public void setPetID(int petID) {
		this.petID = petID;
	}

	public String getPetNome() {
		return petNome;
	}

	public void setPetNome(String petNome) {
		this.petNome = petNome;
	}
	
	
}
