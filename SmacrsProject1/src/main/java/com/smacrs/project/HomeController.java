package com.smacrs.project;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smacrs.db.UserModel;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("user", new UserModel());
        return "home";
    } 
	

   @RequestMapping(value="/signup", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute UserModel user, Model model) {
        model.addAttribute("user", user);
  //      Transaction tx = null;

		SessionFactory sessionFactory=new Configuration() . configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	
        return "signup";
    }
	
	//*************************************************************************************************************
	//@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String SignUp() {
		/*logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );*/
		//ModelAndView model=new ModelAndView("home");
		
	//	return "home";
	//}
	
/*	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody String SignUpData1(@ModelAttribute("name") String Name,
			@ModelAttribute("address") String address) {
		
		//ModelAndView model=new ModelAndView("signup");
		//model.addObject(user);
		//return model;
		//System.out.println("hema post 1 : " + Name + " " + address);
		return "signup";
	}*/
	
	/*@RequestMapping(value = "/", method = RequestMethod.POST)

	public String  SignUpData(@RequestParam("Name") String Name,@RequestParam("Email") String Email,
			@RequestParam("Address") String Adress,@RequestParam("Age") int Age,@RequestParam("Salary") int Salary) {
		UserModel user = new UserModel();
		user.setUserName(Name);
		user.setUserEmail(Email);
		user.setUserAdress(Adress);
		user.setUserAge(Age);
		user.setUserSalary(Salary);
		
		//here is the transaction !
		Transaction tx = null;

		SessionFactory sessionFactory=new Configuration() . configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		
		
		//ModelAndView model=new ModelAndView("signup");
		//model.addObject(user);
		return "signup";
		
	}*/
}
