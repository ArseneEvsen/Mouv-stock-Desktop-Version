package test.dao;

import modele.dao.DoTheProductExist;

public class DoTheProductExistTest {

	public static void main(String[] args) {
		String codebarre = "efhzefzf";
		boolean result = false;
		
		result = DoTheProductExist.DoTheProductExist(codebarre);
		System.out.println(result);
	}

}
