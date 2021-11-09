package com.mycompagny.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompagny.dtos.VirementRequestDTO;
import com.mycompagny.services.CompteService;

@RestController
public class AccountRestController {
	
	@Autowired
	private CompteService compteService;
	
	@PutMapping("/comptes/virement")
	public void virement(@RequestBody VirementRequestDTO request) {
		compteService.virement(request.getCodeSource(), request.getCodeDestination(), request.getMontant());
	}
	

}
