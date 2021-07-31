package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.services.tour.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ToursByFerryController  {

    protected final TourService tourService;

    public ToursByFerryController(TourService tourService) {
        this.tourService = tourService;
    }


    @GetMapping("/toursbycruise")
    public String toursByCruise(ModelMap map){
        map.addAttribute("tourbycruise",tourService.getToursByCruise());
        return "toursbyferry";
    }
}
