package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BarcodeOrigin {
	
	public static String BarcodeOrigin(String codebarre) {
		
		// Cette méthode a pour rôle de retourner l'origine d'un codebarre donnée (table article ou articleLot)
		String origin = null; 
		
		String request = "SELECT * FROM ARTICLE WHERE codebarre = ? ";
		String request2 = "SELECT * FROM CODEBARRE WHERE codebarre = ? ";
		
		ResultSet reqResult = ConnexionMySql.preparerEtExecuterReqSelection(request, codebarre);
		ResultSet reqResult2 = ConnexionMySql.preparerEtExecuterReqSelection(request2, codebarre);
		
		try {
			if (reqResult.next()) {
				origin = "article";
			}
			if (reqResult2.next()) {
				origin = "codebarre";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return origin;
	}
}
