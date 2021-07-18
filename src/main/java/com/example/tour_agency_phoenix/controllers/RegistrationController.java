package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class RegistrationController {
    @GetMapping("/registration")
    public String showRegistrationForm() {
        UserDto userDto = new UserDto();
        return "register";
    }
}
