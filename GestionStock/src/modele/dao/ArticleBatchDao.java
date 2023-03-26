package modele.dao;


import modele.ArticleBatch;

public class ArticleBatchDao {
	public static int CreateArticleBatch(ArticleBatch unLotArticle){
		// Propriétés
		int resultArticleBatchDao = 0;
		String request = "INSERT INTO `codebarre`(`codebarre`, `qteArticle`, `prixLot`, `refcodebarre`) VALUES (?,?,?,?)";
		
		// Vérification si le prix et la quantité donnée dans l'objet ArticleBatch sont supérieurs à 0 ou égaux.
		if (unLotArticle.getPrixLot()>=0 && unLotArticle.getQteArticle() >= 0) {
			// Création de la fiche lot de produits
			resultArticleBatchDao = ConnexionMySql.preparerEtExecuterReqMaj(request, unLotArticle.getCodebarre(),unLotArticle.getQteArticle(),unLotArticle.getPrixLot(),unLotArticle.getUnArticle().getCodebarre());
		}
		ConnexionMySql.fermerConnexionBd();
		// Retourne 0 si tout ne s'est pas déroulé comme prévu
		return resultArticleBatchDao;
		
	};
}
