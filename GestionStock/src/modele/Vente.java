package modele;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public class Vente {
	String codebarre;
	float prix;
	String date;
	
	public Vente(String codebarre, float prix) {
		this.codebarre = codebarre;
		this.prix = prix;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		date = dtf.format(now);
	}


	public float getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public String getCodebarre() {
		return codebarre;
	}


	public void setCodebarre(String codebarre) {
		this.codebarre = codebarre;
	}
}
