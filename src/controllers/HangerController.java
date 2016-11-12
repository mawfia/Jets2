package controllers;


import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import data.ImageFileDAO;
import data.Jet;
import data.PilotFileDAO;
import data.JetFileDAO;


@Controller
@SessionAttributes({"hangerImages", "pilots", "fleet"})
public class HangerController {
	@Autowired
	private ImageFileDAO iDAO;
	
	@Autowired
	private PilotFileDAO pilots;
	
	@Autowired
	private JetFileDAO jets;
	
	
	@ModelAttribute("hangerImages")
	public ArrayList<String> initImage(){
		return iDAO.getiDAO();
	}
	
	@ModelAttribute("fleet")
	public ArrayList<Jet> initJets(){
		return jets.getFleet();
	}
	
	  @RequestMapping("refresh.do")
	  public ModelAndView refresh(@ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") ArrayList<Jet> jets){
		  
		  ModelAndView mv = new ModelAndView().addObject("images", images=iDAO.getiDAO());
		  mv.addObject("fleet", jets);
		mv.setViewName("index.jsp");
		return mv;
	}

	  @RequestMapping("hmenu1.do")
	  public ModelAndView view1(@ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") ArrayList<Jet> jets){

		  ModelAndView mv = new ModelAndView().addObject("images", images=iDAO.getiDAO());
		 mv.addObject("fleet", jets);
		mv.setViewName("hmenu1.jsp");
		return mv;
	}
	  
	  @RequestMapping("hmenu2.do")
	  public ModelAndView view2(@ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") ArrayList<Jet> jets){

		ModelAndView mv = new ModelAndView().addObject("images", images=iDAO.getiDAO());
		mv.addObject("fleet", jets);
		mv.setViewName("hmenu2.jsp");
		return mv;
	}
	  
//---------------------------------------------------------------------------------------------	

	  @RequestMapping(path = "route.do", params = "data")
	  public ModelAndView processData(@RequestParam(name="data", required=false) String s, @ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") ArrayList<Jet> jets) {
	    String allCaps = s.toUpperCase();
	    ModelAndView mv = new ModelAndView();
		mv.addObject("fleet", jets);
		mv.addObject("images", images=iDAO.getiDAO());

	    System.out.println(s);

	    mv.setViewName("index.jsp");
	    mv.addObject("result", allCaps);
	    return mv;
	  }
	  
	  @RequestMapping(path = "hmenu1.do", params = {"browsers2", "operation"})
	  public ModelAndView HangerMenu1(@RequestParam(name="browsers2", required=false) String b2, 
			  						  @RequestParam(name="operation", required=false) String o, @ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") ArrayList<Jet> jets){
		  ModelAndView mv = new ModelAndView();
		  System.out.println(b2 + " " + o);
			mv.addObject("fleet", jets);
			mv.addObject("images", images=iDAO.getiDAO());


		  if(o.equals("Update")) mv.setViewName("hmenu3.jsp");
		  else if(o.equals("Add")) mv.setViewName("hmenu2.jsp");
		  else mv.setViewName("hmenu1.jsp");

		  return mv;
	  }
	  
	  @RequestMapping(path = "hmenu1.do", params = {"browsers4", "browsers2"}, method = RequestMethod.POST)
	  public ModelAndView HangerMenu2(@RequestParam("browsers4") String b4, @RequestParam("browsers2") String b2, @ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") ArrayList<Jet> jets){
		  ModelAndView mv = new ModelAndView();
			mv.addObject("fleet", jets);
			mv.addObject("images", images=iDAO.getiDAO());

		  System.out.println(b4 + " " + b2);

		    mv.setViewName("hmenu1.jsp");

		  return mv;
	  }
	  
	  @RequestMapping(path="hmenu2.do", params = "sort", method = RequestMethod.POST)
	  public ModelAndView HangerSort(@RequestParam("sort") String s, @ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") ArrayList<Jet> jets){
		  ModelAndView mv = new ModelAndView();
		    //iDAO.toArrayList(images);
			mv.addObject("fleet", jets);

		    mv.addObject("images", images=iDAO.getiDAO());

		  System.out.println(s);
		    mv.setViewName("hmenu1.jsp");
		  
		  return mv;
	  }
	  
	  @RequestMapping(path="hmenu2.do", params = {"search", "input"}, method = RequestMethod.POST)
	  public ModelAndView HangerSearch1(@RequestParam("search") String s, @RequestParam("input") String i, @ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") ArrayList<Jet> jets){
		  ModelAndView mv = new ModelAndView();
		    //iDAO.toArrayList(images);
			mv.addObject("fleet", jets);

		    mv.addObject("images", images=iDAO.getiDAO());

		  System.out.println(s + " " + i);
		    mv.setViewName("hmenu1.jsp");
		  
		  return mv;
	  }
	  
	  @RequestMapping(path="hmenu2.do", params = "search", method = RequestMethod.POST)
	  public ModelAndView HangerSearch2(@RequestParam("search") String s, @ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") ArrayList<Jet> jets){
		  ModelAndView mv = new ModelAndView();
		    //iDAO.toArrayList(images);
		    mv.addObject("images", images=iDAO.getiDAO());
			mv.addObject("fleet", jets);

		  System.out.println(s);
		    mv.setViewName("hmenu1.jsp");
		  
		  return mv;
	  }
	  
	  @RequestMapping(path="AddJet.do", method=RequestMethod.POST)
	  public ModelAndView AddJet(Jet jet, @ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") ArrayList<Jet> jets){
		  ModelAndView mv = new ModelAndView();
		  if(jets.add(jet)) mv.setViewName("hmenu1.jsp");
		  else{ 	
			  		mv.setViewName("AddJet.do");
		  			mv.addObject("jet", jet);
		  		}
		  mv.addObject("fleet", jets);
		    mv.addObject("images", images=iDAO.getiDAO());

		  for(Jet j: jets) j.display();
		  //mv.addObject("images", images=iDAO.getiDAO());
		  //for(int i = 0; i < images.size(); i++) System.out.println(images.get(i));
		  
		  return mv;
	  }
	
}