package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import models.TestModel;

@Controller
public class TestController {
	ModelAndView modelandview;
	TestModel testModel;
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public ModelAndView controller() {		
		testModel.test(modelandview);
		return modelandview;
	}

	public ModelAndView getModelandview() {
		return modelandview;
	}

	public void setModelandview(ModelAndView modelandview) {
		this.modelandview = modelandview;
	}

	public TestModel getTestModel() {
		return testModel;
	}


	public void setTestModel(TestModel testModel) {
		this.testModel = testModel;
	}
}
