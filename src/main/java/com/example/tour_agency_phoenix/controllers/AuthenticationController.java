package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuthenticationController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView signIn(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signin");
        return modelAndView;
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
         User user = new User();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

}
