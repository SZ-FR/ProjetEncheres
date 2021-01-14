package fr.eni.projetEncheres.bo;

public class CategoriesBo { 
	
	private int noCategorie;
	private String libelle;


	//constucteur
	public CategoriesBo() {
		super();
	}

	public CategoriesBo( String libelle) {
		super();
		this.libelle = libelle;
	}

	//Getters and setters
	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	//methode toString
	@Override
	public String toString() {
		return "Categories [noCategorie=" + noCategorie + ", libelle=" + libelle + "]";
	}

}
