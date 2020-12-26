package tn.esprit.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.repository.ArticleRepository;
import tn.esprit.spring.service.IArticleService;
import tn.esprit.spring.service.ICategorieService;
import tn.esprit.spring.service.ICommandeService;

@RestController
public class CrudRestController {

	@Autowired
	ICategorieService categorieService;

	@Autowired
	IArticleService articleService;
	@Autowired
	ICommandeService commandeService;
	
	@Autowired
	ArticleRepository IArticleRepo;
//	// http://localhost:8081/SpringMVC/servlet/
//	@RequestMapping("/")
//	@ResponseBody
//	public String welcome() {
//		return "Bonjour, Bienvenue à l'application de test des Web ServicesREST.";
//	}

	@GetMapping("/get-all-categories")
	@ResponseBody
	public List<Categorie> getAllCategoriesObject() {
		List<Categorie> list = categorieService.returnAll();
		return list;
	}

	// http://localhost:8081/SpringMVC/servlet/ retrieve-user /{user-id}
	@GetMapping("/retrieve-categorie/{idcat}")
	@ResponseBody
	public Categorie getEmployee(@PathVariable("idcat") int idcat) {
		return categorieService.getCategorieById(idcat);

	}

	@PostMapping("/add-categorie")
	@ResponseBody
	public String ajoutercategorie(@RequestBody Categorie c) {
		Categorie categorie = categorieService.ajouterCategorie(c);
		return "add succes";
	}

	// Supprimer User : http://localhost:8081/SpringMVC/servlet/
	// delete-user/{user-id}
	@DeleteMapping("/delete-categorie/{idcat}")
	@ResponseBody
	public String deleteEmployee(@PathVariable("idcat") int idcat) {
		categorieService.deleteCategorie(idcat);
		return "deleted success !";
	}
	
	@PostMapping("/add-article")
	@ResponseBody
	public String ajouterArticle(@RequestBody Article a) {
		Article article = articleService.ajouterArticle(a);
		return "add succes";
	}
	
	@PostMapping("/add-commande")
	@ResponseBody
	public String ajouterArticle(@RequestBody Commande c) {
		Commande article = commandeService.ajouterCommande(c);
		return "add succes";
	}
	
	@PutMapping("/affecter-art-cat/{idcat}/{idart}")
	@ResponseBody
	public void affecteArtCat(@PathVariable("idcat") int idcat,@PathVariable("idart")int idart) {
		Article art = articleService.getArticleById(idart);
		Categorie cat = categorieService.getCategorieById(idcat);
		art.setCategorie(cat);
		articleService.ajouterArticle(art);
		
	} 
	
	@GetMapping("/article-by-categorie/{idcat}")
	@ResponseBody
	public List<String> getAllArticleNamesByCategorie(@PathVariable("idcat")int idcat){
		return articleService.findBycat(idcat);
		 
	} 
	@GetMapping("/categories-name")
	@ResponseBody
	public List<String> getAllCategories(){
		return categorieService.findNameCategories();
		 
	} 
 
}