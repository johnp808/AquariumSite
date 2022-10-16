package com.skilldistillery.jpaaquariumsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.jpaaquariumsite.data.UserDAO;
import com.skilldistillery.jpaaquariumsite.entities.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(path = {"/", "home.do"})
	public String home(Model model) {
		model.addAttribute("users", userDao.findAll());
		return "home";
	}
	
	@RequestMapping(path = {"getUser.do"})
	public String getUser(@RequestParam Integer userId, Model model) {
		User user = userDao.findById(userId);
		model.addAttribute("user",user);
		return "user/display";
	}
	
	@RequestMapping(path="createUserSlot.do", method = RequestMethod.POST)
	public String createUserForm(Model model, User user) {
		return "user/addUser";
	}
	
	@RequestMapping(path="createUser.do", method = RequestMethod.POST)
	public String createUser(Model model, User user) {
		model.addAttribute("user", userDao.createUser(user));
		return "user/addedUser";
	}
	
	@RequestMapping(path="deleteUser.do")
	public String deleteUser(Integer userId, Model model) {
		model.addAttribute("user", userDao.deleteUser(userId));
		return "user/deletedUser";
	}
	
	@RequestMapping(path = "updateUserSlot.do", method = RequestMethod.POST)
	public String updateResellerSlot(@RequestParam Integer userId, Model model) {
		User updatedUser = userDao.findById(userId);
		model.addAttribute("user", updatedUser);
		return "user/updateUser";
	}

	@RequestMapping(path = "updateUser.do", method = RequestMethod.POST)
	public String updateReseller(Integer userId, Model model, User user) {
		model.addAttribute("user", userDao.updateUser(userId, user));
		return "user/updateUserSuccess";
	}
	
}
