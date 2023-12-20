package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entities.UserAccount;
import in.ashokit.service.UserAccountService;

@Controller
public class UserAccountController {

	@Autowired
	private UserAccountService service;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new UserAccount());
		return "index";
	}

	@PostMapping("/save-user")
	public String handleSubmitBtn(@ModelAttribute("user") UserAccount user, Model model) {
		System.out.println(user);
		String msg = service.saveOrUpdateUserAcc(user);
		model.addAttribute("msg", msg);
		return "index";
	}
	
	@GetMapping("/users")
	public String getUsers(Model model) {
		List<UserAccount> usersList = service.getAllUserAccounts();
		model.addAttribute("users", usersList);
		return "view-users";
	}
}
