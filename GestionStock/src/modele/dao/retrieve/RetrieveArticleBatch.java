package modele.dao.retrieve;

import java.sql.ResultSet;
import java.sql.SQLException;

import modele.Article;
import modele.ArticleBatch;
import modele.dao.ConnexionMySql;

public class RetrieveArticleBatch {
	// Cette méthode crée et retourne un objet ArticleBatch, à partir d'un codebarre
	
	public static ArticleBatch retrieveArticleBatch (String codebarre) {
		ArticleBatch lotArticle = null;
		String refCodebarre = null;
		String requestRefcodebarreFromBatch = "SELECT refcodebarre FROM codebarre WHERE codebarre = ?";
		String requestArticleWithBatchCodebarre = "SELECT * FROM codebarre WHERE codebarre = ?";
		
		// Récupérer le code-barre qui réfère l'article
		ResultSet reqRefCodebarre = ConnexionMySql.preparerEtExecuterReqSelection(requestRefcodebarreFromBatch, codebarre);
		try {
			if(reqRefCodebarre.next()) {
				refCodebarre = reqRefCodebarre.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Créer un objet Article à partir des résultats obtenus
		Article unArticle = RetrieveArticle.retrieveArticle(refCodebarre);
		
		// Récupérer les données de la table du lot d'Articles
		ResultSet reqArticleBatch = ConnexionMySql.preparerEtExecuterReqSelection(requestArticleWithBatchCodebarre, codebarre);
		
		// Créer un objet à partir des résultats obtenu
		try {
			while(reqArticleBatch.next()) {
			String codebarreArticleBatch =  reqArticleBatch.getString(1);
			int qteArticle = reqArticleBatch.getInt(2);
			float prixLot = reqArticleBatch.getFloat(3);
			
			lotArticle = new ArticleBatch(codebarreArticleBatch,qteArticle,prixLot, unArticle);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lotArticle;
	}
}
