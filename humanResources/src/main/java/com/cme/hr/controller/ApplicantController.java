package com.cme.hr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cme.hr.exception.ApplicantNotFound;
import com.cme.hr.model.Applicant;
import com.cme.hr.service.ApplicantService;

@Controller
@RequestMapping(value="/applicant")

public class ApplicantController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Autowired
	private ApplicantService applicantService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newApplicantPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Applicant applicant = new Applicant();
		ModelAndView mav = new ModelAndView("applicant-new", "applicant", applicant);

		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createNewApplicant(@ModelAttribute @Valid Applicant applicant,
			BindingResult result,
			final RedirectAttributes redirectAttributes,
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
   
		if (result.hasErrors()){
		System.out.println("soy el error "+ result.toString());
			 ModelAndView mav = new ModelAndView("applicant-new","applicant",applicant);
			 return mav;
		}
		
		 applicantService.create(applicant);
		 Integer p= applicant.getIdPerson();
		 HttpSession session = request.getSession(true);
         session.setAttribute("id_Person", p);

		ModelAndView mav = new ModelAndView("redirect:/applicant/create.html");
	    
		
		return mav;		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView applicantListPage() {
		ModelAndView mav = new ModelAndView("applicant-list");
		List<Applicant> applicantList = applicantService.findByState("internal");
		mav.addObject("applicantList", applicantList);

		return mav;
	}

	
	@RequestMapping(value = "/edit/{idPerson}", method = RequestMethod.GET)
	public ModelAndView editApplicantPage(@PathVariable Integer idPerson,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("applicant-edit");

		Applicant applicant = applicantService.findById(idPerson);
		mav.addObject("applicant", applicant);
		return mav;
	}

	@RequestMapping(value = "/edit/{idPerson}", method = RequestMethod.POST)
	public ModelAndView editApplicant(@ModelAttribute @Valid Applicant applicant,
			BindingResult result, @PathVariable Integer idPerson,
			final RedirectAttributes redirectAttributes) throws ApplicantNotFound {

		if (result.hasErrors())
			return new ModelAndView("applicant-edit");

		ModelAndView mav = new ModelAndView("redirect:/applicant/list.html");
		String message = "Applicant was successfully updated.";

		applicantService.update(applicant);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{idPerson}", method = RequestMethod.GET)
	public ModelAndView deleteApplicant(@PathVariable Integer idPerson,
			final RedirectAttributes redirectAttributes) throws ApplicantNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		Applicant applicant = applicantService.delete(idPerson);
		String message = "The applicant " + applicant.getLastname() + ","
				+ applicant.getFirstname() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
}