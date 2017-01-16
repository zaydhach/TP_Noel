package noel.model;

public class Responsable {

	private long idResp;
	private String nom;
	private String email;
	private String password;

	public Responsable() {

	}

	public Responsable(long idResp, String nom, String email, String password) {
		super();
		this.idResp = idResp;
		this.nom = nom;
		this.email = email;
		this.password = password;
	}

	public long getIdResp() {
		return idResp;
	}

	public void setIdResp(long idResp) {
		this.idResp = idResp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
