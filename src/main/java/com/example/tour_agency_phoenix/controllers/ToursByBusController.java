package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.services.tour.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToursByBusController {

    protected final TourService tourService;

    public ToursByBusController(TourService tourService) {
        this.tourService = tourService;
    }


    @GetMapping("/toursbybus")
    public String toursByBus(ModelMap map){
        map.addAttribute("tourbybus",tourService.getToursByBus());
        return "toursbybus";
    }
}
