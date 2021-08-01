package com.example.tour_agency_phoenix.controllers;

import com.example.tour_agency_phoenix.domain.Tour;
import com.example.tour_agency_phoenix.domain.User;
import com.example.tour_agency_phoenix.services.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RestController
@RequestMapping("/api/user")
public class UserController {

    protected final UserService userService;

    public UserController(final UserService userService){
        this.userService = userService;
    }
    @GetMapping("{id}")
    public ResponseEntity<User> get(@PathVariable UUID id){
        var  item = this.userService.findById(id);
        return item.isPresent() ? ResponseEntity.ok(item.get())
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public UUID save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }




//    @GetMapping("/user/{id}")
//    public String user(ModelMap map, @PathVariable UUID id){
//        map.addAttribute("user",userService.findById(id));
//    return "userpage"; }
}
