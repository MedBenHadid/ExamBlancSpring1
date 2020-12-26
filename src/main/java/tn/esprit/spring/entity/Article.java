package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idart;
	private String nom;
	private int prix;
	private String image;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcat")
    private Categorie categorie;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcmd")
    private Commande commande;
	
	
	
	public Article(int idart, String nom, int prix, String image, Categorie categorie, Commande commande) {
		super();
		this.idart = idart;
		this.nom = nom;
		this.prix = prix;
		this.image = image;
		this.categorie = categorie;
		this.commande = commande;
	}
	public Article() {
		super();

	}

	public int getIdart() {
		return idart;
	}

	public void setIdart(int idart) {
		this.idart = idart;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	} 	
	
	

}
