package com.mycompagny.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.mycompagny.entities.Compte;
import com.mycompagny.enums.TypeCompte;

@RepositoryRestController
public interface CompteRepository extends JpaRepository<Compte, Long> {
	
	// http://127.0.0.1:8083/comptes/search/byType?typeCompte=EPARGNE
	@RestResource(path = "/byType")
	List<Compte>  findByType(TypeCompte typeCompte);

}
