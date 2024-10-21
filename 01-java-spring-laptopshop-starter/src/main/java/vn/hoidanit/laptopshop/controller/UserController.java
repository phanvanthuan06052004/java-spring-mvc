package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> users = this.userService.getAllUsers();
        System.out.println(users);
        model.addAttribute("data", "thuan hhhhhh");
        return "hello";
    }

    @RequestMapping("/admin/user/create")
    public String getPageUser(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping("/admin/user/{id}")
    public String getPageUserDetail(Model model, @PathVariable("id") Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getPageUpdateUser(Model model, @PathVariable("id") Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("newUser", user);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String handleUpdateUser(@ModelAttribute("newUser") User user) {
        User curUsers = this.userService.getUserById(user.getId());
        if (curUsers != null) {
            curUsers.setFullName(user.getFullName());
            curUsers.setPhone(user.getPhone());
            curUsers.setAddress(user.getAddress());

            this.userService.handleSaveUser(curUsers);

        }
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user")
    public String getPageUserTable(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("dataUser", users);
        return "admin/user/userTable";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User thuan) {
        System.out.println("hello " + thuan.toString());
        this.userService.handleSaveUser(thuan);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable("id") Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("dataUser", user);
        model.addAttribute("newUser", new User());
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete/{id}")
    public String postMethodName(@ModelAttribute("newUser") User user) {
        this.userService.removeUserById(user.getId());
        return "redirect:/admin/user";
    }

}
