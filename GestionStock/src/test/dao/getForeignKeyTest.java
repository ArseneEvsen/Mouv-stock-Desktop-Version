package test.dao;

import java.util.ArrayList;

import modele.dao.GetForeignKey;

public class getForeignKeyTest {

	public static void main(String[] args) {
		
		ArrayList<String> listOfUnderGroups = GetForeignKey.retrieveBrands();
		for( String groupe : listOfUnderGroups) {
			System.out.println(groupe);
		}
	}

}
