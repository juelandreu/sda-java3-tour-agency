package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.services.tour.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToursByPlaneController {
    protected final TourService tourService;

    public ToursByPlaneController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/toursbyplane")
    public String toursByPlane(ModelMap map){
        map.addAttribute("tourbyplane",tourService.getToursByPlane());
        return "toursbyplane";
    }
}
