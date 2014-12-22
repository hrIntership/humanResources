package com.cme.hr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cme.hr.exception.PersonNotFound;
import com.cme.hr.model.City;
import com.cme.hr.model.Country;
import com.cme.hr.model.Person;
import com.cme.hr.model.Province;
import com.cme.hr.service.CityService;
import com.cme.hr.service.CountryService;
import com.cme.hr.service.PersonService;
import com.cme.hr.service.ProvinceService;
import com.cme.hr.validation.PersonValidator;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private ProvinceService provinceService;

	@Autowired
	private CityService cityService;

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonValidator personValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(personValidator);

	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newPersonPage() {
		Person person = new Person();
		ModelAndView mav = new ModelAndView("person-new", "person", person);
		initSelect(mav);

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewPerson(@ModelAttribute Person person,
			BindingResult result, final RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		if (result.hasErrors()) {
			System.out.println("soy el error " + result.toString());
			ModelAndView mav = new ModelAndView("person-new", "person", person);
			initSelect(mav);
			return mav;
		}

		personService.create(person);
		Integer p = person.getIdPerson();
		HttpSession session = request.getSession(true);
		session.setAttribute("id_Person", p);

		ModelAndView mav = new ModelAndView("redirect:/background/create.html");

		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView personListPage() {
		ModelAndView mav = new ModelAndView("person-list");
		List<Person> personList = personService.findAll();
		mav.addObject("personList", personList);

		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editPersonPage(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("person-edit");
		String idPerson = request.getParameter("personID");
		Person person = personService.findById(Integer.valueOf(idPerson));
		initSelect(mav);
		mav.addObject("person", person);
		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editPerson(@ModelAttribute Person person,
			BindingResult result, 
			final RedirectAttributes redirectAttributes) throws PersonNotFound {
	

		ModelAndView mav = new ModelAndView("redirect:/person/list.html");
		String message = "Person was successfully updated.";

		personService.update(person);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{idPerson}", method = RequestMethod.GET)
	public ModelAndView deletePerson(@PathVariable Integer idPerson,
			final RedirectAttributes redirectAttributes) throws PersonNotFound {

		ModelAndView mav = new ModelAndView("redirect:/person/list.html");

		Person person = personService.delete(idPerson);
		
		return mav;
	}
//-------------------- select ----------------------------------------------
	List<Province> provinceSelect = new ArrayList<Province>();

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String json = null;
		try {
			if (!request.getParameter("country").isEmpty()) {
				String idCountry = request.getParameter("country");

				provinceSelect = provinceService.findByIdCountry(Integer
						.valueOf(idCountry));
				
				for (Iterator<Province> iterator = provinceSelect.iterator(); iterator
						.hasNext();) {
					Province city = (Province) iterator.next();
                   	System.out.println(city.getIdCountry());				
				}
			}
		} catch (NumberFormatException e) {
			provinceSelect = null;
		} finally {
			
			json = new Gson().toJson(provinceSelect);
			response.setContentType("application/json");

			response.getWriter().write(json);
		}
	}

	List<City> citySelect = new ArrayList<City>();

	@RequestMapping(value = "/selectProvince", method = RequestMethod.GET)
	public void doGetCity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String json = null;
		try {
			if (!request.getParameter("province").isEmpty()) {
				String idProvince = request.getParameter("province");

				citySelect = cityService.findByIdProvince(Integer.valueOf(idProvince));
			}
		} catch (NumberFormatException e) {
			citySelect = null;
		} finally {
			
			json = new Gson().toJson(citySelect);
			response.setContentType("application/json");

			response.getWriter().write(json);
		}
	}
	// -----------------------------------------------------------------------------------
	List<Country> countryList = new ArrayList<Country>();

	
	ArrayList<String> idTypeList = new ArrayList<String>();
	ArrayList<String> stateList = new ArrayList<String>();
	ArrayList<String> msList = new ArrayList<String>();

	private void initSelect(ModelAndView mav) {
		if (idTypeList.isEmpty()) {
			idTypeList.add("DU");
			idTypeList.add("Passport");
			idTypeList.add("Driver's License Number");
		}
		if (countryList.isEmpty()) {
			countryList = countryService.findAll();
		}

	
		if (stateList.isEmpty()) {
			stateList.add("external");
			stateList.add("internal");
		}
		if (msList.isEmpty()) {
			msList.add("single");
			msList.add("married");
			msList.add("widowed");
			msList.add("separated");
			msList.add("divorced");
			msList.add("other");
		}

		mav.addObject("idTypeList", idTypeList);
		mav.addObject("countryList", countryList);
		mav.addObject("msList", msList);
		mav.addObject("stateList", stateList);

	}

}