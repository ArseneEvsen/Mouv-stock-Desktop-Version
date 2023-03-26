package test.dao;

import modele.ArticleBatch;
import modele.dao.retrieve.RetrieveArticleBatch;
public class RetrieveArticleBatchTest {

	public static void main(String[] args) {
		ArticleBatch lotArticle = RetrieveArticleBatch.retrieveArticleBatch("codebarretest");
		System.out.println(lotArticle.getCodebarre() + " " + lotArticle.getPrixLot() + " " + lotArticle.getQteArticle() + " " + lotArticle.getUnArticle().getCodebarre());
	

	}

}
