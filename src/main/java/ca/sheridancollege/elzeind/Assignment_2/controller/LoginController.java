package ca.sheridancollege.elzeind.Assignment_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
        @GetMapping("/")
        public String login() {
                return "login"; // Ensure this page is accessible without login
        }

        @GetMapping("/secure")
        public String secureIndex() {
                return "/secure/index"; // Secured page, requires authentication
        }

        @GetMapping("/permission-denied")
        public String permissionDenied() {
                return "/error/permission-denied"; // Accessible without authentication
        }
}

