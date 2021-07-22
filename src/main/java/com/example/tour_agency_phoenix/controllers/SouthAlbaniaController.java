package com.example.tour_agency_phoenix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SouthAlbaniaController {
    @GetMapping("/southalbania")
    public String southAlbania(){return "southalbania";}
}
