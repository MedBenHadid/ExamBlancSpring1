package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.repository.CategorieRepository;
@Service
@Component
public class CategorieServiceImp implements ICategorieService {
@Autowired
CategorieRepository ICategorieService;


public List<Categorie> returnAll()
{
 List<Categorie> listuser=ICategorieService.findAll();
	return listuser;
}

public Categorie ajouterCategorie(Categorie categorie) {
	ICategorieService.save(categorie);
	return categorie;
}


public Categorie getCategorieById(int idcat)
{
 Categorie c =ICategorieService.findById(idcat).get();
          return c;
}

   public String deleteCategorie(int idcat)
{
	   ICategorieService.deleteById(idcat);
	return "delete succes";
}
	public List<String> findNameCategories(){
		return ICategorieService.findNameCategories();
	}




}
