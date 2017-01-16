package noel.web;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import noel.business.IManagerDAO;
import noel.business.PriceCalculator;
import noel.business.StrategyPriceCalculator;
import noel.model.Commandes;
import noel.model.Produits;
import noel.model.Responsable;

@Controller()
@RequestMapping("cadeaux")
public class NoelController {

	@Autowired
	IManagerDAO manager;

	@ModelAttribute("oProduits")
	List<Produits> produits() throws SQLException {
		return manager.listProduits();
	}

	@RequestMapping(value = "/listeProduits", method = RequestMethod.GET)
	public String listeProduits() {
		return "noel";
	}

	@RequestMapping(value = "/commande", method = RequestMethod.GET)
	public String commande(@RequestParam(value = "idProd") Long idProd, Model model) throws SQLException {
		if (idProd == null) {
			return "error";
		}
		Produits produit = manager.findOneProduits(idProd);
		model.addAttribute("produit", produit);
		return "commande";
	}

	@RequestMapping(value = "/commande", method = RequestMethod.POST)
	public String saveQtcommander(@RequestParam(value = "qtCom") Long qtCom,
			@RequestParam(value = "idProd") Long idProd, Model model) throws SQLException {
		Commandes cmd = new Commandes();

		cmd.setIdProd(idProd);
		cmd.setQtCom(qtCom);
		Produits produit = manager.findOneProduits(idProd);
		manager.ajoutCommande(cmd);
		StrategyPriceCalculator priceCal = (StrategyPriceCalculator) new PriceCalculator();
		double newPrice = priceCal.calculatePrice(produit.getPrix(), produit.getQtProd(), qtCom);
		double newQt = produit.getQtProd() - qtCom;
		manager.updatePrice(idProd, newQt, newPrice);

		return "redirect:/actions/cadeaux/listeProduits";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editProduct(@ModelAttribute Produits p) {
		return "editProduit";
	}

	@ModelAttribute
	public Produits newProd(@RequestParam(value = "idProd", required = false) Long id_Prod) throws SQLException {
		if (id_Prod != null) {
			return manager.findOneProduits(id_Prod);
		}
		Produits p = new Produits();

		p.setNom("");
		p.setPrix(0);
		p.setQtProd(0);
		return p;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String savePerson(@ModelAttribute @Valid Produits p, BindingResult result) throws SQLException {
		if (result.hasErrors()) {
			return "editProduit";
		}
		manager.saveProduit(p);
		return "redirect:/actions/cadeaux/listeProduits";
	}

	@RequestMapping(value = "/supp", method = RequestMethod.GET)
	public String suppProduct(@RequestParam(value = "idProd") Long idProd, BindingResult result) throws SQLException {
		manager.deleteProduit(idProd);
		return "redirect:/actions/cadeaux/listeProduits";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String email, @RequestParam String password, HttpSession session,
			Model model) {

		Responsable responsable = manager.connexion(email, password);
		if (responsable == null) {
			model.addAttribute("loginError", "Error Login. Please try again");
			return "login";
		}
		session.setAttribute("auth", responsable);
		return "redirect:/actions/cadeaux/listeProduits";
	}
}