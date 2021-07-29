package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.services.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class UserController {

    protected final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/user/{id}")
    public String user(ModelMap map, @PathVariable UUID id){
        map.addAttribute("user",userService.findById(id));
    return "userpage"; }
}
