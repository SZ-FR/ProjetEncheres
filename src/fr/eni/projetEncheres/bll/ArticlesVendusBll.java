package fr.eni.projetEncheres.bll;

import java.util.List;
import java.util.logging.Logger;
import fr.eni.projetEncheres.bo.ArticlesVendusBo;
import fr.eni.projetEncheres.dal.ArticlesVendusDal;
import utils.MonLogger;


public class ArticlesVendusBll {
	
private static Logger logger = MonLogger.getLogger("UtilisateursBll");

	public void insert(ArticlesVendusBo articleVendu) throws Exception
 {
	
		ArticlesVendusDal A1 = new ArticlesVendusDal();
	
		if(articleVendu.getNomArticle().isEmpty())
			
		 {
			throw new Exception("Nom article incorrect");
		 }
		
		A1.insert(articleVendu);
	}
	
	public static ArticlesVendusBo get(int noArticle) throws Exception {

		ArticlesVendusDal A1 = new ArticlesVendusDal();
		
        if(noArticle <= 0){
            throw new Exception("Valeur incorrecte");
        }
        return A1.get(noArticle);
    }
	
 public static List<ArticlesVendusBo> selectAll() throws Exception {
		 
		ArticlesVendusDal A1 = new ArticlesVendusDal();

	        return A1.selectALL();
	    }
}

