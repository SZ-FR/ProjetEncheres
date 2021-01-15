package fr.eni.projetEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.eni.projetEncheres.bo.CategoriesBo;

import utils.MonLogger;

public class CategoriesDal {

	private static final String INSERT = "INSERT INTO CATEGORIES VALUES (?)";
	private static final String GET_BY_ID = "SELECT * FROM CATEGORIES WHERE no_categorie = ?";
	private static final String GET_ALL = "SELECT * FROM CATEGORIES";
	private static final String UPDATE = "UPDATE CATEGORIES SET libelle = ? WHERE no_categorie = ?";
	private static final String DELETE = "DELETE CATEGORIES WHERE no_categorie = ?";

	private static Logger logger = MonLogger.getLogger("ProjetApplication");



/**
 * 
 * Méthode permettant de créer une catégorie d'articles dans la base de données
 * @param categorie
 */
	public  void insert(CategoriesBo categorie)  {
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement rqt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, categorie.getLibelle());
			
			
			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = rqt.getGeneratedKeys();
				if (rs.next()) {
					categorie.setNoCategorie(rs.getInt(1));
				}
			}
		} catch (Exception ex) {
			logger.severe("Erreur dans la méthode insert(CategoriesDal categorie) avec categorie =" + categorie.toString() + " Erreur : " + ex.getMessage());
		}
	}
	
	
/**
 * 
 * Méthode récupérant une catégorie par son ID
 * @param noCategorie
 * @return
 */
	public  CategoriesBo get(int noCategorie)
	{
		CategoriesBo result = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement rqt = cnx.prepareStatement(GET_BY_ID);
			rqt.setInt(1, noCategorie);
			ResultSet rs = rqt.executeQuery();

			if(rs.next())
			{
				result = new CategoriesBo();
				result.setNoCategorie(rs.getInt("no_categorie"));
				result.setLibelle(rs.getString("libelle"));
			}
		} catch (SQLException e) {
			logger.severe("Erreur dans la méthode get(int noCategorie) avec noCategorie =" + noCategorie + " Erreur : " + e.getMessage());
		}
		return result;
	}
	
	
/**
 * 
 * Méthode retournant une liste des catégories enregistrées dans la base de données
 * @return
 */
	public  List<CategoriesBo> selectALL()
	{
		List<CategoriesBo> categories = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement rqt = cnx.prepareStatement(GET_ALL);
			ResultSet rs = rqt.executeQuery();
			while(rs.next())
			{
				CategoriesBo categorie = new CategoriesBo();
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
				categories.add(categorie);
			}
		} catch (SQLException e) {
			logger.severe("Erreur dans la méthode selectALL() - Erreur : " + e.getMessage());
		}
		return categories;
	}
	
	
/**
 * 
 * Méthode permettant la mise à jour d'une catégorie
 * @param categorie
 */
	public  void update(CategoriesBo categorie)
    {
    	try(Connection cnx = Utils.getConnection())
    	{
    		PreparedStatement rqt = cnx.prepareStatement(UPDATE);
    		rqt.setString(1, categorie.getLibelle());
    		rqt.setInt(2, categorie.getNoCategorie());
    		rqt.executeUpdate();
    	} catch (SQLException e) {
    		logger.severe("Erreur dans la méthode update(CategoriesDal categorie) avec categorie =" + categorie.toString() + " Erreur : " + e.getMessage());
		}
    }
	
	
/**
 * 
 * Méthode supprimant une catégorie avec son ID
 * @param noCategorie
 */
	 public  void delete(int noCategorie)
	    {
	    	try(Connection cnx = Utils.getConnection())
	    	{
	    		PreparedStatement rqt = cnx.prepareStatement(DELETE);
	    		rqt.setInt(1, noCategorie);
	    		rqt.executeUpdate();
	    	} catch (SQLException e) {
	    		logger.severe("Erreur dans la méthode delete(int noCategorie) avec noCategorie ="+noCategorie+" - Erreur : " + e.getMessage());
			}
	    }

}
