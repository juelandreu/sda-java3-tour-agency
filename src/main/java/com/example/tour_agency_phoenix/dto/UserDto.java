package com.example.tour_agency_phoenix.dto;

import com.sun.istack.NotNull;

public class UserDto {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;
    private String matchingPassword;

    @NotNull
    private String email;
}
