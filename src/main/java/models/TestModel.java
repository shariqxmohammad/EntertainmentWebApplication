package models;

import org.springframework.web.servlet.ModelAndView;

import dao.HibernateDataDAO;
import hibernate.Books;

public class TestModel {
	HibernateDataDAO data;
	
	public ModelAndView test(ModelAndView modelandview) {
		System.out.println("Testing hibernate");
		//This Books is just a test, in the real implementation it will be added by the user.
		
		modelandview = data.getBooks(modelandview);
		
		return modelandview;
	}

	public HibernateDataDAO getData() {
		return data;
	}

	public void setData(HibernateDataDAO data) {
		this.data = data;
	}	
}