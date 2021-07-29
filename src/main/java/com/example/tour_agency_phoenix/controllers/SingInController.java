package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.services.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class SingInController {
    protected final UserService userService;

    public SingInController(final UserService service){
        this.userService = service;
    }

    @GetMapping("/signin")
    public String signIn(){
        return "signin";
    }
//    @GetMapping("/signin/{id}")
//    public String singIn(ModelMap map, @PathVariable UUID id){
//        map.addAttribute("user",userService.findById(id));
//        return "signin";}
}
