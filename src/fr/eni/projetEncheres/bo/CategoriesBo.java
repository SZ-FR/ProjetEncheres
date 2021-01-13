package fr.eni.projetEncheres.bo;

public class CategoriesBo { 
	
	private int no_categorie;
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
	public int getNo_categorie() {
		return no_categorie;
	}

	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
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
		return "Categories [no_categorie=" + no_categorie + ", libelle=" + libelle + "]";
	}

}
