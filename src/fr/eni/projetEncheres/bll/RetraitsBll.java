package fr.eni.projetEncheres.bll;

import java.util.List;
import java.util.logging.Logger;

import fr.eni.projetEncheres.bo.RetraitsBo;
import fr.eni.projetEncheres.dal.RetraitsDal;
import utils.MonLogger;

public class RetraitsBll {
	
	private static Logger logger = MonLogger.getLogger("RetraitsBll");
	
	public static void insert(RetraitsBo retrait) throws Exception {
		if(retrait.getRue().isEmpty()) {
			throw new Exception("Rue manquante");	
		}
		if(retrait.getVille().isEmpty()) {
			throw new Exception("Ville manquante");
		}
		if(retrait.getCode_postal().isEmpty()) {
			throw new Exception("Code postal manquant");
		}
		
		RetraitsDal.insert(retrait);
	}

	public static RetraitsBo get(int no_retrait)  {
		return RetraitsDal.get(no_retrait);
	}
	
	public static List<RetraitsBo>  SelectALL() {
		return RetraitsDal.selectALL();
	}
	
	public static void update(RetraitsBo retrait) {
		RetraitsDal.update(retrait);
			
	}
	
	public static void delete(int no_retrait) throws Exception {
        if(no_retrait <= 0)
        {
            throw new Exception("n° retrait incorrect");
        }
        RetraitsDal.delete(no_retrait);
	}
							

}
