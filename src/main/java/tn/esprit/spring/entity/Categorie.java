package tn.esprit.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcat;
	private String nomcat;
	
	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Article> articles;

	
	
	public Categorie(int idcat, String nomcat, List<Article> articles) {
		super();
		this.idcat = idcat;
		this.nomcat = nomcat;
		this.articles = articles;
	}

	public Categorie() {
		super();
	}

	public int getIdcat() {
		return idcat;
	}

	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}

	public String getNomcat() {
		return nomcat;
	}

	public void setNomcat(String nomcat) {
		this.nomcat = nomcat;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	
}
