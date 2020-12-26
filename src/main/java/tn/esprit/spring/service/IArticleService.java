package tn.esprit.spring.service;


import java.util.List;

import tn.esprit.spring.entity.Article;

public interface IArticleService {

	 
	public Article ajouterArticle(Article article);
	public List<Article> returnAll();
	public Article getArticleById(int idart);
	public String deleteArticle(int idart);
	public List<String> findBycat(int idcat);

	
}
