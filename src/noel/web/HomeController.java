package noel.web;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HomeController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.info("Returning home view");
		String now = (new Date()).toString();
		String msg = "HELLO AMINE";
		ModelAndView mav = new ModelAndView("home");
		// Permet d'ajouter au modelAndView des donnees que l'on souhaite
		// envoyer à la vue
		mav.addObject("now", now);
		mav.addObject("info", msg);
		return mav;

	}
}
