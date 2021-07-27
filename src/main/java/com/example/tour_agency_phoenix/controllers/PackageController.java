package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.services.tour.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PackageController {
    protected final TourService tourService;

    public PackageController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/packages")
    public String packages(ModelMap map, String keyword){

        if (keyword !=null)
            map.addAttribute("ta_tour.name",tourService.findByKeyword(keyword));

        return "packages";
    }
}
