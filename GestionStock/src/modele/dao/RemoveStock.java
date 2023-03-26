package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveStock {

	// Cette méthode a pour rôle de retirer du stock à partir d'un code-barre donnée
	public static int removeStock(String codebarre) throws SQLException {
		int resultRemoveStock = 0;
		
		//Vérifier si le code-barre existe 
		boolean exist = DoTheProductExist.DoTheProductExist(codebarre); 
		if (exist) {
		
			//Identifier si le code-barre désigne un produit ou un lot de produit
			String origin = BarcodeOrigin.BarcodeOrigin(codebarre);
		
			// Cas si le code-barre désigne un article seul
			if (origin == "article") {
				Integer stock = null;
				
				String requestStockArticle = "SELECT stock FROM article WHERE codebarre = ? ";
				String requestUpdateStockArticle = "UPDATE article SET stock = ? WHERE codebarre = ?";
				
				// Récupération de stock
				ResultSet reqResult = ConnexionMySql.preparerEtExecuterReqSelection(requestStockArticle, codebarre);
				while(reqResult.next()) {
				stock = reqResult.getInt(1);
				}
				stock--;
				//Mise à jour de stock
				int reqResultUpdate = ConnexionMySql.preparerEtExecuterReqMaj(requestUpdateStockArticle, stock, codebarre);
				resultRemoveStock = 1;
			}
			
			// Cas si le code-barre désigne un lot d'article
			if (origin == "codebarre") {
				Integer stock = null;
				Integer qteArticle = null;
				String refCodebarre = null;
			
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
				// Soustraire le stock actuel à la quantité lié 
				stock -= qteArticle;
				
				// Effectuer la mise à jour du stock dans la base de donnée
				int reqResultUpdate = ConnexionMySql.preparerEtExecuterReqMaj(requestUpdate, stock, refCodebarre);
				
				resultRemoveStock = 1;
				}
		
		
		}
		return resultRemoveStock;
	};
	
}
