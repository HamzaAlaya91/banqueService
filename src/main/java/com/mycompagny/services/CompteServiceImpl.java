package com.mycompagny.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompagny.entities.Compte;
import com.mycompagny.repositories.CompteRepository;

@Service
@Transactional
public class CompteServiceImpl  implements CompteService{
	
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public void virement(Long codeSource, Long codeDestination, double montant) {
		Compte c1 = compteRepository.getById(codeSource) ;
		Compte c2 = compteRepository.getById(codeDestination) ;
		c1.setSolde(c1.getSolde()-montant);
		c2.setSolde(c2.getSolde()+montant);
		// on pas besoin de faire un save car on a annoté @Transactional
		compteRepository.save(c1);
		compteRepository.save(c2);

		
	}

}
