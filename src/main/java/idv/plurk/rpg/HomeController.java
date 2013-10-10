package idv.plurk.rpg;

import idv.plurk.rpg.dao.DialogDAO;
import idv.plurk.rpg.dao.NpcDAO;
import idv.plurk.rpg.model.Emotion.Emote;
import idv.plurk.rpg.service.DialogService;
import idv.plurk.rpg.util.jPlurkUtil;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Inject
	private DialogService dialogService;
	@Inject
	private DialogDAO dialogDAO;
	@Inject
	private NpcDAO npcDAO;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		/*
		 * NpcDAO dao = new NpcDAOImpl(); String url = dao.getEmotion(1,
		 * Emote.HAPPY); System.out.println(url);
		 */
		/*
		 * Properties prop = System.getProperties(); String ConsumerKey =
		 * "4XkuRdvvCi3y"; String ConsumerSecret =
		 * "iJCEyFt7RLsjZiUZgBpVsBT3aAEp5owr"; String TokenKey = "nomBuJrXeeec";
		 * String TokenSecret = "2x3PXr09gL7sQl24rpCq0iaYJQv6y0lF"; //create
		 * oauth config PlurkOAuth auth = new PlurkOAuth(ConsumerKey,
		 * ConsumerSecret, TokenKey, TokenSecret);
		 */

		jPlurkUtil.checkNewFriend();
		// jPlurkUtil.response(1133357997, "my", Qualifier.ASKS);
		// jPlurkUtil.plurkPublic("test ด๚ธี", Qualifier.IS);

		System.out.println(npcDAO.getNpcEmotion(1, Emote.ANGRY).getUrl());
		return "home";
	}
}
