package noel.model;

public class Packs {

	private long idPack;
	private String nom;

	public Packs() {
	}

	public Packs(long idPack, String nom) {
		super();
		this.idPack = idPack;
		this.nom = nom;
	}

	public long getIdPack() {
		return idPack;
	}

	public void setIdPack(long idPack) {
		this.idPack = idPack;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
