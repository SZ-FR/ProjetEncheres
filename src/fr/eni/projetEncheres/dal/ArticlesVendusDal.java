package fr.eni.projetEncheres.dal;

import java.util.logging.Logger;

import fr.eni.projetEncheres.bo.ArticlesVendusBo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import utils.MonLogger;
import java.sql.Date;


public class ArticlesVendusDal {Date date = Date.valueOf(LocalDate.now());

private static final String INSERT = "INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_vendeur,no_categorie) VALUES (?,?,?,?,?,?,?,?)";
private static final String GET_BY_NO_ARTICLE = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?";
private static final String GET_ALL = "SELECT * FROM ARTICLES_VENDUS";
private static final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description = ?, date_debut_encheres = ?, dete_fin_encheres = ?, prix_initial = ?, prix_vente = ?, no_vendeur = ?, no_categorie = ? WHERE no_article = ?";
private static final String DELETE = "DELETE ARTICLE_VENDU WHERE no_article = ?";

private static Logger logger = MonLogger.getLogger("ProjetApplication");

public ArticlesVendusDal() throws IOException {
}

/**
 * 
 * Méthode qui insère un article mis en vente par un utilisateur dans la base de données
 * @param articleVendu
 */
public void insert(ArticlesVendusBo articleVendu)
{
	try(Connection cnx = Utils.getConnection())
	{
		PreparedStatement rqt = cnx.prepareStatement(INSERT);
		rqt.setString(1, articleVendu.getNomArticle());
		rqt.setString(2, articleVendu.getDescription());
		rqt.setDate(3, articleVendu.getDateDebutEncheres());
		rqt.setDate(4, articleVendu.getDateFinEncheres());
		rqt.setInt(5, articleVendu.getPrixInitial());
		rqt.setInt(6, articleVendu.getPrixVente());
		rqt.setInt(7, articleVendu.getNoUtilisateur());//no_vendeur
		rqt.setInt(8, articleVendu.getNoCategorie());
		
		rqt.executeUpdate();
		
		
	} catch (SQLException ex) {
		logger.severe("Erreur dans la methode insert(ArticlesVendusBo articleVendu)avec articleVendu = " + articleVendu + "-erreur :" + ex.getMessage()); 
	}	
	
}

/**
 * 
 * Méthode qui permet de récupérer les infos d'un article mis en vente par son ID
 * @param noArticle
 * @return
 */
public ArticlesVendusBo get(int noArticle)

{
	ArticlesVendusBo result = null;
	try(Connection cnx = Utils.getConnection())
	{
		PreparedStatement rqt = cnx.prepareStatement(GET_BY_NO_ARTICLE);
		rqt.setInt(1, noArticle);
		ResultSet rs = rqt.executeQuery();
		
		if(rs.next())
		{
			result = new ArticlesVendusBo();
			result.setNomArticle(rs.getString("nom_article"));
			result.setDescription(rs.getString("description"));
			result.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
			result.setDateFinEncheres(rs.getDate("date_fin_encheres"));
			result.setPrixInitial(rs.getInt("prix_initial"));
			result.setPrixVente(rs.getInt("prix_vente"));
			result.setNoUtilisateur(rs.getInt("no_vendeur"));//no_vendeur
			result.setNoCategorie(rs.getInt("no_categorie"));

			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return result;
}


/**
 * 
 * Méthode permettant d'appeler la liste de tous les articles mis en vente actuellement, présents dans la base de données 
 * @return
 */
public List<ArticlesVendusBo> selectALL()

{
	List<ArticlesVendusBo> articleVendu = new ArrayList<>();
	try(Connection cnx = Utils.getConnection())
	{
		PreparedStatement rqt = cnx.prepareStatement(GET_ALL);
        ResultSet rs = rqt.executeQuery();
        
        while(rs.next())
        {
        	ArticlesVendusBo vente = new ArticlesVendusBo();
        	vente.setNomArticle(rs.getString("nom_article"));
        	articleVendu.add(vente);
        }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return articleVendu;
}

/**
 * 
 * Méthode mettant à jour les infos souhaitées sur un article déjà mis en vente
 * @param articleVendu
 */

public static void update(ArticlesVendusBo articleVendu)
{
	try(Connection cnx = Utils.getConnection())
	{
		PreparedStatement rqt = cnx.prepareStatement(UPDATE);
		rqt.setString(1, articleVendu.getNomArticle());
		rqt.setString(2, articleVendu.getDescription());
		rqt.setDate(3, articleVendu.getDateDebutEncheres());
		rqt.setDate(4, articleVendu.getDateFinEncheres());
		rqt.setInt(5, articleVendu.getPrixInitial());
		rqt.setInt(6, articleVendu.getPrixVente());
		rqt.setInt(7, articleVendu.getNoUtilisateur());//no_vendeur
		rqt.setInt(8, articleVendu.getNoCategorie());
		
		
		
		rqt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

/**
 * 
 * Méthode pour supprimer un article de la base de données avec son ID
 * @param noArticle
 */

public static void delete(int noArticle)
{
	try(Connection cnx = Utils.getConnection())
	{
		PreparedStatement rqt = cnx.prepareStatement(DELETE);
		rqt.setInt(1, noArticle);
		rqt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
