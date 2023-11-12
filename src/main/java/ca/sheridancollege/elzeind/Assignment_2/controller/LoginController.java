package ca.sheridancollege.elzeind.Assignment_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
        @GetMapping("/")
        public String index() {
        return "index";
        }
        @GetMapping("/secure")
        public String secureIndex() {
            return "/secure/index";
        }
        @GetMapping("/permission-denied")
        public String permissionDenied() {
            return "/error/permission-denied";
        }
}

