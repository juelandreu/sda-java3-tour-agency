package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.domain.Tour;
import com.example.tour_agency_phoenix.services.book.BookService;
import com.example.tour_agency_phoenix.services.tour.TourService;
import com.example.tour_agency_phoenix.services.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {
    protected final TourService tourService;
    protected final BookService bookService;
    protected final UserService userService;

    public HomeController(final TourService tourService, final BookService bookService, final UserService userService) {
        this.tourService = tourService;
        this.bookService = bookService;
        this.userService = userService;
    }


    @GetMapping("/home")
    public String home(ModelMap map, String keyword){

//        tourService.createTour();

        map.addAttribute("featuredTours", tourService.getFeaturedTours());
        map.addAttribute("featuredBookings", bookService.getFeaturedBookings());
        map.addAttribute("featuredUsers", userService.getFeaturedUsers());
        return "index";
    }
}
