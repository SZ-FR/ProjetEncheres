package fr.eni.projetEncheres.bll;

import java.util.List;
import java.util.logging.Logger;
import fr.eni.projetEncheres.bo.ArticlesVendusBo;
import fr.eni.projetEncheres.dal.ArticlesVendusDal;
import utils.MonLogger;


public class ArticlesVendusBll {
	
private static Logger logger = MonLogger.getLogger("UtilisateursBll");
	
	public void insert(ArticlesVendusBo article_vendu) throws Exception
 {
	
		ArticlesVendusDal A1 = new ArticlesVendusDal();
	
		if(article_vendu.getNom_article().isEmpty())
			
		 {
			throw new Exception("nom article incorrect");
		 }
		
		A1.insert(article_vendu);
	}
	
	public static ArticlesVendusBo get(int no_article) throws Exception {

		ArticlesVendusDal A1 = new ArticlesVendusDal();
		
        if(no_article <= 0){
            throw new Exception("Valeur incorrecte");
        }
        return A1.get(no_article);
    }
	
 public static List<ArticlesVendusBo> selectAll() throws Exception {
		 
		ArticlesVendusDal A1 = new ArticlesVendusDal();

	        return A1.selectALL();
	    }
}

