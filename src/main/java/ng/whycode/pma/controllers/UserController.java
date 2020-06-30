package ng.whycode.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ng.whycode.pma.dao.IUserRepository;
import ng.whycode.pma.entites.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserRepository iUser;
	
	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "auth/register";
		
	}
	
	@PostMapping("/register/store")
	public String storeRegistration(User user,BindingResult result) {
		
		iUser.save(user);
		
		return "redirect:/";
		
	}
}
