package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.RoleDao;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    private UserService userService;

    @Autowired
    private RoleDao roleDao;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String printUsers(ModelMap model) {
        List<User> list = userService.listUsers();
        model.addAttribute("list", list);
        return "users";
    }

    @GetMapping("/admin/add")
    public String addUser(Map<String, Object> model) {
        List<Role> list = new LinkedList<>();
        list.add(roleDao.getRoleUser());
        list.add(roleDao.getRoleAdmin());
        User user = new User();
        user.setRoles(list);
        model.put("user", user);
        return "add";
    }

    @PostMapping("/admin/add")
    public String addUser(@ModelAttribute("user") User user) {
        List<Role> list = user.getRoles();
        for (Role role : list) {
            if (role.getName().equals("ROLE_USER")){
                role.setId(1L);
            } else if (role.getName().equals("ROLE_ADMIN")) {
                role.setId(2L);
            }
        }
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/delete")
    public String deleteUser(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/edit")
    public String editUser(@RequestParam long id, Model model) {
        User user = userService.getUserById(id);
        List<Role> list = new LinkedList<>();
        list.add(roleDao.getRoleUser());
        list.add(roleDao.getRoleAdmin());
        user.setRoles(list);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/admin/edit")
    public String editUser(@ModelAttribute("user") User user) {
        List<Role> list = user.getRoles();
        for (Role role : list) {
            if (role.getName().equals("ROLE_USER")){
                role.setId(1L);
            } else if (role.getName().equals("ROLE_ADMIN")) {
                role.setId(2L);
            }
        }
        userService.editUser(user);
        return "redirect:/admin";
    }
}
