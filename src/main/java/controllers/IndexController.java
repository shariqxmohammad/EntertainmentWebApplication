package controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	private ModelAndView modelandview;
	
	@RequestMapping("/")
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