package modele.dao.creationField;

import modele.dao.ConnexionMySql;

public class CreateBrand {

	// Cette classe permet de créer de nouveaux groupes
	
	public static int CreateBrand(String brand) {
		int reqResult = 0;
		String request = "INSERT INTO marque VALUES (?)";
		
		// requête de création du groupe
		reqResult = ConnexionMySql.preparerEtExecuterReqMaj(request, brand);
		return reqResult;
	}
}
