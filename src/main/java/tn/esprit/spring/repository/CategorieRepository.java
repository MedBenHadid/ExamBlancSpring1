package tn.esprit.spring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Categorie;
@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Integer> {
//	List<User> findByLastName(String lastName);
	Categorie findByIdcat(int idcat);
	List<Categorie> findAll();

	@Query("SELECT c.nomcat FROM Categorie c")
	List<String> findNameCategories();
	
}
