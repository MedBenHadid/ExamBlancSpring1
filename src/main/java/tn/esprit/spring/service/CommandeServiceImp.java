package tn.esprit.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.repository.CommandeRepository;

@Service
@Component
public class CommandeServiceImp implements ICommandeService {
@Autowired
CommandeRepository ICommandeService;


public List<Commande> returnAll()
{
 List<Commande> listcmd = ICommandeService.findAll();
	return listcmd;
}

public Commande ajouterCommande(Commande cmd) {
	ICommandeService.save(cmd);
	return cmd;
}


public String getCommandeById(int idcmd)
{
	Commande cmd = ICommandeService.findByIdcmd(idcmd);
          return cmd.toString();
}

   public String deleteCommande(int idcmd)
{
	   ICommandeService.deleteById(idcmd);
	return "delete succes";
}




}
