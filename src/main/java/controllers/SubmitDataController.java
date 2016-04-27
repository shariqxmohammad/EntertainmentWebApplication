package controllers;

import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import hibernate.Books;

@Controller
public class SubmitDataController {
	private ModelAndView modelandview;

	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView submitDeleteChanges(
            @RequestParam("surname") String books) { //instead of receiving surname, will need to find a way to receive all checked items and will need to make. Will need to call it something else, then make adjustment in books.jsp
		System.out.println("TESTING FORM");
		System.out.println(books);
		return modelandview;
	}
    
	//WHEN YOU CLICK DELETE ITEMS BUTTON JSP PAGE (BOOKS.JSP), U WILL GET TAKEN TO THIS METHOD. 
	//Be able to write logic that determine which boxes are checked and delete them. 
	
	//LOGIC: ArrayList of checked list probably, or some sort of list of all the items, the pass list to controller. 
	
		//CONTROLLER CLASS WHICH IS THIS-----WILL CALL HIBERNATE DAO AND DELETE THEM. 
	
	//WILL HAVE TO MAKE CHANGES IN THIS AND BOOKS.JSP
	
	//Currently pulling arrayList and printing it in ForEach in JSP. Now we are doing opposite. 
	
	//^ This request mapping slash means that when we get this url, we want to map it to this method (below). It will only map it to the method below.
	//The method is saying we want to return ModelAndView. In spring dispatcher servlet, make sure to make modelandview value INDEX.
	//The MODELandVIEW value is set to index. 
	
	public ModelAndView titlePage() {			
		return modelandview;
	}
	
	public ModelAndView getModelandview() {
		return modelandview;
	}

	public void setModelandview(ModelAndView modelandview) {
		this.modelandview = modelandview;
	}	
	
}
