package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.repository.ArticleRepository;
import tn.esprit.spring.repository.CategorieRepository;
@Service
@Component
public class ArticleServiceImp implements IArticleService {
@Autowired
ArticleRepository IArticleService;


public List<Article> returnAll()
{
 List<Article> listart=IArticleService.findAll();
	return listart;
}

public Article ajouterArticle(Article article) {
	IArticleService.save(article);
	return article;
}


public Article getArticleById(int idart)
{
	Article a = IArticleService.findByIdart(idart);
          return a;
}

   public String deleteArticle(int idart)
{
	   IArticleService.deleteById(idart);
	return "delete succes";
}
	public List<String> findBycat(int idcat)
	{
		return IArticleService.findBycat(idcat);
	}




}
