package com.cme.hr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




import utils.UtilsContainer;




import com.cme.hr.model.LevelSkills;
import com.cme.hr.model.Person;
import com.cme.hr.model.PersonSkills;
import com.cme.hr.model.Skills;
import com.cme.hr.model.TypeSkills;
import com.cme.hr.service.LevelSkillsService;
import com.cme.hr.service.PersonService;
import com.cme.hr.service.SkillsService;
import com.cme.hr.service.TypeSkillsService;
import com.cme.hr.service.PersonSkillsService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/skills")
public class SkillsController {

	@Autowired
	private SkillsService skillsService;

	@Autowired
	private TypeSkillsService typeSkillsService;

	@Autowired
	private LevelSkillsService levelSkills;

	@Autowired
	private PersonSkillsService PersonSkillsService;
	@Autowired
	private PersonService personService;
	
	
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newSkillsPage(HttpServletRequest request,
		   HttpServletResponse response) throws ServletException, IOException {
		
		List<TypeSkills> typeSkills=typeSkillsService.findAll();
		List<LevelSkills> levelSkill=levelSkills.findAll();
		String personID = request.getParameter("personID");
		Person person=personService.findById(Integer.parseInt(personID));
		ModelAndView mav = new ModelAndView("skills-new");
		Integer id = Integer.valueOf(personID);
		mav.addObject("person", person);
		mav.addObject("skillsList", createTable(id));
		mav.addObject("levelSelect",levelSkill);
		mav.addObject("typeSelect",typeSkills);
		Skills skill = new Skills();
		mav.addObject("personID", personID);
		mav.addObject("skill", skill);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createSkillsPerson(HttpServletRequest request,
			   HttpServletResponse response) throws ServletException, IOException{

		String personID = request.getParameter("personID");
		String skillSelect = request.getParameter("skillSelect");
		String levelSkill = request.getParameter("levelSkill");
		
		PersonSkills personSkill=new PersonSkills();
		personSkill.setIdPerson(Integer.parseInt(personID));
		personSkill.setIdSkill(Integer.parseInt(skillSelect));
		personSkill.setIdLevel(Integer.parseInt(levelSkill));
		 PersonSkillsService.create(personSkill);
		 ModelAndView mav = new ModelAndView("redirect:/skills/create.html?personID="+personID);  
		return mav;

	}


	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView deleteSkills(HttpServletRequest request,
			   HttpServletResponse response) throws ServletException, IOException{
		String personID = request.getParameter("personID");
		String idSkill = request.getParameter("idSkill");
		ModelAndView mav = new ModelAndView("redirect:/skills/create.html?personID="+personID);		
		PersonSkillsService.delete(Integer.parseInt(idSkill));
		
		return mav;
	}
	
	
	List<Skills> skillListSelect = new ArrayList<Skills>();
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    List<Skills> SkillsAll=skillsService.findAll();
		
		skillListSelect.clear();
		String json = null;
		try{
			System.out.println("estoy acaaaaaaaa\n\n");
		if (!request.getParameter("typeSkill").isEmpty()) {
	    String typeSkill = request.getParameter("typeSkill");
		Iterator<Skills>it=SkillsAll.iterator();
	
		
		int aux;
          while (it.hasNext()) {
        	  aux=0;
			Skills skill = (Skills) it.next();
			if(skill.getIdTypeSkill().equals(Integer.parseInt(typeSkill))){
				Iterator<UtilsContainer>it2=array.iterator();
				while (it2.hasNext()) {
					UtilsContainer tabla = (UtilsContainer) it2.next();
					System.out.println(tabla.getStringSkill());
					if(tabla.getStringSkill().equals(skill.getNameSkill())){
					System.out.println("esto es aux "+aux);	
				    aux=1;
					}
				
				}
				if(aux==0){
					
					skillListSelect.add(skill);}
				aux=0;
				
			}
		}
		
		}
	}catch(NumberFormatException e){
		skillListSelect.clear();
	}finally{
			json = new Gson().toJson(skillListSelect);
			response.setContentType("application/json");
		
		response.getWriter().write(json);
	}
	}
	
	
	
	List<PersonSkills> PersonSkillsList;
	ArrayList<UtilsContainer>  array = new ArrayList<UtilsContainer>(); 
	private ArrayList<UtilsContainer> createTable(int id) {
		PersonSkillsList = PersonSkillsService.findByidPerson(id);
		array.clear();
		Iterator<PersonSkills> it1 = PersonSkillsList.iterator();
		while (it1.hasNext()) {
			PersonSkills personSkill = it1.next();
			Skills skills = skillsService.findById(personSkill.getIdSkill());
			TypeSkills type = typeSkillsService.findById(skills.getIdTypeSkill());
			LevelSkills level = levelSkills.findById(personSkill.getIdLevel());
			
			UtilsContainer tabla = new UtilsContainer(type.getNameType(),skills.getNameSkill(), level.getNameLevel() ,personSkill.getIdPersonSkill());
			array.add(tabla);
		}
		return array;
	}

}
