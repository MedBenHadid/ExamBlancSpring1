package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Date;
import java.util.List;
@Entity
public class Commande implements Serializable {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int idcmd;
private Date dateLivraison;

@Enumerated(EnumType.STRING)
//@NotNull
private Status status;

@OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
private List<Article> articles;



public Commande(int idcmd, Date dateLivraison, Status status, List<Article> articles) {
	super();
	this.idcmd = idcmd;
	this.dateLivraison = dateLivraison;
	this.status = status;
	this.articles = articles;
}
public Commande() {
	super();
	
}

public int getIdcmd() {
	return idcmd;
}

public void setIdcmd(int idcmd) {
	this.idcmd = idcmd;
}

public Date getDateLivraison() {
	return dateLivraison;
}

public void setDateLivraison(Date dateLivraison) {
	this.dateLivraison = dateLivraison;
}

public Status getStatus() {
	return status;
}

public void setStatus(Status status) {
	this.status = status;
}

public List<Article> getArticles() {
	return articles;
}

public void setArticles(List<Article> articles) {
	this.articles = articles;
}





}
