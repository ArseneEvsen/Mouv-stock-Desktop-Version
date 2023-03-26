package test.unitaires;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import modele.Article;
import modele.ArticleBatch;
import modele.dao.AddStock;
import modele.dao.ArticleBatchDao;
import modele.dao.ArticleDao;
import modele.dao.BarcodeOrigin;
import modele.dao.DoTheProductExist;
import modele.dao.GetForeignKey;
import modele.dao.RemoveStock;
import modele.dao.SellArticle;

public class TestUnitaires {
	
	// -------- DoTheProductExist()-----------
	@Test
	public void test() {
		System.out.println("test");
	}
	
	@Test
	public void testProductExistTrue() {
		// Cas où le code-barre existe bien
		assertTrue(DoTheProductExist.DoTheProductExist("3057640257773"));
		}
	@Test
	public void testProductFalse() {
		// Cas où le code-barre n'existe pas
		assertFalse(DoTheProductExist.DoTheProductExist("falseBarcode"));
		
	}
	
	// ----------BarcodeOrigin()------------
	
	@Test
	public void testBarcodeOriginCodebarre() {
		// Cas où le code-barre provient de la table "Codebarre" (lots de produits)
		assertEquals("codebarre",BarcodeOrigin.BarcodeOrigin("codebarretest"));
	}
	@Test
	public void testBarcodeOriginArticle() {
		// Cas où le code-barre provient de la table "article"
		assertEquals("article",BarcodeOrigin.BarcodeOrigin("3057640257773"));
	}
	@Test
	public void testBarcodeOriginNull() {
		// Cas où le code-barre n'existe pas
		assertNull(BarcodeOrigin.BarcodeOrigin(""));
	}
	
	// ------------GetForeignKey()----------
	
	@Test
	public void testGetForeignKeyOfGroups() {
		// Cas où la méthode doit retourner la liste des groupes disponibles
		ArrayList<String> listOfGroups = new ArrayList<String>(Arrays.asList("Boisson", "Confisserie","Conserve", "Epice", "Epicerie salé","Epicerie sucré","Fruit légume","Produit laitier et frais","Surgelé", "Viande"));
		assertEquals(listOfGroups, GetForeignKey.retrieveGroups());
	}
	
	@Test
	public void testGetForeignKeyOfUnderGroups() {
		// Cas où la méthode doit retourner la liste des sous-groupes disponibles
		ArrayList<String> listOfUnderGroups = new ArrayList<String>(Arrays.asList("Alcool", "Eau","Jus de fruit", "Lait", "Soda","Féculent","Huile","Olives","Sauces/Condiment", "Gateau","Pâte à tartiner","Thé/café/Tisane","Fruit/Légume Frais","Fruit/Légume Sec","Fromage","Pâte fraîche","Yogourt"));
		assertEquals(listOfUnderGroups, GetForeignKey.retrieveUnderGroups());
	}
	
	@Test
	public void testGetForeignKeyOfUnite() {
		// Cas où la méthode doit retourner la liste des unité disponibles
		ArrayList<String> listOfUnit = new ArrayList<String>(Arrays.asList("Gramme", "Kilogramme","Litre"));
		assertEquals(listOfUnit, GetForeignKey.retrieveUnite());
	}
	
	@Test
	public void testGetForeignKeyOfBrands() {
		// Cas où la méthode doit retourner la liste des unité disponibles
		ArrayList<String> listOfBrands = new ArrayList<String>(Arrays.asList("Mis", "Suntat"));
		assertEquals(listOfBrands, GetForeignKey.retrieveBrands());
	}
	
	// --------------ArticleDao()----------------
	@Test
	public void testCreateNewArticle() {
		// Cas où l'on passe un objet Article qui n'existe pas en base de donnée
		Article unArticle = new Article ("PeynirTest", 0, "Fromage","Féculent","Produit laitier et frais", "Gramme", 1000, 10, "codebarreTest3", "Suntat");
		assertEquals(1, ArticleDao.CreateArticle(unArticle));
	}
	
	@Test
	public void testCreateArticleTwoTimes() {
		// Cas où l'on passe un objet Article qui existe déjà en base de donnée
		Article unArticle = new Article ("PeynirTest", 0, "Fromage","Féculent","Produit laitier et frais", "Gramme", 1000, 10, "codebarreTest3", "Suntat");
		assertEquals(0, ArticleDao.CreateArticle(unArticle));
	}
	
	@Test
	public void testCreateArticleNegatifPrice() {
		// Cas où l'on essaye de créer un article avec un prix négatif
		Article unArticle = new Article ("PeynirTest", 0, "Fromage","Féculent","Produit laitier et frais", "Gramme", 1000, -5, "codebarreTestPrixNegatif", "Suntat");
		assertEquals(0, ArticleDao.CreateArticle(unArticle));
	}
	
	@Test
	public void testCreateArticleStockNegatif() {
		// Cas où l'on essaye de créer un article avec un stock négatif
		Article unArticle = new Article ("PeynirTest", -1, "Fromage","Féculent","Produit laitier et frais", "Gramme", 1000, 10, "codebarreTestStockNegatif", "Suntat");
		assertEquals(0, ArticleDao.CreateArticle(unArticle));
	}
	// -------------ArticleBatchDao()---------
	
	@Test
	public void testCreateArticleBatch() {
		// Cas où l'on crée une fiche de lot d'article, n'existant pas à ce jour
		Article unArticle = new Article ("Peynir", 0, "Fromage","Féculent","Produit laitier et frais", "Gramme", 1000, 10, "codebarreTest2", "Suntat");
		ArticleBatch unLotArticle = new ArticleBatch("codebarre4",3,5,unArticle);
		assertEquals(1,ArticleBatchDao.CreateArticleBatch(unLotArticle));
	}
	@Test
	public void testCreateArticleBatchTwoTimes() {
		// Cas où l'on crée une fiche de lot d'article, existant déjà
		Article unArticle = new Article ("Peynir", 0, "Fromage","Féculent","Produit laitier et frais", "Gramme", 1000, 10, "codebarreTest2", "Suntat");
		ArticleBatch unLotArticle = new ArticleBatch("codebarre2",3,5,unArticle);
		assertEquals(0,ArticleBatchDao.CreateArticleBatch(unLotArticle));
	}
	
	@Test
	public void testCreateArticleBatchNegatifPrice() {
		// Cas où l'on tente de créer une fiche lot d'article, avec un prix négatif
		Article unArticle = new Article ("Peynir", 0, "Fromage","Féculent","Produit laitier et frais", "Gramme", 1000, 10, "codebarreTest2", "Suntat");
		ArticleBatch unLotArticle = new ArticleBatch("codebarreTestNegatifPrice",3,-5,unArticle);
		assertEquals(0,ArticleBatchDao.CreateArticleBatch(unLotArticle));
	}
	
	@Test
	public void testCreateArticleBatchNegatifStock() {
		// Cas où l'on tente de créer une fiche de lot d'article avec un stock négatif
		Article unArticle = new Article ("Peynir", 0, "Fromage","Féculent","Produit laitier et frais", "Gramme", 1000, 10, "codebarreTest2", "Suntat");
		ArticleBatch unLotArticle = new ArticleBatch("codebarreTestStockPrice",-3,5,unArticle);
		assertEquals(0,ArticleBatchDao.CreateArticleBatch(unLotArticle));
	}
	// ---------AddStock()-------------------
	
	@Test
	public void testAddStockReussi() {
	// Cas où la mise à jour du stock est reussie
		try {
			assertEquals(1,AddStock.AddStock("codebarretest"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddStockEchoué() {
	// Cas où la mise à jour du stock est échoué
		try {
			assertEquals(0,AddStock.AddStock(""));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// -------------RemoveStock()---------------
	@Test
	public void testRemoveStockReussi() {
	// Cas où la mise à jour du stock est reussie
	try {
		assertEquals(1, RemoveStock.removeStock("Codebarretest"));
		} 
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	@Test
	public void testRemoveStockEchoué() {
	// Cas où la mise à jour du stock est échoué
	try {
		assertEquals(0, RemoveStock.removeStock(""));
		} 
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	// ---------SellArticle() + VenteDao()---------------------
	@Test
	public void testSellArticleReussi() {
		// Cas où la vente est reussie
		assertEquals(1, SellArticle.SellArticle("codebarretest"));
	}
	
	@Test
	public void testSellArticleEchoué() {
		// Cas où la vente est échoué
		assertEquals(0, SellArticle.SellArticle(""));
	}
	
	
	
}
