package test.dao;

import modele.dao.BarcodeOrigin;

public class BarcodeOriginTest {

	public static void main(String[] args) {
		String result = null;
		String codebarre = "efhzefzf";
		
		result = BarcodeOrigin.BarcodeOrigin(codebarre);
		System.out.println(result);
		}

}
