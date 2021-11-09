package com.mycompagny.services;

public interface CompteService {
	
	void virement(Long codeSource, Long codeDestination , double montant);

}
