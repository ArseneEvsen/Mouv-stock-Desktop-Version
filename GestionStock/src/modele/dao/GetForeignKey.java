package modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

public class GetForeignKey {

	// Cette classe dispose de méthodes permettant de retourner des valeurs nécessaire à la création d'un article
	
	public static ArrayList<String> retrieveGroups() {
		// Méthode pour récupérer une liste des groupes possible, de la table "groupe"
		// Propriétés
		String request;
		ArrayList<String> listOfGroups = new ArrayList<>();
		 
		
		request = "Select groupe FROM groupe";
		ResultSet result = ConnexionMySql.execReqSelection(request);
		
		try {
			while (result.next()) {
				listOfGroups.add(result.getString(1));
			}
		}
		catch(Exception e) {
			System.out.println("erreur result.next() pour la requète - Select groupe FROM groupe");
			e.printStackTrace();
			}
		
		return listOfGroups;
	}
	
	public static ArrayList<String> retrieveUnderGroups() {
		// Méthode pour récupérer une liste des sous-groupes possible, de la table "sousgroupe"
		// Propriétés
		String request;
		ArrayList<String> listOfUnderGroups = new ArrayList<>();
		 
		
		request = "Select sousgroupe FROM sousgroupe";
		ResultSet result = ConnexionMySql.execReqSelection(request);
		
		try {
			while (result.next()) {
				listOfUnderGroups.add(result.getString(1));
			}
		}
		catch(Exception e) {
			System.out.println("erreur result.next() pour la requète - Select sousgroupe FROM groupe");
			e.printStackTrace();
			}
		
		return listOfUnderGroups;
	}
	
	public static ArrayList<String> retrieveBrands() {
		// Méthode pour récupérer une liste des sous-groupes possible, de la table "sousgroupe"
		// Propriétés
		String request;
		ArrayList<String> listOfBrands = new ArrayList<>();
		 
		
		request = "Select marque FROM marque";
		ResultSet result = ConnexionMySql.execReqSelection(request);
		
		try {
			while (result.next()) {
				listOfBrands.add(result.getString(1));
			}
		}
		catch(Exception e) {
			System.out.println("erreur result.next() pour la requète - Select marque FROM marque");
			e.printStackTrace();
			}
		
		return listOfBrands;
	}
	
	public static ArrayList<String> retrieveUnite() {
		// Méthode pour récupérer une liste des sous-groupes possible, de la table "sousgroupe"
		// Propriétés
		String request;
		ArrayList<String> listOfUnite = new ArrayList<>();
		 
		
		request = "Select unite FROM unite";
		ResultSet result = ConnexionMySql.execReqSelection(request);
		
		try {
			while (result.next()) {
				listOfUnite.add(result.getString(1));
			}
		}
		catch(Exception e) {
			System.out.println("erreur result.next() pour la requète - Select unite FROM unite");
			e.printStackTrace();
			}
		
		return listOfUnite;
	}
}