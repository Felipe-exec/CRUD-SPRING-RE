package crudmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String index(Model model) {

		return "index";
	}
	
	@GetMapping("/index/loading")
	public String loadingSimulator() {
	    return "loadingSimulator";
	}
}