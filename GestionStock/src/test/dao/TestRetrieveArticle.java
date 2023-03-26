package test.dao;

import modele.Article;
import modele.dao.retrieve.RetrieveArticle;

public class TestRetrieveArticle {

	public static void main(String[] args) {

		Article unArticle = RetrieveArticle.retrieveArticle("3057640257773");
		System.out.println(unArticle.getCodebarre() + unArticle.getGroupe() + unArticle.getMarque() + unArticle.getNomArticle() + unArticle.getPrix() + unArticle.getQteUnite() + unArticle.getSousgroupe() + unArticle.getSousgroupe2() + unArticle.getStock() + unArticle.getUnite());
	}

}
