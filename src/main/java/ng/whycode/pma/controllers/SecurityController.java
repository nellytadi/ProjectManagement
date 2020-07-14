package ng.whycode.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ng.whycode.pma.dao.IUserAccountRepository;
import ng.whycode.pma.entites.UserAccount;

@Controller
public class SecurityController {

	@Autowired 
	BCryptPasswordEncoder bCryptEncoder;
	@Autowired
	IUserAccountRepository userRepo;
	
	@GetMapping("/register")
	public String register(Model model) {
		UserAccount account = new UserAccount();
		model.addAttribute("userAccount",account);
		
		return "security/register";
	}
	
	@PostMapping("/register/store")
	public String storeUser(Model model, UserAccount user) {
		
		user.setPassword(bCryptEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return "redirect:/";
	}
}
