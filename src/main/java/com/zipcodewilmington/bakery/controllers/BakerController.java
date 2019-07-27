package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.services.BakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BakerController {

    @Autowired
    private BakerService service;



    public BakerController(BakerService service) {
        this.service = service;
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Iterable<Baker>> index() {

        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Baker> show(@PathVariable Long id) {

        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/makeBaker", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateBaker/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Baker> update(@PathVariable Long id, @RequestBody Baker baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    @RequestMapping(value = "deleteBaker/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
