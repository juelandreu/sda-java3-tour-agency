package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.services.tour.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    protected final TourService tourService;

    public HomeController(final TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/home")
    public String home(ModelMap map){
        map.addAttribute("featuredTours", tourService.getFeaturedTours());
        return "index";
    }
}
