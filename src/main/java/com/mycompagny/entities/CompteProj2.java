package com.mycompagny.entities;

import org.springframework.data.rest.core.config.Projection;

import com.mycompagny.enums.TypeCompte;

@Projection(name = "p2", types = Compte.class)
public interface CompteProj2 {
	Long getSolde();
	TypeCompte getTypeCompte();

}
