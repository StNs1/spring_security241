package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.dao.RoleDao;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.LinkedList;
import java.util.List;

@Controller
public class RegistrationController {

    private UserService userService;

    private RoleDao roleDao;

    public RegistrationController(UserService userService, RoleDao roleDao) {
        this.userService = userService;
        this.roleDao = roleDao;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") User userForm, Model model) {

        List<Role> list = new LinkedList<>();
        list.add(roleDao.getRoleUser());
        userForm.setRoles(list);

        if (!userService.addUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/login";
    }
}
