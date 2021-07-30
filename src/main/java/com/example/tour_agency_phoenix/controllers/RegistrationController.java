package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
@Controller
public class RegistrationController {
//    private final RegistrationServer registrationServer;

    @GetMapping("/registration")
    public String showRegistrationForm() {
        UserDto userDto = new UserDto();
        return "register";
    }

//    @PostMapping
//    public String register(@RequestBody RegistrationRequest request) {
//        return registrationServer.register(request);
//    }
//

}
