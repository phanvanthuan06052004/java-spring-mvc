package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class DashboardController {

    @GetMapping("/admin")
    public String getMethodName(Model model) {
        return "admin/dashboard/show";
    }

}
