package modele;

public class ArticleBatch {

	String codebarre;
	int qteArticle;
	float prixLot;
	Article unArticle;
	
	public ArticleBatch(String codebarre, int qteArticle, float prixLot, Article unArticle) {
		this.codebarre = codebarre;
		this.qteArticle = qteArticle;
		this.prixLot = prixLot;
		this.unArticle = unArticle;
	}

	public String getCodebarre() {
		return codebarre;
	}

	public void setCodebarre(String codebarre) {
		this.codebarre = codebarre;
	}

	public int getQteArticle() {
		return qteArticle;
	}

	public void setQteArticle(int qteArticle) {
		this.qteArticle = qteArticle;
	}

	public float getPrixLot() {
		return prixLot;
	}

	public void setPrixLot(int prixLot) {
		this.prixLot = prixLot;
	}

	public Article getUnArticle() {
		return unArticle;
	}

	public void setUnArticle(Article unArticle) {
		this.unArticle = unArticle;
	}

}
