package modele.dao.creationField;

import modele.dao.ConnexionMySql;

public class CreateGroup {

	// Cette classe permet de créer de nouveaux groupes
	
	public static int CreateGroup(String groupe) {
		int reqResult = 0;
		String request = "INSERT INTO groupe VALUES (?,?)";
		String foreignKey = "Alimentaire";
		
		// requête de création du groupe
		reqResult = ConnexionMySql.preparerEtExecuterReqMaj(request, groupe, foreignKey);
		return reqResult;
	}
}
