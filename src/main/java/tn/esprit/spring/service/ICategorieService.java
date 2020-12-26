package tn.esprit.spring.service;


import java.util.List;

import tn.esprit.spring.entity.Categorie;

public interface ICategorieService {

	
	public Categorie ajouterCategorie(Categorie categorie);
	public List<Categorie> returnAll();
	public Categorie getCategorieById(int idcat);
	public String deleteCategorie(int idcat);
	public List<String> findNameCategories();

	
}
