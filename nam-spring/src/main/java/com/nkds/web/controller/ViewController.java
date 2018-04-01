package com.nkds.web.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nkds.web.model.User;
import com.nkds.web.service.UserService;

@Controller
@RequestMapping(value = "/view")
public class ViewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ViewController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@ModelAttribute User user, Locale locale, Model model) {
		User resUser = userService.getUserInfo(user.getStfno());
		
		model.addAttribute("user", resUser);
		
		return "index";
	}
	
}
