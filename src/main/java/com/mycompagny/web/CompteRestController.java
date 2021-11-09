package com.mycompagny.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompagny.entities.Compte;
import com.mycompagny.repositories.CompteRepository;

//Creation de web service rest (c'est un web service)

//@RestController
public class CompteRestController {
	
	private CompteRepository compteRepository;

	public CompteRestController(CompteRepository compteRepository) {
		this.compteRepository = compteRepository;
	}
	
	@RequestMapping("/comptes")
	public List<Compte> listComptes(){
		return compteRepository.findAll();
	}

	@RequestMapping("/comptes/{id}")
	public Compte getComptes(@PathVariable(name ="id") Long code){
		return compteRepository.findById(code).get();
	}
	
	
	@PostMapping("/comptes")
	public Compte save(@RequestBody Compte compte) {
		return compteRepository.save(compte);
	}
	
	@PutMapping("/comptes/{code}")
	public Compte update(@PathVariable Long code,@RequestBody Compte compte) {
		compte.setCode(code);
		return compteRepository.save(compte);
	}
	
	@DeleteMapping("/comptes/{code}")
	public void delete(@PathVariable Long code) {
		compteRepository.deleteById(code);
	}
}
