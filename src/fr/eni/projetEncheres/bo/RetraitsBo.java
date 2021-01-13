package fr.eni.projetEncheres.bo;

public class RetraitsBo {
	
	
	private int no_retrait;
    private String rue;
    private String code_postal;
    private String ville;
    
    //constructeur
    public RetraitsBo(String rue, String code_postal, String ville) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}
    
    
    public RetraitsBo() {
    	super();	
    	}


	//getters and setters
	public int getNo_retrait() {
		return no_retrait;
	}
	public void setNo_retrait(int no_retrait) {
		this.no_retrait = no_retrait;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
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
		return "Retraits [no_retrait=" + no_retrait + ", rue=" + rue + ", code_postal=" + code_postal + ", ville="
				+ ville + "]";
	}
}
