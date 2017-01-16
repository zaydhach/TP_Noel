package noel.model;

public class Commandes {

	private long idCom;
	private long idProd;
	private long idPack;
	private long qtCom;

	public Commandes() {

	}

	public long getIdProd() {
		return idProd;
	}

	public void setIdProd(long idProd) {
		this.idProd = idProd;
	}

	Commandes(long idCom, long idProd, long idPack, long qtCom) {
		super();
		this.idCom = idCom;
		this.idProd = idProd;
		this.idPack = idPack;
		this.qtCom = qtCom;
	}

	public long getIdCom() {
		return idCom;
	}

	public void setIdCom(long idCom) {
		this.idCom = idCom;
	}

	public long getIdPack() {
		return idPack;
	}

	public void setIdPack(long idPack) {
		this.idPack = idPack;
	}

	public long getQtCom() {
		return qtCom;
	}

	public void setQtCom(long qtCom) {
		this.qtCom = qtCom;
	}

}
