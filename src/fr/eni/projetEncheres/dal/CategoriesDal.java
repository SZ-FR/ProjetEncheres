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

//test


	public  void insert(CategoriesBo categorie)  {
		try(Connection cnx = Utils.getConnection()){
			PreparedStatement rqt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, categorie.getLibelle());
			
			
			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = rqt.getGeneratedKeys();
				if (rs.next()) {
					categorie.setNo_categorie(rs.getInt(1));
				}
			}
		} catch (Exception ex) {
			logger.severe("Erreur dans la méthode insert(Categories categorie) avec categorie =" + categorie.toString() + " Erreur : " + ex.getMessage());
		}
		

		
	}

	public  CategoriesBo get(int no_categorie)
	{
		CategoriesBo result = null;
		try(Connection cnx = Utils.getConnection())
		{
			PreparedStatement rqt = cnx.prepareStatement(GET_BY_ID);
			rqt.setInt(1, no_categorie);
			ResultSet rs = rqt.executeQuery();

			if(rs.next())
			{
				result = new CategoriesBo();
				result.setNo_categorie(rs.getInt("no_categorie"));
				result.setLibelle(rs.getString("libelle"));
			}
		} catch (SQLException e) {
			logger.severe("Erreur dans la méthode get(int no_categorie) avec no_categorie =" + no_categorie + " Erreur : " + e.getMessage());
		}
		return result;
	}
	
	public  List<CategoriesBo> selectALL()
	{
		List<CategoriesBo> categories = new ArrayList<>();
		try(Connection cnx = Utils.getConnection())
		{
			PreparedStatement rqt = cnx.prepareStatement(GET_ALL);
			ResultSet rs = rqt.executeQuery();
			while(rs.next())
			{
				CategoriesBo categorie = new CategoriesBo();
				categorie.setNo_categorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
				categories.add(categorie);
			}
		} catch (SQLException e) {
			logger.severe("Erreur dans la méthode selectALL() - Erreur : " + e.getMessage());
		}
		return categories;
	}
	public  void update(CategoriesBo categorie)
    {
    	try(Connection cnx = Utils.getConnection())
    	{
    		PreparedStatement rqt = cnx.prepareStatement(UPDATE);
    		rqt.setString(1, categorie.getLibelle());
    		rqt.setInt(2, categorie.getNo_categorie());
    		rqt.executeUpdate();
    	} catch (SQLException e) {
    		logger.severe("Erreur dans la méthode update(Categories categorie) avec categorie =" + categorie.toString() + " Erreur : " + e.getMessage());
		}
    }
	 public  void delete(int no_categorie)
	    {
	    	try(Connection cnx = Utils.getConnection())
	    	{
	    		PreparedStatement rqt = cnx.prepareStatement(DELETE);
	    		rqt.setInt(1, no_categorie);
	    		rqt.executeUpdate();
	    	} catch (SQLException e) {
	    		logger.severe("Erreur dans la méthode delete(int no_categorie) avec no_categorie ="+no_categorie+" - Erreur : " + e.getMessage());
			}
	    }

}
