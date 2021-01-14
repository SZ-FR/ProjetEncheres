package fr.eni.projetEncheres.bo;

public class RetraitsBo {
	
	
	private int noRetrait;
    private String rue;
    private String codePostal;
    private String ville;
    
    //constructeur
    public RetraitsBo (String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
    
    
    public RetraitsBo() {
    	super();	
    	}


	//getters and setters
	public int getNoRetrait() {
		return noRetrait;
	}
	public void setNoRetrait(int noRetrait) {
		this.noRetrait = noRetrait;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	//methode toString
	@Override
	public String toString() {
		return "Retraits [noRetrait=" + noRetrait + ", rue=" + rue + ", codePostal=" + codePostal + ", ville="
				+ ville + "]";
	}
}
