package modele;

public class Article {

	String nomArticle;
	int stock;
	String sousgroupe;
	String sousgroupe2;
	String groupe;
	String unite;
	float qteUnite;
	float prix;
	String codebarre;
	String marque;
	
	public Article(String nomArticle,int stock,String sousgroupe,String sousgroupe2,String groupe,
		String unite,float qteUnite,float prix, String codebarre,String marque) {
		
		this.nomArticle = nomArticle;
		this.stock = stock;
		this.sousgroupe = sousgroupe;
		this.sousgroupe2 = sousgroupe2;
		this.groupe = groupe;
		this.unite = unite;
		this.qteUnite = qteUnite;
		this.prix = prix;
		this.codebarre = codebarre;
		this.marque = marque;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getSousgroupe() {
		return sousgroupe;
	}

	public void setSousgroupe(String sousgroupe) {
		this.sousgroupe = sousgroupe;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public float getQteUnite() {
		return qteUnite;
	}

	public void setQteUnite(int qteUnite) {
		this.qteUnite = qteUnite;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCodebarre() {
		return codebarre;
	}

	public void setCodebarre(String codebarre) {
		this.codebarre = codebarre;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getSousgroupe2() {
		return sousgroupe2;
	}

	public void setSousgroupe2(String sousgroupe2) {
		this.sousgroupe2 = sousgroupe2;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	};
}
