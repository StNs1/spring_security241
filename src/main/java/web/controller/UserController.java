package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("user")
	public String printWelcome(@SessionAttribute("user") User user, ModelMap model) {
		model.addAttribute("user", user);
		return "hello";
	}

    @GetMapping("login")
    public String loginPage() {
        return "login";
    }

}