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
public class CopController {
	
	@Autowired
	private CopRepository copRepository;
	
	@Autowired
	private MissionRepository missionRepository;
	
	@GetMapping("/cops")
	public String cops(Model model) {
		List<Cop> cops = copRepository.findAll();
		model.addAttribute("cops", cops);
		return "cop";
	}
	
	@GetMapping("/cops/form")
	public String copForm(@ModelAttribute("cop") Cop cop, Model model) {
	    List<Mission> missions = missionRepository.findAll();
	    model.addAttribute("missionList", missions);
	    return "cop_form";
	}
	
	@PostMapping("/cops/new")
	public String copNew(@Valid @ModelAttribute("cop") Cop cop, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "cop_form";
		}
		
	    List<Mission> selectedMission = cop.getMissions();
	    List<Mission> missionList = missionRepository.findAllById(selectedMission.stream().map(Mission::getId).collect(Collectors.toList()));
	    cop.setMissions(missionList);
	    copRepository.save(cop);
	    return "redirect:/cops";
	}
	
	@GetMapping("/cops/update/{id}")
	public String copUpdate(@PathVariable("id") Integer id, Model model){
		
		Optional<Cop> optCop = copRepository.findById(id);
		if(!optCop.isPresent()){
			//Gerar erro
		}
		
		Cop cop = optCop.get();
		
		model.addAttribute("cop", cop);
		
		return"cop_form";
	}
	
	@GetMapping("/cops/delete/{id}")
	public String copDelete(@PathVariable("id") Integer id) {
		
	    Optional<Cop> optCop = copRepository.findById(id);
	    if (!optCop.isPresent()) {
	        // Gerar erro
	    }
	    
	    Cop cop = optCop.get();
        List<Mission> missions = cop.getMissions();
        for (Mission mission : missions) {
            mission.getCops().remove(cop);
            missionRepository.save(mission);
        }
        copRepository.delete(cop);
	    
	    return "redirect:/cops";
	}

}
