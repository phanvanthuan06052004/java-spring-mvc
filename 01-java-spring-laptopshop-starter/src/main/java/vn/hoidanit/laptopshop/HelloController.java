package vn.hoidanit.laptopshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "Hello World from Spring thuan!";
    }

    @GetMapping("/user")
    public String userPage() {
        return "this page only for user!";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "This page only for admin!";
    }
}
