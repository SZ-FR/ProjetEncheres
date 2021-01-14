package fr.eni.projetEncheres.dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.eni.projetEncheres.bo.RetraitsBo;
import utils.MonLogger;

public class RetraitsDal {
	private static final String INSERT = "INSERT INTO RETRAITS(rue, code_postal, ville) VALUES (?,?,?)";
    private static final String GET_BY_NO_RETRAIT = "SELECT * FROM RETRAITS WHERE no_retrait = ?";
    private static final String GET_ALL = "SELECT * FROM RETRAITS";
    private static final String UPDATE = "UPDATE RETRAITS SET no_retrait = ?, rue = ?, code_postal = ?, ville = ? WHERE no_retrait = ?";
    private static final String DELETE = "DELETE RETRAITS WHERE no_retrait = ?";

    private static Logger logger = MonLogger.getLogger("ProjetApplication");
    
    
    
/**
 * 
 * Méthode permettant de créer un retrait
 * @throws IOException
 */
    public RetraitsDal() throws IOException {
    }

    public static void insert(RetraitsBo retrait)
    {
    	try(Connection cnx = Utils.getConnection())
    	{
    		PreparedStatement rqt = cnx.prepareStatement(INSERT);
    		rqt.setString(1, retrait.getRue());
    		rqt.setString(2, retrait.getCodePostal());
    		rqt.setString(3, retrait.getVille());
    		
    		rqt.executeUpdate();
    		
    		
		} catch (SQLException ex) {
			logger.severe("Erreur dans la methode insert(Retraits retrait)avec retrait = " + retrait + "-erreur :" + ex.getMessage()); 
		}	
    	
    }
    
    

/**
 * 
 *     Méthode qui récupère un retrait avec son ID
 * @param noRetrait
 * @return
 */
    public static RetraitsBo get(int noRetrait)
    {
    	RetraitsBo result = null;
    	try(Connection cnx = Utils.getConnection())
    	{
    		PreparedStatement rqt = cnx.prepareStatement(GET_BY_NO_RETRAIT);
    		rqt.setInt(1, noRetrait);
    		ResultSet rs = rqt.executeQuery();
    		
    		if(rs.next())
    		{
    			result = new RetraitsBo();
    			result.setNoRetrait(rs.getInt("no_retrait"));
    			result.setRue(rs.getString("rue"));
    			result.setCodePostal(rs.getString("code_postal"));
    			result.setVille(rs.getString("ville"));
    			
    		}
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return result;
    }
    
    
    
/**
 * 
 * Méthode récupérant une liste des retraits présents dans la BDD
 * @return
 */
    public static List<RetraitsBo> selectALL()
    
    {
    	List<RetraitsBo> utilisateur = new ArrayList<>();
    	try(Connection cnx = Utils.getConnection())
    	{
    		PreparedStatement rqt = cnx.prepareStatement(GET_ALL);
            ResultSet rs = rqt.executeQuery();
            
            while(rs.next())
            {
            	RetraitsBo removal = new RetraitsBo();
            	removal.setNoRetrait(rs.getInt("no_retrait"));
            	removal.setRue(rs.getString("rue"));
            	removal.setCodePostal(rs.getString("code_postal"));
            	removal.setVille(rs.getString("ville"));
            	utilisateur.add(removal);
            }
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	return utilisateur;
    }
    
    
    
    
/**
 * 
 * Méthode permettant la mise à jour des infos dans la table Retraits de la BDD
 * @param retrait
 */
    public static void update(RetraitsBo retrait)
    {
    	try(Connection cnx = Utils.getConnection())
    	{
    		PreparedStatement rqt = cnx.prepareStatement(UPDATE);
    		rqt.setInt(1, retrait.getNoRetrait());
    		rqt.setString(2,retrait.getRue());
    		rqt.setString(3, retrait.getCodePostal());
    		rqt.setString(4, retrait.getVille());
    		
    		
    		
    		rqt.executeUpdate();
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    
    
/**
 * 
 *     Méthode supprimant un retrait avec son ID
 * @param noRetrait
 */
    public static void delete(int noRetrait)
    {
    	try(Connection cnx = Utils.getConnection())
    	{
    		PreparedStatement rqt = cnx.prepareStatement(DELETE);
    		rqt.setInt(1, noRetrait);
    		rqt.executeUpdate();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   
}
