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

		public void insert(EncheresBo enchere )  {
			try (Connection cnx = Utils.getConnection()) {
				PreparedStatement rqt = cnx.prepareStatement(INSERT);
				
				rqt.setDate(1, today);
				rqt.setInt(2,  enchere.getMontant_enchere());
				rqt.setInt(3, enchere.getNo_article());
				rqt.setInt(4,  enchere.getNo_utilisateur());
				
				rqt.executeUpdate();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		public EncheresBo getbyId(int id) {
			
			EncheresBo result = null;
			
			try (Connection cnx = Utils.getConnection()) {
				
				PreparedStatement rqt = cnx.prepareStatement(GET_BY_ID);
				rqt.setInt(1, id);
				ResultSet rs = rqt.executeQuery();
				
				result.setDate_enchere(rs.getDate("date_enchere"));
				result.setMontant_enchere(rs.getInt("montant_enchere"));
				result.setNo_article(rs.getInt("no_article"));
				result.setNo_utilisateur(rs.getInt("no_utilisateur"));
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		public List<EncheresBo> selectALL() {
			
			List<EncheresBo> listeEncheres = new ArrayList<>();
		
			try (Connection cnx = Utils.getConnection()) {
				PreparedStatement rqt = cnx.prepareStatement(GET_ALL);
				ResultSet rs = rqt.executeQuery();
				
				while(rs.next()) {
					EncheresBo enchere = null;
					enchere.setDate_enchere(rs.getDate("date_enchere"));
					enchere.setMontant_enchere(rs.getInt("montnt_enchere"));
					enchere.setNo_enchere(rs.getInt("no_article"));
					enchere.setNo_utilisateur(rs.getInt("no_utilisateur"));
					
					listeEncheres.add(enchere);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listeEncheres;
		}
	
		public static void delete(int no_enchere)
		 {
		 	try(Connection cnx = Utils.getConnection())
		 	{
		 		PreparedStatement rqt = cnx.prepareStatement(DELETE);
		 		rqt.setInt(1, no_enchere);
		 		rqt.executeUpdate();
		 	} catch (SQLException e) {
				e.printStackTrace();
				}
		 }

}
