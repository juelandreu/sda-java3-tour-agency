package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.domain.User;
import com.example.tour_agency_phoenix.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegistrationController {
//    private final RegistrationServer registrationServer;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("register");
        return modelAndView;
    }
//    @PostMapping
//    public String register(@RequestBody RegistrationRequest request) {
//        return registrationServer.register(request);
//    }
//

}
