package test.dao;

import modele.Article;
import modele.dao.ArticleDao;

public class ArticleDaoTest {

	public static void main(String[] args) {
		int result = 0;
		Article unArticle = new Article ("PeynirTest", 0, "Fromage","Féculent","Produit laitier et frais", "Gramme", 1000, 10, "codebarreTest2", "Suntat");
		
		result = ArticleDao.CreateArticle(unArticle);
		System.out.println(result);
	}

}
