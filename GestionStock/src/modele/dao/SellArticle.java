package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import modele.Vente;

public class SellArticle{
	
	public static int SellArticle(String codebarre) {
		int resultSellArticle = 0;
		String origin;
		float ArticleBatchPrice = 0; 
		String refCodebarre;
		float ArticlePrice = 0;  
		
		String requestPriceArticle = "SELECT prix FROM article WHERE codebarre = ? ";
		String requestPriceArticleBatch = "SELECT prixLot FROM codebarre WHERE codebarre = ? ";
		String requestRefCodebarre = "SELECT refcodebarre FROM codebarre WHERE codebarre = ?";
		
		// Vérifier que le produit existe + son origine et gérer la partie stock
		try {
			int resultRemoveStock = RemoveStock.removeStock(codebarre);
			origin = BarcodeOrigin.BarcodeOrigin(codebarre);
			// Si RemoveStock s'est bien passé, alors le produit existe, son stock s'est actualisé, il ne manque plus qu'à noter son prix en vente
			if(resultRemoveStock == 1) {
				if( origin == "article") {
					ResultSet reqPriceArticle = ConnexionMySql.preparerEtExecuterReqSelection(requestPriceArticle, codebarre);
					
					while(reqPriceArticle.next()) {
						ArticlePrice = reqPriceArticle.getFloat(1);
						// logger le prix en table vente
						Vente uneVente = new Vente(codebarre, ArticlePrice);
						VenteDao.createSell(uneVente);
						resultSellArticle = 1;
					}
				}
				
				if(origin == "codebarre") {
					ResultSet reqPriceArticleBatch = ConnexionMySql.preparerEtExecuterReqSelection(requestPriceArticleBatch, codebarre);
					ResultSet reqRefCodebarre = ConnexionMySql.preparerEtExecuterReqSelection(requestRefCodebarre, codebarre);
					
					while(reqPriceArticleBatch.next()) {
						ArticleBatchPrice = reqPriceArticleBatch.getFloat(1); }
					while (reqRefCodebarre.next()) {
						refCodebarre = reqRefCodebarre.getString(1);
						
						// logger le prix en table vente
						Vente uneVente = new Vente(refCodebarre, ArticleBatchPrice);
						VenteDao.createSell(uneVente);
						resultSellArticle = 1;
					}
				}
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resultSellArticle;
	}
}
