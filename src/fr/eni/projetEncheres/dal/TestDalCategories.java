package fr.eni.projetEncheres.dal;

import java.util.List;

import fr.eni.projetEncheres.bo.CategoriesBo;

public class TestDalCategories {
	
	public static void main(String[] args) {
	
	CategoriesDal cat1 = new CategoriesDal();
	
	//Categories c1 = new Categories("Ameublement");
	//cat1.insert(c1);
	//Categories c2 = new Categories("Informatique");
	//cat1.insert(c2);
	//Categories c3 = new Categories("Jardinage");
	//cat1.insert(c3);
	//Categories c4 = new Categories("Vêtements");
	//cat1.insert(c4);
	//Categories c5 = new Categories("Electroménager");
	//cat1.insert(c5);
	//Categories c6 = new Categories("Livres");
	//cat1.insert(c6);
	//Categories c7 = new Categories("Sports");
	//cat1.insert(c7);
	//Categories c8 = new Categories("Loisirs créatifs");
	//cat1.insert(c8);
	//Categories c9 = new Categories("Jeux");
	//cat1.insert(c9);
	
	CategoriesBo a = cat1.get(3);
	a.setLibelle("Loisir créatif");
	cat1.update(a);
	System.out.println("Article après modification  : " + a.toString() );
	
	
	
	
	//System.out.println("Catégorie :  " + a.toString() );

	
	
	//cat1.delete(2);
	
	
	//List<Categories> categories = cat1.selectALL();
	//System.out.println("\nSélection de toutes les catégories : "  );
	//afficherCategories(categories);
	
	}
	
	//private static void afficherCategories(List<Categories> categories){
		//StringBuffer sb = new StringBuffer();
		//for(Categories cat: categories){
			//sb.append(cat.toString());
			//sb.append("\n");
		//}
		//System.out.println(sb.toString());
	//}
	
}


	
