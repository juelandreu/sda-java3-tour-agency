package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.domain.User;
import com.example.tour_agency_phoenix.services.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/signin")
public class SingInController {
    protected final UserService userService;

    public SingInController(final UserService service){
        this.userService = service;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView signIn(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signin");
        return modelAndView;
    }
    @PostMapping
    public String signIn(String email) {
        userService.findByEmail(email);
        return "userpage";
    }
}
