package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.services.tour.TourService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class PackageController {
    protected final TourService tourService;

    public PackageController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/packages")
    public String packages(ModelMap map, String keyword){
        if (Strings.isNotBlank(keyword))
            map.addAttribute("packages",tourService.findByKeyword(keyword));
        else
            map.addAttribute("packages",tourService.getFeaturedTours());

        return "packages";
    }

    @GetMapping("/packages/{id}")
    public String packages(ModelMap map, @PathVariable UUID id){
        map.addAttribute("package",tourService.findById(id));
        return "package";
    }






}
