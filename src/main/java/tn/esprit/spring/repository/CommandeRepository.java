package tn.esprit.spring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.entity.Commande;
@Repository
public interface CommandeRepository extends CrudRepository<Commande, Integer> {
//	List<User> findByLastName(String lastName);
	Commande findByIdcmd(int idcmd);
	List<Commande> findAll();

}
