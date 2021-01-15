package fr.eni.projetEncheres.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import fr.eni.projetEncheres.bll.UtilisateursBll;
import fr.eni.projetEncheres.bo.UtilisateursBo;
import fr.eni.projetEncheres.dal.UtilisateursDal;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/InscriptionJSP.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		
		UtilisateursBo premier = new UtilisateursBo();
		 premier.setPseudo(pseudo);
		 premier.setNom(nom);
		 premier.setPrenom(prenom);
		 premier.setEmail(email);
		 premier.setTelephone(telephone);
		 premier.setRue(rue);
		 premier.setCodePostal(codePostal);
		 premier.setVille(ville);
		 premier.setMotDePasse(motDePasse);
		 
		/* request.setAttribute("pseudo", pseudo);
		 request.setAttribute("nom", nom);
		 request.getRequestDispatcher("/WEB-INF/JSP/Test.jsp").forward(request, response); */
		
		 
		 
		
			UtilisateursDal.insert(premier);
			request.getRequestDispatcher("/WEB-INF/JSP/Gagne.jsp").forward(request, response);
		}
	
		 
	}
	
	


