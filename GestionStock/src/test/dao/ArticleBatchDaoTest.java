package test.dao;

import modele.Article;
import modele.ArticleBatch;
import modele.dao.ArticleBatchDao;

public class ArticleBatchDaoTest {

	public static void main(String[] args) {
		int result = 0;
		Article unArticle = new Article ("Peynir", 0, "Fromage","Féculent","Produit laitier et frais", "Gramme", 1000, 10, "codebarreTest2", "Suntat");
		ArticleBatch unLotArticle = new ArticleBatch("codebarre2",3,5,unArticle);
		
		result = ArticleBatchDao.CreateArticleBatch(unLotArticle);
		System.out.println(result);
	}
}


