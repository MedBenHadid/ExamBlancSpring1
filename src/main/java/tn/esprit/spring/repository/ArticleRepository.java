package tn.esprit.spring.repository;

import java.util.List;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Article;
@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {
	Article findByIdart(int idart);
	List<Article> findAll();
	
	@Query("SELECT a.nom FROM Article a WHERE a.categorie.idcat = ?1")
	List<String> findBycat(int idcat);

 
	 
}
