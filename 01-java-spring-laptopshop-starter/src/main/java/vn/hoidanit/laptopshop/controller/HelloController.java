package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.domain.User;

import org.springframework.ui.Model;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("data", "thuan hhhhhh");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getPageUser(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create1", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User thuan) {
        System.out.println("hello " + thuan.toString());
        return "hello";
    }
}
