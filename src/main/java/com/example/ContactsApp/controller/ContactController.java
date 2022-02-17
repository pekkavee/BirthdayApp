package com.example.ContactsApp.controller;

import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.ContactsApp.domain.Contact;
import com.example.ContactsApp.service.ContactService;
 

	@Controller
	public class ContactController {
	@Autowired
	    private ContactService service;
	 
	    @GetMapping("/")
	    public String viewHomePage(Model model) {
	        List<Contact> listcontact = service.listAll();
	        model.addAttribute("listcontact", listcontact);
	        System.out.print("Get / ");
	        return "index";
	    }

	 
	    @GetMapping("/new")
	    public String add(Model model) {
	        model.addAttribute("contact", new Contact());
	        return "new";
	    }
	 
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveStudent(@ModelAttribute("contact") Contact std) {
	        service.save(std);
	        return "redirect:/";
	    }
	 
	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("new");
	        Contact std = service.get(id);
	        mav.addObject("contact", std);
	        return mav;
	        
	    }
	    @RequestMapping("/delete/{id}")
	    public String deletestudent(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/";
	    }
	    @InitBinder
	    protected void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(
	                dateFormat, false));
	    }
	}