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

import com.cme.hr.exception.StaffNotFound;
import com.cme.hr.model.Education;
import com.cme.hr.model.Person;
import com.cme.hr.model.Staff;
import com.cme.hr.service.PersonService;
import com.cme.hr.service.StaffService;
import com.cme.hr.validation.StaffValidator;

@Controller
@RequestMapping(value="/staff")

public class StaffController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Autowired
	private StaffService staffService;
	
	@Autowired
	private PersonService personService;

	@Autowired
	private StaffValidator staffValidator;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newStaffPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Staff staff = new Staff();
		ModelAndView mav = new ModelAndView("staff-new", "staff", staff);

		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createNewStaff(@ModelAttribute @Valid Staff staff,
			BindingResult result,
			final RedirectAttributes redirectAttributes,
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
   
		if (result.hasErrors()){
		System.out.println("soy el error "+ result.toString());
			 ModelAndView mav = new ModelAndView("staff-new","staff",staff);
			 return mav;
		}

		
		 staffService.create(staff);
		 Integer p= staff.getIdPerson();
		 System.out.println("\n\n\nesta es la session"+p);
		 HttpSession session = request.getSession(true);
         session.setAttribute("id_Person", p);

		ModelAndView mav = new ModelAndView("redirect:/staff/create.html");
	    
		
		return mav;		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView staffListPage() {
		ModelAndView mav = new ModelAndView("staff-list");
		String state = "internal";
		List<Person> staffList = personService.findByState(state);
		mav.addObject("staffList", staffList);

		return mav;
	}
	
	@RequestMapping(value = "/listId/{idPerson}", method = RequestMethod.GET)
	public ModelAndView staffIdListPage(HttpServletRequest request,
			   HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("staff-listId");
		String idPerson = request.getParameter("personID");
		System.out.println("\n\n\n mirameeeeeeeeee"+idPerson);
		Staff staff = staffService.findById(Integer.parseInt(idPerson));
	
		mav.addObject("staff", staff);
		return mav;
	}

	
	@RequestMapping(value = "/edit/{idPerson}", method = RequestMethod.GET)
	public ModelAndView editStaffPage(@PathVariable Integer idPerson,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("staff-edit");

		Staff staff = staffService.findById(idPerson);
		mav.addObject("staff", staff);
		return mav;
	}

	@RequestMapping(value = "/edit/{idPerson}", method = RequestMethod.POST)
	public ModelAndView editStaff(@ModelAttribute @Valid Staff staff,
			BindingResult result, @PathVariable Integer idPerson,
			final RedirectAttributes redirectAttributes) throws StaffNotFound {

		if (result.hasErrors())
			return new ModelAndView("staff-edit");

		ModelAndView mav = new ModelAndView("redirect:/staff/list.html");
		String message = "Staff was successfully updated.";

		staffService.update(staff);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{idPerson}", method = RequestMethod.GET)
	public ModelAndView deleteStaff(@PathVariable Integer idPerson,
			final RedirectAttributes redirectAttributes) throws StaffNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		Staff staff = staffService.delete(idPerson);
		String message = "The staff " + staff.getLastname() + ","
				+ staff.getFirstname() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
}