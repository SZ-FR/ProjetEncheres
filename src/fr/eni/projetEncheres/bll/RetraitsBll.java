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
		if(retrait.getCodePostal().isEmpty()) {
			throw new Exception("Code postal manquant");
		}
		
		RetraitsDal.insert(retrait);
	}

	public static RetraitsBo get(int noRetrait)  {
		return RetraitsDal.get(noRetrait);
	}
	
	public static List<RetraitsBo>  SelectALL() {
		return RetraitsDal.selectALL();
	}
	
	public static void update(RetraitsBo retrait) {
		RetraitsDal.update(retrait);
			
	}
	
	public static void delete(int noRetrait) throws Exception {
        if(noRetrait <= 0)
        {
            throw new Exception("numéro de retrait incorrect");
        }
        RetraitsDal.delete(noRetrait);
	}
							

}
