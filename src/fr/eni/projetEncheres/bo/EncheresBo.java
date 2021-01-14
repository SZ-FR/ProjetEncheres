package fr.eni.projetEncheres.bo;

import java.sql.Date;
import java.time.LocalDate;

public class EncheresBo {
	
	private int noEnchere;
	private Date dateEnchere;
	private int montantEnchere;
	private int noArticle;
	private int noUtilisateur;

	//constructeur
	public EncheresBo(int noEnchere, Date dateEnchere, int montantEnchere, int noArticle, int noUtilisateur) {
	super();
	this.noEnchere = noEnchere;
	this.dateEnchere = dateEnchere;
	this.montantEnchere = montantEnchere;
	this.noArticle = noArticle;
	this.noUtilisateur = noUtilisateur;
	}
	
	public EncheresBo() {
		super();
		}
	
	
	//getters and setters
	public int getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}

	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date date) {
		this.dateEnchere = date;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	//methode toString
	@Override
	public String toString() {
		return "Encheres [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere="
				+ montantEnchere + ", noArticle=" + noArticle + ", noUtilisateur=" + noUtilisateur + "]";
	}
}
