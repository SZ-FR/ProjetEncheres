package fr.eni.projetEncheres.dal;


	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.logging.Logger;



	import fr.eni.projetEncheres.bo.UtilisateursBo;
	import utils.MonLogger;

	public class UtilisateursDal {
		private static final String INSERT = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	    private static final String GET_BY_NO_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
	    private static final String GET_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo =?";
	    private static final String GET_ALL = "SELECT * FROM UTILISATEURS";
	    private static final String UPDATE = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone=?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur= ? WHERE no_utilisateur = ?";
	    private static final String DELETE = "DELETE UTILISATEURS WHERE no_utilisateur = ?";

	    private static Logger logger = MonLogger.getLogger("ProjetApplication");

	    public UtilisateursDal() throws IOException {
	    }
	    
	    

/**
 * 
 * Méthode créant un utilisateur dans la base de données
 * @param utilisateur
 */
	    public void insert(UtilisateursBo utilisateur)
	    {
	    	try(Connection cnx = Utils.getConnection())
	    	{
	    		PreparedStatement rqt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
	    		rqt.setString(1, utilisateur.getPseudo());
	    		rqt.setString(2, utilisateur.getNom());
	    		rqt.setString(3, utilisateur.getPrenom());
	    		rqt.setString(4, utilisateur.getEmail());
	    		rqt.setString(5, utilisateur.getTelephone());
	    		rqt.setString(6, utilisateur.getRue());
	    		rqt.setString(7, utilisateur.getCodePostal());
	    		rqt.setString(8, utilisateur.getVille());
	    		rqt.setString(9, utilisateur.getMotDePasse());
	    		rqt.setInt(10, utilisateur.getCredit());
	    		rqt.setInt(11, utilisateur.getAdministrateur());
	    		
	    		//help
	    		int nbRows = rqt.executeUpdate();
				if (nbRows == 1) {
					ResultSet rs = rqt.getGeneratedKeys();
					if (rs.next()) {
						utilisateur.setNoUtilisateur(rs.getInt(1));
					}
				}
			} catch (SQLException ex) {
				logger.severe("Erreur dans la methode insert(Utilisateurs utilisateur)avec utilisateur = " + utilisateur + "-erreur :" + ex.getMessage()); 
				ex.printStackTrace();
			}	
	    	
	    }
	    
	    
	    

/**
 * 
 * Méthode pour récupérer un utilisateur avec son ID	    
 * @param noUtilisateur
 * @return
 */
	    public UtilisateursBo get(int noUtilisateur)
	    {
	    	UtilisateursBo result = null;
	    	try(Connection cnx = Utils.getConnection())
	    	{
	    		PreparedStatement rqt = cnx.prepareStatement(GET_BY_NO_UTILISATEUR);
	    		rqt.setInt(1, noUtilisateur);
	    		ResultSet rs = rqt.executeQuery();
	    		
	    		if(rs.next())
	    		{
	    			result = new UtilisateursBo();
	    			result.setNoUtilisateur(rs.getInt("no_utilisateur"));
	    			result.setPseudo(rs.getString("pseudo"));
	    			result.setNom(rs.getString("nom"));
	    			result.setPrenom(rs.getString("prenom"));
	    			result.setEmail(rs.getString("email"));
	    			result.setTelephone(rs.getString("telephone"));
	    			result.setRue(rs.getString("rue"));
	    			result.setCodePostal(rs.getString("code_postal"));
	    			result.setVille(rs.getString("ville"));
	    			result.setMotDePasse(rs.getString("mot_de_passe"));
	    			result.setCredit(rs.getInt("credit"));
	    			result.setAdministrateur(rs.getInt("administrateur"));
	    		}
	    	} catch (SQLException e) {
				e.printStackTrace();
			}
	    	
	    	return result;
	    }
	    
	    
	    
/**
 * 
 * Méthode récupérant un utilisateur grâce à son pseudo	    
 * @param pseudo
 * @return
 */
	    public UtilisateursBo get(String pseudo)
	    {
	    	UtilisateursBo result = null;
	    	try(Connection cnx = Utils.getConnection())
	    	{
	    		PreparedStatement rqt = cnx.prepareStatement(GET_BY_PSEUDO);
	    		rqt.setString(1, pseudo);
	    		ResultSet rs = rqt.executeQuery();
	    		
	    		if(rs.next())
	    		{
	    			result = new UtilisateursBo();
	    			result.setNoUtilisateur(rs.getInt("no_utilisateur"));
	    			result.setPseudo(rs.getString("pseudo"));
	    			result.setNom(rs.getString("nom"));
	    			result.setPrenom(rs.getString("prenom"));
	    			result.setEmail(rs.getString("email"));
	    			result.setTelephone(rs.getString("telephone"));
	    			result.setRue(rs.getString("rue"));
	    			result.setCodePostal(rs.getString("code_postal"));
	    			result.setVille(rs.getString("ville"));
	    			result.setMotDePasse(rs.getString("mot_de_passe"));
	    			result.setCredit(rs.getInt("credit"));
	    			result.setAdministrateur(rs.getInt("administrateur"));
	    		}
	    	} catch (SQLException e) {
				e.printStackTrace();
			}
	    	
	    	return result;
	    }
	    
	    
/**
 * 
 * Méthode remontant la liste de tous les utilisateurs enregistrés dans la base de données	    
 * @return
 */
	    
	    public List<UtilisateursBo> selectALL()
	    
	    {
	    	List<UtilisateursBo> utilisateur = new ArrayList<>();
	    	try(Connection cnx = Utils.getConnection())
	    	{
	    		PreparedStatement rqt = cnx.prepareStatement(GET_ALL);
	            ResultSet rs = rqt.executeQuery();
	            
	            while(rs.next())
	            {
	            	UtilisateursBo user = new UtilisateursBo();
	            	user.setNom(rs.getString("nom"));
	            	user.setPrenom(rs.getString("prenom"));
	            	utilisateur.add(user);
	            }
	    	} catch (SQLException e) {
				e.printStackTrace();
			}
	    	return utilisateur;
	    }
	    
	    
	    
/**
 * 
 * Méthode permettant la mise à jours des infos des utilisateurs
 * @param utilisateur
 */
	    public void update(UtilisateursBo utilisateur)
	    {
	    	try(Connection cnx = Utils.getConnection())
	    	{
	    		PreparedStatement rqt = cnx.prepareStatement(UPDATE);
	    		rqt.setString(1, utilisateur.getPseudo());
	    		rqt.setString(2, utilisateur.getNom());
	    		rqt.setString(3, utilisateur.getPrenom());
	    		rqt.setString(4, utilisateur.getEmail());
	    		rqt.setString(5, utilisateur.getTelephone());
	    		rqt.setString(6, utilisateur.getRue());
	    		rqt.setString(7, utilisateur.getCodePostal());
	    		rqt.setString(8, utilisateur.getVille());
	    		rqt.setString(9, utilisateur.getMotDePasse());
	    		rqt.setInt(10, utilisateur.getCredit());
	    		rqt.setInt(11, utilisateur.getAdministrateur());
	    		rqt.setInt(12, utilisateur.getNoUtilisateur());
	    		
	    		rqt.executeUpdate();
	    		
	    	} catch (SQLException e) {
	    		logger.severe("Erreur dans la méthode update(Utilisateurs utilisateur) avec utilisateur =" + utilisateur.toString() + " Erreur : " + e.getMessage());
			}
	    }
	    
	    

/**
 * 
 * Méthode pour supprimer un utilisateur avec son ID	    
 * @param noUtilisateur
 */
	    public void delete(int noUtilisateur)
	    {
	    	try(Connection cnx = Utils.getConnection())
	    	{
	    		PreparedStatement rqt = cnx.prepareStatement(DELETE);
	    		rqt.setInt(1, noUtilisateur);
	    		rqt.executeUpdate();
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	   
	}



