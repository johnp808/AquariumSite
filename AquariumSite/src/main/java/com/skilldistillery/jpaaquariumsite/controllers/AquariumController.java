package com.skilldistillery.jpaaquariumsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.jpaaquariumsite.data.AquariumDAO;
import com.skilldistillery.jpaaquariumsite.entities.Aquarium;

@Controller
public class AquariumController {

//	@Autowired
//	private AquariumDAO aquariumDao;
//	
//	@RequestMapping(path = {"getAquarium.do"})
//	public String getAquarium(@RequestParam Integer aquariumId, Model model) {
//		Aquarium aquarium = aquariumDao.findById(aquariumId);
//		model.addAttribute("aquarium",aquarium);
//		return "aquarium/display";
//	}
//	
//	@RequestMapping(path="createAquariumSlot.do", method = RequestMethod.POST)
//	public String createAquariumForm(Model model, Aquarium aquarium) {
//		return "aquarium/addAquarium";
//	}
//	
//	@RequestMapping(path="createAquarium.do", method = RequestMethod.POST)
//	public String createAquarium(Model model, Aquarium aquarium) {
//		model.addAttribute("aquarium", aquariumDao.createAquarium(aquarium));
//		return "aquarium/addedAquarium";
//	}
//	
//	@RequestMapping(path="deleteAquarium.do")
//	public String deleteAquarium(Integer aquariumId, Model model) {
//		model.addAttribute("aquarium", aquariumDao.deleteAquarium(aquariumId));
//		return "aquarium/deletedAquarium";
//	}
//	
//	@RequestMapping(path = "updateAquariumSlot.do", method = RequestMethod.POST)
//	public String updateAquariumSlot(@RequestParam Integer aquariumId, Model model) {
//		Aquarium updatedAquarium = aquariumDao.findById(aquariumId);
//		model.addAttribute("aquarium", updatedAquarium);
//		return "aquarium/updateAquarium";
//	}
//
//	@RequestMapping(path = "updateAquarium.do", method = RequestMethod.POST)
//	public String updateAquarium(Integer aquariumId, Model model, Aquarium aquarium) {
//		model.addAttribute("aquarium", aquariumDao.updateAquarium(aquariumId, aquarium));
//		return "aquarium/updateAquariumSuccess";
//	}
}
