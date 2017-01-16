package noel.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import noel.model.Commandes;
import noel.model.Packs;
import noel.model.Produits;
import noel.model.Responsable;

@Repository
@Profile(value = "manager")
public class Manager implements IManagerDAO {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	@Autowired
	IManagerDAO manager;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	final private RowMapper<Produits> produitMapper = new RowMapper<Produits>() {
		@Override
		public Produits mapRow(ResultSet arg0, int arg1) throws SQLException {
			Produits produit = new Produits();
			produit.setIdProd(arg0.getLong("ID_Prod"));
			produit.setNom(arg0.getString("Nom_Prod"));
			produit.setPrix(arg0.getLong("Prix_Prod"));
			produit.setQtProd(arg0.getLong("Qt_Prod"));
			return produit;
		}
	};

	final private RowMapper<Responsable> responsableMapper = new RowMapper<Responsable>() {
		@Override
		public Responsable mapRow(ResultSet arg0, int arg1) throws SQLException {
			Responsable responsable = new Responsable();
			responsable.setIdResp(arg0.getLong("ID_Resp"));
			responsable.setNom(arg0.getString("Nom_Resp"));
			responsable.setEmail(arg0.getString("Email_Resp"));
			responsable.setPassword(arg0.getString("Pwd_Resp"));
			return responsable;
		}
	};

	final private RowMapper<Commandes> commandeMapper = new RowMapper<Commandes>() {
		@Override
		public Commandes mapRow(ResultSet arg0, int arg1) throws SQLException {
			Commandes commande = new Commandes();
			commande.setIdCom(arg0.getLong("ID_Com"));
			commande.setIdProd(arg0.getLong("ID_Prod"));
			commande.setIdPack(arg0.getLong("ID_Pack"));
			commande.setQtCom(arg0.getLong("Qt_Com"));
			return commande;
		}
	};

	final private RowMapper<Packs> packMapper = new RowMapper<Packs>() {
		@Override
		public Packs mapRow(ResultSet arg0, int arg1) throws SQLException {
			Packs pack = new Packs();
			pack.setIdPack(arg0.getLong("ID_Pack"));
			pack.setNom(arg0.getString("Nom_Pack"));
			return pack;
		}
	};

	@Override
	public Responsable connexion(String email, String password) {
		String SQL = "SELECT * FROM responsable WHERE Email_Resp = ? AND Pwd_Resp = ? LIMIT 1";
		Responsable responsable = null;
		try {
			responsable = jdbcTemplate.queryForObject(SQL, new Object[] { email, password }, responsableMapper);

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return responsable;
	}
	
	public void saveProduit(Produits prod) throws SQLException {
		int res = 0;
		if (prod.getIdProd() > 0) {
			res = this.jdbcTemplate.update("UPDATE produits SET Nom_Prod='" + prod.getNom() + "', Prix_Prod='"
					+ prod.getPrix() + "', Qt_Prod='" + prod.getQtProd() + "' WHERE ID_Prod=" + prod.getIdProd() + "");
			if (res != 1)
				throw new SQLException("no Product with this ID !");
		} else
			this.jdbcTemplate.update(
					"INSERT INTO produits (Nom_Prod, Prix_Prod, Qt_Prod) "
							+ "values(?, ?, ?)",
					new Object[] { prod.getNom(), prod.getPrix(), prod.getQtProd() });
	}
	
	@Override
	public void deleteProduit(long id_Prod) throws SQLException {
		String sql = "DELETE FROM produits WHERE ID_Prod = ?";
		int a = jdbcTemplate.update(sql, id_Prod);
		if (a == 0)
			throw new SQLException("No product's whith this ID");
		
	}

	@Override
	public List<Produits> listProduits() throws SQLException {
		String sql = "SELECT * FROM produits";
		return this.jdbcTemplate.query(sql, produitMapper);
	}


	@Override
	public Produits findOneProduits(long id_Prod) throws SQLException {
		String sql = "SELECT * FROM produits WHERE id_prod = ?";
		Produits produit = jdbcTemplate.queryForObject(sql, new Object[] { id_Prod }, produitMapper);
		return produit;
	}


	@Override
	public void ajoutCommande(Commandes commande) throws SQLException {
		String sql = "INSERT INTO commandes (ID_Prod, Qt_Com) " + "values(?, ?)";
		this.jdbcTemplate.update(sql, new Object[] { commande.getIdProd(), commande.getQtCom() });

	}

	@Override
	public void updatePrice(Long idProd, double newQt, double newPrice) {
		int a = this.jdbcTemplate.update("UPDATE produits SET Prix_Prod='" + newPrice + "', Qt_Prod='"
				+ newQt + "' WHERE ID_Prod=" + idProd + "");
		if (a == 0)
			try {
				throw new SQLException("No products whith this ID");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
