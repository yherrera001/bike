package com.globomatics.bike.controllers;

import com.globomatics.bike.models.Bike;
import com.globomatics.bike.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes") //this will be the URl the app will respond to when it requests made
public class BikeController {

     @Autowired //injecting the bike repo
     private BikeRepository bikeRepository;


    @GetMapping //when an issue is requested in the base path(api/v1/bikes), it will be forwarded to the list method if it is using the HTTP get verb.
    public List<Bike> list() {
        return bikeRepository.findAll(); //this is a free method that spring JPA created for us
    }
    @PostMapping //responds to a post to the post URL
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Bike bike) {
        bikeRepository.save(bike);
    }

    @GetMapping("/{id}")
    public Bike get(@PathVariable("id") long id){
        return bikeRepository.getOne(id);
    }

}
