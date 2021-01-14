package fr.eni.projetEncheres.bll;

import java.util.List;

import fr.eni.projetEncheres.bo.CategoriesBo;
import fr.eni.projetEncheres.dal.CategoriesDal;

public class CategoriesBll {
	

	public static void insert(CategoriesBo categorie) throws Exception {
		
		CategoriesDal c1 = new CategoriesDal();
		
        if(categorie.getLibelle().trim().equals("")){
            throw new Exception("Nom de catégorie obligatoire");
        }
        c1.insert(categorie);
    }

	
	public static CategoriesBo get(int noCategorie) throws Exception {

		CategoriesDal c1 = new CategoriesDal();
		
        if(noCategorie <= 0){
            throw new Exception("Valeur incorrecte");
        }
        return c1.get(noCategorie);
    }
	
	
	public static void update(CategoriesBo categorie) throws Exception {
		
		CategoriesDal c1 = new CategoriesDal();

        if(categorie.getLibelle().trim().equals("")){
            throw new Exception("Nécessite un nom");
        }
        c1.update(categorie);
    }
	
	
	public static void delete(int noCategorie) throws Exception {
		
		CategoriesDal c1 = new CategoriesDal();

        if(noCategorie <= 0){
            throw new Exception("Valeur incorrecte");
        }
        c1.delete(noCategorie);
    }
	
	
	 public static List<CategoriesBo> selectAll() throws Exception {
		 
		 CategoriesDal c1 = new CategoriesDal();

	        return c1.selectALL();
	    }
	
}



