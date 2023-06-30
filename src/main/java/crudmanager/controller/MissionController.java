package crudmanager.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import crudmanager.dao.MissionRepository;
import crudmanager.dao.CopRepository;
import crudmanager.model.Mission;
import crudmanager.model.Cop;

@Controller
public class MissionController {
	
	@Autowired
	private MissionRepository missionRepository;
	
	@Autowired
	private CopRepository copRepository;
	
	@GetMapping("/missions")
	public String missions(Model model) {
		List<Mission> missions = missionRepository.findAll();
		model.addAttribute("missions", missions);
		return "mission";
	}
	
	@GetMapping("/missions/form")
	public String missionForm(@ModelAttribute("mission") Mission mission, Model model) {
	    List<Cop> copList = copRepository.findAll();
	    model.addAttribute("copList", copList);
	    return "mission_form";
	}

	
	@PostMapping("/missions/new")
	public String missionNew(@Valid @ModelAttribute("mission") Mission mission, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "mission_form";
		}
		
	    List<Cop> selectedCop = mission.getCops();
	    List<Cop> copList = copRepository.findAllById(selectedCop.stream().map(Cop::getId).collect(Collectors.toList()));
	    mission.setCops(copList);
	    missionRepository.save(mission);
	    return "redirect:/missions";
	}


	
	@GetMapping("/missions/update/{id}")
	public String missionUpdate(@PathVariable("id") Integer id, Model model) {
		
		Optional<Mission> optMission = missionRepository.findById(id);
		if(!optMission.isPresent()){
			//Gerar erro
		}
		
		Mission mission = optMission.get();
		
		model.addAttribute("mission", mission);
		
		return"mission_form";
	}
	
	@GetMapping("/missions/delete/{id}")
	public String missionDelete(@PathVariable("id") Integer id) {
		
		Optional<Mission> optMission = missionRepository.findById(id);
		if(!optMission.isPresent()){
			//Gerar erro
		}
		
		Mission mission = optMission.get();
		
		mission.setCops(null);
		
		missionRepository.delete(mission);
		
		return"redirect:/missions";
	}
}
