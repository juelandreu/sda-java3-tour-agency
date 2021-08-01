package com.example.tour_agency_phoenix.services.tour;

import com.example.tour_agency_phoenix.utils.TransportType;

import java.time.LocalDateTime;
import java.util.UUID;

public class SaveTourRequest {
    protected UUID id;
    protected String name;
    protected TransportType transport;
    protected double price;
    protected int duration;
    protected String image;
    protected boolean sale = false;
    protected double salePrice;
    protected LocalDateTime saleStartAt;
    protected LocalDateTime saleEndAt;
    protected Integer reservations;
    protected boolean featured = false;
    protected String featuredImage;
    protected String title;
    protected String subtitle;
    protected String description;
    protected String itinerary;
}
