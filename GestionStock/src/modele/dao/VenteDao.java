package modele.dao;

import modele.Vente;

public class VenteDao {
	
	public static int createSell(Vente uneVente ) {
		int resultSell = 0;
		
		// Contenu de la requête 
		String requeteInsertion = "INSERT INTO vente (idArticle, prix, date) VALUES (?,?,?)";
	        
		// Récupération du code-barre, du prix et génération de la date automatiquement
	        String codebarre = uneVente.getCodebarre();
	        float prix = uneVente.getPrix(); 
	        String date = uneVente.getDate();
	        
	    if (prix >= 0) {
	    // Création de la vente dans la table Vente, vérification si le prix >=0
	    	resultSell = ConnexionMySql.preparerEtExecuterReqMaj(requeteInsertion, codebarre, prix, date);
	    }
	    else {System.out.println("Le prix doit être supérieur ou égal à 0.");
	    }
	        
	    System.out.println("Nombre de lignes affectées : " + resultSell);
	        
	        ConnexionMySql.fermerConnexionBd();
		
		return resultSell;
	}
}
