package modele.dao.retrieve;

import java.sql.ResultSet;
import java.sql.SQLException;

import modele.Article;
import modele.dao.BarcodeOrigin;
import modele.dao.ConnexionMySql;
import modele.dao.DoTheProductExist;

public class RetrieveArticle {
	
	public static Article retrieveArticle(String codebarre) {
		// Cette méthode crée et retourne un objet Article, à partir d'un codebarre
		Article unArticle = null;
		String requestArticle = "SELECT * FROM article WHERE codebarre = ?";
			
				ResultSet reqArticle = ConnexionMySql.preparerEtExecuterReqSelection(requestArticle, codebarre);
				try {
					while(reqArticle.next()) {
						// Récupération des valeurs des colonnes de la table article
						String nomArticle = reqArticle.getString(1);
						int stock = reqArticle.getInt(2);
						float qteUnite = reqArticle.getFloat(3);
						float prix = reqArticle.getFloat(4);
						String codebarreArticle = reqArticle.getString(5);
						String unite = reqArticle.getString(6);
						String sousgroupe1 = reqArticle.getString(7);
						String groupe = reqArticle.getString(8);
						String sousgroupe2 = reqArticle.getString(9);
						String marque = reqArticle.getString(10);
						
						// Création d'un objet Article à partir de ces valeurs
						unArticle = new Article(nomArticle,stock,sousgroupe1,sousgroupe2,groupe,unite,qteUnite,prix, codebarre,marque);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		return unArticle;
	}
}
