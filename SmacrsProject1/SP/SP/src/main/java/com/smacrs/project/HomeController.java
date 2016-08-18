package com.smacrs.project;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smacrs.db.UserModel;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("user", new UserModel());
		return "home";
	}


	@ResponseBody @RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String greetingSubmit(@RequestBody  String Name
			,@RequestBody String Email,
	  @RequestBody  String Adress,@RequestBody  int
	  Age,@RequestBody  int Salary) {
		UserModel user=new UserModel();
		user.setUserEmail(Email);
		user.setUserAdress(Adress);
		user.setUserAge(Age);
		user.setUserName(Name);
		user.setUserSalary(Salary);
		//model.addAttribute("user", user);
		System.out.println(user.getUserAdress());
		System.out.println(user.getUserAge());
		System.out.println(user.getUserID());
		System.out.println(user.getUserName());
		System.out.println(user.getUserSalary());
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

		return "signup";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String signin(Model model) {
		model.addAttribute("user", new UserModel());
		return "signin";
	}

	// *************************************************************************************************************
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String SignUp() {
	/*
	 * logger.info("Welcome home! The client locale is {}.", locale);
	 * 
	 * Date date = new Date(); DateFormat dateFormat =
	 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * 
	 * String formattedDate = dateFormat.format(date);
	 * 
	 * model.addAttribute("serverTime", formattedDate );
	 */
	// ModelAndView model=new ModelAndView("home");

	// return "home";
	// }

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.POST)
	 * public @ResponseBody String SignUpData1(@ModelAttribute("name") String
	 * Name,
	 * 
	 * @ModelAttribute("address") String address) {
	 * 
	 * //ModelAndView model=new ModelAndView("signup"); //model.addObject(user);
	 * //return model; //System.out.println("hema post 1 : " + Name + " " +
	 * address); return "signup"; }
	 */

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.POST)
	 * 
	 * public String SignUpData(@RequestParam("Name") String
	 * Name,@RequestParam("Email") String Email,
	 * 
	 * @RequestParam("Address") String Adress,@RequestParam("Age") int
	 * Age,@RequestParam("Salary") int Salary) { UserModel user = new
	 * UserModel(); user.setUserName(Name); user.setUserEmail(Email);
	 * user.setUserAdress(Adress); user.setUserAge(Age);
	 * user.setUserSalary(Salary);
	 * 
	 * //here is the transaction ! Transaction tx = null;
	 * 
	 * SessionFactory sessionFactory=new Configuration() .
	 * configure().buildSessionFactory(); Session session =
	 * sessionFactory.openSession(); tx=session.beginTransaction();
	 * session.save(user); tx.commit();
	 * 
	 * 
	 * //ModelAndView model=new ModelAndView("signup"); //model.addObject(user);
	 * return "signup";
	 * 
	 * }
	 */
}
