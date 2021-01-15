package fr.eni.projetEncheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fr.eni.projetEncheres.bo.ArticlesVendusBo;
import fr.eni.projetEncheres.bo.EncheresBo;


public class EncheresDal {
	
	Date today = Date.valueOf(LocalDate.now());
	
	private static final String INSERT = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur) VALUES (?,?,?,?)";
	private static final String GET_BY_ID = "SELECT * FROM ENCHERES WHERE no_enchere = ?";
	private static final String GET_ALL = "SELECT * FROM ENCHERES";
	private static final String DELETE = "DELETE ENCHERES WHERE no_categorie = ?";

	
	
	
/**
 * 
 * Méthode permettant de créer une enchère dans la base de données
 * @param enchere
 */
		public void insert(EncheresBo enchere )  {
			try (Connection cnx = ConnectionProvider.getConnection()) {
				PreparedStatement rqt = cnx.prepareStatement(INSERT);
				
				rqt.setDate(1, today);
				rqt.setInt(2,  enchere.getMontantEnchere());
				rqt.setInt(3, enchere.getNoArticle());
				rqt.setInt(4,  enchere.getNoUtilisateur());
				
				rqt.executeUpdate();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
		
		
/** 
 * 
 * Méthode récupérant une enchère par son ID
 * @param id
 * @return
 */
		
		public EncheresBo getbyId(int id) {
			
			EncheresBo result = null;
			
			try (Connection cnx = ConnectionProvider.getConnection()) {
				
				PreparedStatement rqt = cnx.prepareStatement(GET_BY_ID);
				rqt.setInt(1, id);
				ResultSet rs = rqt.executeQuery();
				
				result.setDateEnchere(rs.getDate("date_enchere"));
				result.setMontantEnchere(rs.getInt("montant_enchere"));
				result.setNoArticle(rs.getInt("no_article"));
				result.setNoUtilisateur(rs.getInt("no_utilisateur"));
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		
/**
 * 
 * Méthode récupérant la liste des enchères en cours enregistrées dans la base de données 
 * @return
 */
		
		public List<EncheresBo> selectALL() {
			
			List<EncheresBo> listeEncheres = new ArrayList<>();
		
			try (Connection cnx = ConnectionProvider.getConnection()) {
				PreparedStatement rqt = cnx.prepareStatement(GET_ALL);
				ResultSet rs = rqt.executeQuery();
				
				while(rs.next()) {
					EncheresBo enchere = null;
					enchere.setDateEnchere(rs.getDate("date_enchere"));
					enchere.setMontantEnchere(rs.getInt("montant_enchere"));
					enchere.setNoEnchere(rs.getInt("no_article"));
					enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
					
					listeEncheres.add(enchere);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listeEncheres;
		}
		
		
/**
 * 
 * Méthode supprimant une enchère en utilisant son ID
 * @param noEnchere
 */
	
		public void delete(int noEnchere)
		 {
		 	try(Connection cnx = ConnectionProvider.getConnection())
		 	{
		 		PreparedStatement rqt = cnx.prepareStatement(DELETE);
		 		rqt.setInt(1, noEnchere);
		 		rqt.executeUpdate();
		 	} catch (SQLException e) {
				e.printStackTrace();
				}
		 }

}
