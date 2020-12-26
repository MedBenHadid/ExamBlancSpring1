package tn.esprit.spring.service;


import java.util.List;


import tn.esprit.spring.entity.Commande;

public interface ICommandeService {

	 
	public Commande ajouterCommande(Commande commande);
	public List<Commande> returnAll();
	public String getCommandeById(int idcmd);
	public String deleteCommande(int idcmd);

	
}
