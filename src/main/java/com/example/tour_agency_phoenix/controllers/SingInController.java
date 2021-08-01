package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.services.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

//    @GetMapping("/signin/{id}")
//    public String singIn(ModelMap map, @PathVariable UUID id){
//        map.addAttribute("user",userService.findById(id));
//        return "signin";}
}
