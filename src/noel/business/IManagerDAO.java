package noel.business;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import noel.model.Commandes;
import noel.model.Produits;
import noel.model.Responsable;

public interface IManagerDAO {

	public void setDataSource(DataSource ds);

	/*************************** Responsables ***************************/

	Responsable connexion(String email, String password);

	/*************************** Produits ***************************/

	List<Produits> listProduits() throws SQLException;
	Produits findOneProduits(long id_Prod)throws SQLException;
	public void saveProduit(Produits prod) throws SQLException;
	void deleteProduit(long id_Prod) throws SQLException;
	
	/************************** Commandes *************************/
	void ajoutCommande(Commandes commande) throws SQLException;

	public void updatePrice(Long idProd, double newQt, double newPrice);
}
