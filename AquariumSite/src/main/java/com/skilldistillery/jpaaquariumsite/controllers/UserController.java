package com.skilldistillery.jpaaquariumsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.jpaaquariumsite.data.AquariumDAO;
import com.skilldistillery.jpaaquariumsite.data.UserDAO;
import com.skilldistillery.jpaaquariumsite.entities.Aquarium;
import com.skilldistillery.jpaaquariumsite.entities.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private AquariumDAO aquariumDao;
	
	@RequestMapping(path = {"/", "home.do"})
	public String home(Model model) {
		model.addAttribute("users", userDao.findAll());
		return "home";
	}
	
	@RequestMapping(path = {"getUser.do"})
	public String getUser(@RequestParam Integer userId, Model model) {
		User user = userDao.findById(userId);
		Aquarium aquarium = aquariumDao.findById(userId);
		model.addAttribute("user",user);
		model.addAttribute("aquarium", aquarium);
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
	public String deleteUser(Integer userId, Integer aquariumId, Model model) {
		model.addAttribute("user", userDao.deleteUser(userId));
		model.addAttribute("aquarium", aquariumDao.deleteAquarium(aquariumId));
		return "user/deletedUser";
	}
	
	@RequestMapping(path = "updateUserSlot.do", method = RequestMethod.POST)
	public String updateUserSlot(@RequestParam Integer userId, Model model) {
		User updatedUser = userDao.findById(userId);
		model.addAttribute("user", updatedUser);
		return "user/updateUser";
	}

	@RequestMapping(path = "updateUser.do", method = RequestMethod.POST)
	public String updateUser(Integer userId, Model model, User user) {
		model.addAttribute("user", userDao.updateUser(userId, user));
		return "user/updateUserSuccess";
	}
	
	@RequestMapping(path = {"getAquarium.do"})
	public String getAquarium(@RequestParam Integer aquariumId, Model model) {
		Aquarium aquarium = aquariumDao.findById(aquariumId);
		model.addAttribute("aquarium",aquarium);
		return "aquarium/display";
	}
	
	@RequestMapping(path="createAquariumSlot.do", method = RequestMethod.POST)
	public String createAquariumForm(Model model, Aquarium aquarium) {
		return "aquarium/addAquarium";
	}
	
	@RequestMapping(path="createAquarium.do", method = RequestMethod.POST)
	public String createAquarium(Model model, Aquarium aquarium) {
		model.addAttribute("aquarium", aquariumDao.createAquarium(aquarium));
		return "aquarium/addedAquarium";
	}
	
	@RequestMapping(path="deleteAquarium.do")
	public String deleteAquarium(Integer aquariumId, Model model) {
		model.addAttribute("aquarium", aquariumDao.deleteAquarium(aquariumId));
		return "aquarium/deletedAquarium";
	}
	
	@RequestMapping(path = "updateAquariumSlot.do", method = RequestMethod.POST)
	public String updateAquariumSlot(@RequestParam Integer aquariumId, Model model) {
		Aquarium updatedAquarium = aquariumDao.findById(aquariumId);
		model.addAttribute("aquarium", updatedAquarium);
		return "aquarium/updateAquarium";
	}

	@RequestMapping(path = "updateAquarium.do", method = RequestMethod.POST)
	public String updateAquarium(Integer aquariumId, Model model, Aquarium aquarium) {
		model.addAttribute("aquarium", aquariumDao.updateAquarium(aquariumId, aquarium));
		return "aquarium/updateAquariumSuccess";
	}
	
}
