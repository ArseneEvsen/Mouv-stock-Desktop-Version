package modele.dao.creationField;

import modele.dao.ConnexionMySql;

public class CreateUnderGroup {

	// Cette classe permet de créer de nouveaux groupes
	
	public static int CreateUnderGroup (String underGroup, String group) {
		int reqResult = 0;
		String request = "INSERT INTO sousgroupe VALUES (?,?)";		
		
		// requête de création de sous-groupe
		reqResult = ConnexionMySql.preparerEtExecuterReqMaj(request, underGroup, group);
		return reqResult;
	}

}
