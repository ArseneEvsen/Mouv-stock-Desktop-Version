package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import view.creationMode.ProductTypeGUI;

public class DoTheProductExist {
	
	// Cette méthode a pour rôle de vérifier si le codebarre existe
	public static boolean DoTheProductExist(String codebarre) {
		boolean resultDoTheProductExist = false;
		String request = "SELECT * FROM ARTICLE WHERE codebarre = ? ";
		String request2 = "SELECT * FROM CODEBARRE WHERE codebarre = ? ";
		
		ResultSet reqResult = ConnexionMySql.preparerEtExecuterReqSelection(request, codebarre);
		ResultSet reqResult2 = ConnexionMySql.preparerEtExecuterReqSelection(request2, codebarre);
		
		try {
			if (reqResult.next()) {
				resultDoTheProductExist = true;
			}
			if (reqResult2.next()) {
				resultDoTheProductExist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return resultDoTheProductExist;
	}
	
}
