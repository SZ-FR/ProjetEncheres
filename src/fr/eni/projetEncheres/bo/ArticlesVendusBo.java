package fr.eni.projetEncheres.bo;


import java.time.LocalDate;
import java.sql.Date;


public class ArticlesVendusBo {
	
	private int noArticle;                 
	private String nomArticle;                   
	private String description;                  
	private Date dateDebutEncheres;          
	private Date dateFinEncheres;             
	private int  prixInitial;                
	private int prixVente;                   
	private int noVendeur;               
	private int noCategorie;  


//Constructeur
	public ArticlesVendusBo( String nomArticle, String description, Date dateDebutEncheres,
		Date dateFinEncheres, int prixInitial, int prixVente, int noVendeur, int noCategorie) 
	{
	super();
	
	this.nomArticle = nomArticle;
	this.description = description;
	this.dateDebutEncheres = dateDebutEncheres;
	this.dateFinEncheres = dateFinEncheres;
	this.prixInitial = prixInitial;
	this.prixVente = prixVente;
	this.noVendeur = noVendeur;
	this.noCategorie = noCategorie;
	}

	public ArticlesVendusBo() {
	super();
	}


	public String getNomArticle() {
		return nomArticle;
	}
	
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	
	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	
	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}
	
	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	
	public int getPrixInitial() {
		return prixInitial;
	}
	
	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}
	
	public int getPrixVente() {
		return prixVente;
	}
	
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	
	public int getNoUtilisateur() {
		return noVendeur;
	}
	
	public void setNoUtilisateur(int noUtilisateur) {
		this.noVendeur = noUtilisateur;
	}
	
	public int getNoCategorie() {
		return noCategorie;
	}
	
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}


	//methode toString
	@Override
	public String toString() {
		return "ArticlesVendusBo [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description="
				+ description + ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres="
				+ dateFinEncheres + ", prixInitial=" + prixInitial + ", prixVente=" + prixVente
				+ ", noUtilisateur=" + noVendeur + ", noCategorie=" + noCategorie 
				+ "]";
}

}
