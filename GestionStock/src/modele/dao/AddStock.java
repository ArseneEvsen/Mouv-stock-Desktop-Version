package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddStock {
	
	// Cette méthode a pour rôle d'ajouter du stock à partir d'un code-barre donnée
	
	public static int AddStock(String codebarre) throws SQLException {
		int resultAddStock = 0; 
		
		//Vérifier si le code-barre existe
		boolean exist = DoTheProductExist.DoTheProductExist(codebarre);
		
		if (exist) {
			
			//S'il existe, identifier si le code-barre désigne un produit ou un lot de produit
			String origin = BarcodeOrigin.BarcodeOrigin(codebarre);
		
			// Cas si le code-barre désigne un article seul
			if (origin == "article") {
				Integer stock = null;
				
				// Définition des requêtes SQL
				String requestStockArticle = "SELECT stock FROM article WHERE codebarre = ? ";
				String requestUpdateStockArticle = "UPDATE article SET stock = ? WHERE codebarre = ?";
				
				// Récupération de stock
				ResultSet reqResult = ConnexionMySql.preparerEtExecuterReqSelection(requestStockArticle, codebarre);
				while(reqResult.next()) {
				stock = reqResult.getInt(1);
				} 
				stock++;
				//Mise à jour de stock
				resultAddStock = ConnexionMySql.preparerEtExecuterReqMaj(requestUpdateStockArticle, stock, codebarre);
			}
			
			// Cas si le code-barre désigne un lot d'article
			if (origin == "codebarre") {
				Integer stock = null;
				Integer qteArticle = null;
				String refCodebarre = null;
			
				// Définition des requêtes SQL
				String requestRefBarcode = "SELECT refcodebarre FROM codebarre WHERE codebarre = ? ";
				String requestQteArticle = "SELECT qteArticle FROM codebarre WHERE codebarre = ?";
				String requestStock = "SELECT stock FROM article WHERE codebarre = ? ";
				String requestUpdate = "UPDATE article SET stock = ? WHERE codebarre = ?";
			
				// Recupération du produit lié au code-barre
				ResultSet reqResultRefBarcode = ConnexionMySql.preparerEtExecuterReqSelection(requestRefBarcode, codebarre);
				while(reqResultRefBarcode.next()) {
				refCodebarre = reqResultRefBarcode.getString(1);
				}
				// Récupérer la quantité du lot lié au code-barre
				ResultSet reqResultQteArticle = ConnexionMySql.preparerEtExecuterReqSelection(requestQteArticle, codebarre);
				while(reqResultQteArticle.next()) {
				qteArticle = reqResultQteArticle.getInt(1);
				}
				// Récupérer le stock actuel du produit lié
				ResultSet reqResultStock = ConnexionMySql.preparerEtExecuterReqSelection(requestStock, refCodebarre);
				while(reqResultStock.next()) {
				stock = reqResultStock.getInt(1);
				}
				// Additionner le stock actuel à la quantité lié 
				stock += qteArticle;
				
				// Effectuer la mise à jour du stock dans la base de donnée
				resultAddStock = ConnexionMySql.preparerEtExecuterReqMaj(requestUpdate, stock, refCodebarre);
				}
		
		
		}
		return resultAddStock;
	};

}
