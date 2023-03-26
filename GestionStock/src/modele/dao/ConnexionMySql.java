package modele.dao;


/*
 * Cr�� le 23 sept. 2014
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Isabelle
 * 23 sept. 2014
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class ConnexionMySql { // DAO = Data Access Object
	
	static Connection cnx;
	
	public ConnexionMySql(){
		cnx = null;
	}
	
	/**
	 * methode qui permet la connexion � la base de donn�es
	 * le fait que la m�thode soit static permet d'�viter d'instancier dans une classe un objet ConnexioMySql
	 * pour utiliser cette m�thode �crire : ConnexionMySql.connecterBd()
	 */
	public static void connecterBd(){
		//connexion � la base de donn�e � partir de jdbc
		String url = "jdbc:mysql://127.0.0.1:3306/stockbdd"; // url : chaine de connexion
		// try permet d'essayer de lancer la connexion
		try {Class.forName("com.mysql.cj.jdbc.Driver"); 
			cnx = DriverManager.getConnection(url,"root",""); 
		} 
		// si la connexion echoue un message d'erreur est affich�
        catch(Exception e) {  System.out.println("Echec lors de la connexion");  } 

	}
	
	/**
	 * @param laRequete requ�te SQL de type SELECT
	 * @return un curseur qui contient les lignes obtenues lors de l'ex�cution de la requ�te, null sinon
	 * pour utiliser cette m�thode �crire : ConnexionMySql.execReqSelection(uneRequete) o� uneRequ�te est de type String
	 */
	public static ResultSet execReqSelection(String laRequete){ 
		connecterBd();
		ResultSet resultatReq = null;
		try {
				Statement requete = cnx.createStatement(); 
				resultatReq =requete.executeQuery(laRequete); 
		} 
		catch(Exception e) {  System.out.println("Erreur requete : "+laRequete);  }


		return resultatReq;	
		
	}
	
	/**
	 * @param laRequete requ�te SQL de type INSERT, UPDATE ou DELETE
	 * @return 1 si la MAJ s'est bien d�roul�e, 0 sinon
	 * pour utiliser cette m�thode �crire : ConnexionMySql.execReqMaj(uneRequete) o� uneRequ�te est de type String
	 */
	public static int execReqMaj(String laRequete){
		connecterBd();
		int nbMaj =0;
		try {
		Statement s = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        nbMaj = s.executeUpdate(laRequete);
        s.close();}
		catch (Exception er) {
			er.printStackTrace(); 
			System.out.println("echec requ�te : "+laRequete); }
   

		return nbMaj;       
	}
		
	/**
	 * attention : tant que la connexion n'est pas ferm�e, 
	 * les MAJ ne sont pas effectives, on reste en mode d�connect�
	 * pour utiliser cette m�thode �crire : ConnexionMySql.fermerConnexionBd()
	 */
	public static void fermerConnexionBd(){
		try{cnx.close();}
		catch(Exception e) {  System.out.println("Erreur sur fermeture connexion");  } 
	}
	
	/**
     * @param laRequete requête SQL paramétrée
     * @param lesParametres les paramètres à utiliser dans la requête
     * @return un curseur qui contient les lignes obtenues lors de l'exécution de la requête, null sinon
     */
    public static ResultSet preparerEtExecuterReqSelection(String laRequete, Object... lesParametres) {
        connecterBd();
        ResultSet resultatReq = null;
        try {
            PreparedStatement requetePreparee = cnx.prepareStatement(laRequete);
            for (int i = 0; i < lesParametres.length; i++) {
                requetePreparee.setObject(i + 1, lesParametres[i]);
            }
            resultatReq = requetePreparee.executeQuery();
        } catch (Exception e) {
            System.out.println("Erreur requête : " + laRequete);
        }
        

        return resultatReq;
    }

    /**
     * @param laRequete requête SQL paramétrée de type INSERT, UPDATE ou DELETE
     * @param lesParametres les paramètres à utiliser dans la requête
     * @return le nombre de lignes affectées par la requête
     */
    public static int preparerEtExecuterReqMaj(String laRequete, Object... lesParametres) {
        connecterBd();
        int nbMaj = 0;
        try {
            PreparedStatement requetePreparee = cnx.prepareStatement(laRequete);
            for (int i = 0; i < lesParametres.length; i++) {
                requetePreparee.setObject(i + 1, lesParametres[i]);
            }
            nbMaj = requetePreparee.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erreur requête : " + laRequete);
        }
       
        return nbMaj;
    }
}
