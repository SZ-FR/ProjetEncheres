package fr.eni.projetEncheres.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import fr.eni.projetEncheres.bo.EncheresBo;
import fr.eni.projetEncheres.dal.EncheresDal;
import utils.MonLogger;

public class EncheresBll {

	public void insert(EncheresBo enchere) throws Exception {
		EncheresDal A1 = new EncheresDal();
		
		if(enchere.getMontant_enchere()==0) {
			throw new Exception("Montant saisi incorrect");
		}
		
		A1.insert(enchere);
	}
	
	public void getById(int id) throws Exception {
		
		EncheresDal A1 = new EncheresDal();
		
		if (id <= 0) {
			throw new Exception("Numéro d'enchère incorrect");
		}
		A1.getbyId(id);
	}
	
	public void delete(int id) throws Exception {
		
		EncheresDal A1 = new EncheresDal();
		
		if (id <= 0) {
			throw new Exception("Numéro d'enchère incorrect");
		}
		A1.delete(id);
	}
	
}
