package models;

import org.springframework.web.servlet.ModelAndView;

import dao.HibernateDataDAO;

public class EntertainmentModel {
	HibernateDataDAO data;
	
	public ModelAndView movies(ModelAndView modelandview) {
		modelandview = data.getMovies(modelandview);
		return modelandview;
	}
	
	public ModelAndView music(ModelAndView modelandview){
		modelandview = data.getMusic(modelandview);
		return modelandview;
				
	}
	
	public ModelAndView books(ModelAndView modelandview) {
		modelandview = data.getBooks(modelandview);
		return modelandview;
	}
	
	public ModelAndView contacts(ModelAndView modelandview){
		modelandview = data.getContacts(modelandview);
		return modelandview;
				
	}

	public HibernateDataDAO getData() {
		return data;
	}

	public void setData(HibernateDataDAO data) {
		this.data = data;
	}	
}