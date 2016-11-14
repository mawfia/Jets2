package controllers;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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
public class HangerController{
	
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
	public JetFileDAO initJets(){
		return jets;
	}
	
	@ModelAttribute("index")
	public CurrentIndex initIndex() {
		CurrentIndex ci = new CurrentIndex();
		return ci;
	}
	
	
	  @RequestMapping("refresh.do")
	  public ModelAndView refresh(@ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") JetFileDAO jets){
		  
		  ModelAndView mv = new ModelAndView().addObject("images", images=iDAO.getiDAO());
		    mv.addObject("keys", jets.keyList());
		  mv.addObject("fleet", jets);
		mv.setViewName("index.jsp");
		return mv;
	}

	  @RequestMapping("hmenu1.do")
	  public ModelAndView view1(@ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") JetFileDAO jets, @ModelAttribute("index") CurrentIndex index){

		  ModelAndView mv = new ModelAndView().addObject("images", images=iDAO.getiDAO());

		    mv.addObject("keys", jets.keyList());
		  mv.addObject("fleet", jets);
		  //mv.addObject("index", 0);
		mv.setViewName("hmenu1.jsp");
		return mv;
	}
	  
	  @RequestMapping("hmenu2.do")
	  public ModelAndView view2(@ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") JetFileDAO jets, @ModelAttribute("index") CurrentIndex index){

		ModelAndView mv = new ModelAndView().addObject("images", images=iDAO.getiDAO());

	    mv.addObject("keys", jets.keyList());
		mv.addObject("fleet", jets);
		mv.setViewName("hmenu2.jsp");
//	 mv.addObject("index", 0);

		return mv;
	}
	  

//---------------------------------------------------------------------------------------------	

	  @RequestMapping(path = "route.do", params = "data")
	  public ModelAndView Login(@RequestParam(name="data", required=false) String s, @ModelAttribute("hangerImages") ArrayList<String> images, 
			  						  @ModelAttribute("fleet") JetFileDAO jets, @ModelAttribute("index") CurrentIndex index) {
	    String allCaps = s.toUpperCase();
	    ModelAndView mv = new ModelAndView();
	    mv.addObject("keys", jets.keyList());
		mv.addObject("fleet", jets);
		mv.addObject("images", images=iDAO.getiDAO());
//		mv.addObject("index", 0);
	    System.out.println(s);

	    mv.setViewName("index.jsp");
	    mv.addObject("result", allCaps);
	    return mv;
	  }
	  
	  @RequestMapping(path = "hmenu1.do", params = {"browsers2", "operation"})
	  public ModelAndView Menu(@RequestParam(name="browsers2", required=false) String b2, 
			  						  @RequestParam(name="operation", required=false) Integer o, @ModelAttribute("index") CurrentIndex index,
			  						  @ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") JetFileDAO jets){
		  	ModelAndView mv = new ModelAndView();
		  	//System.out.println(index);
		    mv.addObject("keys", jets.keyList());
			mv.addObject("fleet", jets);
			mv.addObject("images", images=iDAO.getiDAO());
			
			//System.out.println(" op=" + o + " index=" + index + " curIndex=" + curIndex);
			
			if(o.equals(1)) mv.setViewName("hmenu3.jsp");
			else if(o.equals(2)) mv.setViewName("hmenu2.jsp");
			else if (o.equals(3)) mv.setViewName("hmenu4.jsp");
			else mv.setViewName("hmenu1.jsp");

		  return mv;
	  }
	  
	  @RequestMapping(path = "hmenu1.do", params = {"browsers4", "browsers2"}, method = RequestMethod.POST)
	  public ModelAndView Select(@RequestParam("browsers2") String b2, @RequestParam("browsers4") String b4,
			  					@ModelAttribute("hangerImages") ArrayList<String> images, @ModelAttribute("fleet") JetFileDAO jets, @ModelAttribute("index") CurrentIndex index){
		  ModelAndView mv = new ModelAndView();
		    mv.addObject("keys", jets.keyList());

			mv.addObject("fleet", jets);
			mv.addObject("images", images=iDAO.getiDAO());
			//index.selectIndex(null, jets.getIndex(b2), jets.size());
			//mv.addObject("index", jets.keyList()[index.toInteger()]);

			//System.out.println("browser4="+b4 + " browsers2-2=" + b2);

		    mv.setViewName("hmenu1.jsp");

		  return mv;
	  }
	  
	  @RequestMapping(path="hmenu2.do", params = "sort", method = RequestMethod.POST)
	  public ModelAndView Sort(@RequestParam("sort") String s, @ModelAttribute("hangerImages") ArrayList<String> images, 
			  						 @ModelAttribute("fleet") JetFileDAO jets, @ModelAttribute("index") CurrentIndex index){
		  ModelAndView mv = new ModelAndView();
		    mv.addObject("keys", jets.keyList());
			mv.addObject("fleet", jets);

		    mv.addObject("images", images=iDAO.getiDAO());

		  System.out.println(s);
		    mv.setViewName("hmenu1.jsp");
		  
		  return mv;
	  }
	  
	  @RequestMapping(path="hmenu2.do", params = {"search", "input"}, method = RequestMethod.POST)
	  public ModelAndView Search1(@RequestParam("search") String s, @RequestParam("input") String i, @ModelAttribute("hangerImages") ArrayList<String> images, 
			  							@ModelAttribute("fleet") JetFileDAO jets, @ModelAttribute("index") CurrentIndex index){
		  ModelAndView mv = new ModelAndView();
		    mv.addObject("keys", jets.keyList());
			mv.addObject("fleet", jets);

		    mv.addObject("images", images=iDAO.getiDAO());

		  System.out.println(s + " " + i);
		    mv.setViewName("hmenu1.jsp");
		  
		  return mv;
	  }
	  
	  @RequestMapping(path="hmenu2.do", params = "search", method = RequestMethod.POST)
	  public ModelAndView Search2(@RequestParam("search") String s, @ModelAttribute("hangerImages") ArrayList<String> images, 
			  							@ModelAttribute("fleet") JetFileDAO jets, @ModelAttribute("index") CurrentIndex index){
		  ModelAndView mv = new ModelAndView();
		    mv.addObject("keys", jets.keyList());
		    mv.addObject("images", images=iDAO.getiDAO());
			mv.addObject("fleet", jets);

		  System.out.println(s);
		    mv.setViewName("hmenu1.jsp");
		  
		  return mv;
	  }
	  
	  @RequestMapping(path="AddJet.do", method=RequestMethod.POST)
	  public ModelAndView AddJet(String tailNumber, String manufacturer, String model, Float speed, Float range, Float price, Float fuelCapacity,
			  						@ModelAttribute("hangerImages") ArrayList<String> images,
			  							  @ModelAttribute("fleet") JetFileDAO jets, @ModelAttribute("index") CurrentIndex index){
		  
		 
		  ModelAndView mv = new ModelAndView();
		  if(jets.add(new Jet(tailNumber, manufacturer, model, (speed == null? 0.0F: speed.floatValue()), 
				  			 (range == null ? 0.0F: range.floatValue()), (price == null? 0.0F: price.floatValue()),
				  			 (fuelCapacity == null? 0.0F: fuelCapacity.floatValue()))) == true){
			  mv.setViewName("hmenu1.jsp");
			  System.out.println("Successfully added jet to inventory");
		  }
		  else{ 	
			  		System.out.println("Error adding jet");
			  		mv.setViewName("hmenu2.jsp");
		  		}
		  mv.addObject("fleet", jets);
		  mv.addObject("images", images=iDAO.getiDAO());
		  mv.addObject("keys", jets.keyList());
		  
		  return mv;
	  }
	
	  @RequestMapping(path = "UpdateJet.do", params = {"browsers2"}, method = RequestMethod.POST)
	  public ModelAndView UpdateJet(@RequestParam("browsers2") String tailNumber, String manufacturer, String model, Float speed, Float range, Float price, Float fuelCapacity,
			  					@ModelAttribute("hangerImages") ArrayList<String> images, 
			  					@ModelAttribute("fleet") JetFileDAO jets, 
			  					@ModelAttribute("index") CurrentIndex index){
		  ModelAndView mv = new ModelAndView();
		  	
		if(jets.put(new Jet(tailNumber, manufacturer, model, (speed == null ? 0.0F : speed.floatValue()),
				(range == null ? 0.0F : range.floatValue()), (price == null ? 0.0F : price.floatValue()),
				(fuelCapacity == null ? 0.0F : fuelCapacity.floatValue())))){
			mv.setViewName("hmenu1.jsp");
			System.out.println("Successfully updated aircraft: " + tailNumber);
			jets.displayAll();
		}
		else {
			System.out.println("Error updating aircraft: " + tailNumber);
			mv.setViewName("hmenu3.jsp");
		}
			//System.out.println("manufacuterer=" + manufacturer + " tailNumber=" + tailNumber + " model=" + model + " speed=" + speed);

		  //index.selectIndex(null, jets.getIndex(b2), jets.size());
			//mv.addObject("index", jets.keyList()[index.toInteger()]);
		  mv.addObject("keys", jets.keyList());
		  mv.addObject("fleet", jets);
		  mv.addObject("images", images=iDAO.getiDAO());
		  mv.setViewName("hmenu1.jsp");

		  return mv;
	  }
	  
	  @RequestMapping(path = "RemoveJet.do", params = {"browsers2"}, method = RequestMethod.POST)
	  public ModelAndView RemoveJet(@RequestParam("browsers2") String tailNumber,
			  					@ModelAttribute("hangerImages") ArrayList<String> images, 
			  					@ModelAttribute("fleet") JetFileDAO jets, 
			  					@ModelAttribute("index") CurrentIndex index){
		  ModelAndView mv = new ModelAndView();
		  Jet jet = jets.remove(tailNumber);
		if(jet !=null){
			mv.setViewName("hmenu1.jsp");
			System.out.println("Successfully removed: " + jet);
			jets.displayAll();
		}
		else {
			System.out.println("The following aircraft was not found in the inventory: \n" + jet);
			mv.setViewName("hmenu3.jsp");
		}
			//System.out.println("manufacuterer=" + manufacturer + " tailNumber=" + tailNumber + " model=" + model + " speed=" + speed);

		  //index.selectIndex(null, jets.getIndex(b2), jets.size());
			//mv.addObject("index", jets.keyList()[index.toInteger()]);
		  mv.addObject("keys", jets.keyList());
		  mv.addObject("fleet", jets);
		  mv.addObject("images", images=iDAO.getiDAO());
		  mv.setViewName("hmenu1.jsp");

		  return mv;
	  }
	  
	  @RequestMapping(path="hmenu1.do", params = "navigation", method = RequestMethod.POST)
	  public ModelAndView PrevHomeNext(@RequestParam("navigation") Integer navigation, @ModelAttribute("hangerImages") ArrayList<String> images, 
			  							@ModelAttribute("fleet") JetFileDAO jets, @ModelAttribute("index") CurrentIndex index){
		  ModelAndView mv = new ModelAndView();
		    mv.addObject("keys", jets.keyList());
		    mv.addObject("images", images=iDAO.getiDAO());
			mv.addObject("fleet", jets);
			
//			index.selectIndex(navigation, null, jets.size());
//			mv.addObject("index", jets.keyList()[index.toInteger()]);
			
		    mv.setViewName("hmenu1.jsp");
		  
		  return mv;
	  }
	  
}

@Repository
class CurrentIndex {
	private Integer index;
	
	
	public CurrentIndex () {
		this.index = 0;
	}
	
	public void selectIndex(Integer selection1, Integer selection2, int size){
		if (selection1 != null) 
		{
			if(selection1 == 0) this.index = 0;
			else if (selection1 + this.index > size - 1) this.index = 0;
			else if (selection1 + this.index < 0) this.index = size - 1;
			else this.index = selection1 + this.index;
		} 
		else if (selection2 != null) if (selection2 < size - 1 && selection2 > 0) this.index = selection2;

	}
	
	public Integer toInteger(){
		
		return this.index;
	}

	public void increment() {
		this.index++;
	}

	
	public void decrement() {
		this.index--;
	}

	
	public void setIndex(Integer i) {
		this.index = i;
	}

	public Integer getIndex() {
		return this.index;
	}

	@Override
	public String toString() {
		return "CurrentIndex [index=" + index + "]";
	}
	
	

}