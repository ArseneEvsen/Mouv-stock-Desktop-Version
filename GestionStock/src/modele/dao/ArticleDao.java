package modele.dao;

import modele.Article;

public class ArticleDao  {
	
	
	public static int CreateArticle(Article unArticle){
		// Contenu de la requête 
		String requeteInsertion = "INSERT INTO article (nomArticle, stock, sousgroupe1, unite, qteUnite, prix, codebarre, marque, sousgroupe2, groupe) VALUES (?, ?, ?, ?, ?, ?, ?, COALESCE(?, 'Unknown'), ?, ?)";
	    int nbLignesAffectees = 0;    
	    
		// valeurs des paramètres
	        String nomArticle = unArticle.getNomArticle();
	        Integer stock = unArticle.getStock();
	        String sousgroupe1 = unArticle.getSousgroupe();
	        String unite = unArticle.getUnite();
	        float qteUnite = unArticle.getQteUnite();
	        float prix = unArticle.getPrix();
	        String codebarre = unArticle.getCodebarre();
	        String marque = unArticle.getMarque();
	        String sousgroupe2 = unArticle.getSousgroupe2();
	        String groupe = unArticle.getGroupe();
	        
	    if (prix >= 0 && stock >= 0) {
	    // Exécution de la requête avec les paramètre, si les paramètre sont null, envois de null + vérification si le prix et le stock sont positif
	        nbLignesAffectees = ConnexionMySql.preparerEtExecuterReqMaj(requeteInsertion, 
	        nomArticle != null ? nomArticle : null,
	        stock != null ? stock : null,
	        sousgroupe1 != null ? sousgroupe1 : null,
	        unite != null ? unite : null,
	        qteUnite, prix,
	        codebarre != null ? codebarre : null,
	        marque != null ? marque : null,
	        sousgroupe2 != null ? sousgroupe2 : null,
	        groupe != null ? groupe : null
	        );
	    }
	    else {
	    	System.out.println("Le prix et le stock doivent être supérieur ou égal à 0");
	    }
	        System.out.println("Nombre de lignes affectées : " + nbLignesAffectees);
		
		
		ConnexionMySql.fermerConnexionBd();
		return nbLignesAffectees;
	
	};
}
