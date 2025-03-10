package com.website.RRE.modules.garages.controllers;

// Controller layer

import com.website.RRE.modules.garages.entities.Garage;
import com.website.RRE.modules.garages.services.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rre/api/v1/garages")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class GarageController {

    @Autowired
    private GarageService garageService;

    // Retrieve all garages
    @GetMapping
    public List<Garage> getAllGarages() {
        return garageService.findAllGarages();
    }

    // Retrieve garages by name
    @GetMapping("/garage-name/{garageName}")
    public List<Garage> getGaragesByName(@PathVariable String garageName) {
        return garageService.findByGarageName(garageName);
    }

    // Retrieve garages by speciality
    @GetMapping("/garages-speciality/{garageSpeciality}")
    public List<Garage> getGaragesBySpeciality(@PathVariable String garageSpeciality) {
        return garageService.findByGarageSpeciality(garageSpeciality);
    }

    // Save a new garage
    @PostMapping("/add-garage")
    public Garage saveGarage(@RequestBody Garage garage) {
        return garageService.saveGarage(garage);
    }

    // Save multiple garages
    @PostMapping("/add-garages")
    public ResponseEntity<List<Garage>> addMultipleGarages(@RequestBody List<Garage> garages) {
        List<Garage> savedGarages = garageService.saveAll(garages);
        return ResponseEntity.ok(savedGarages);
    }

    // Delete garage by ID
    @DeleteMapping("/delete-garage-id/{garageID}")
    public void deleteGarageByID(@PathVariable Long garageID){
        garageService.deleteByGarageID(garageID);

    }

    // Delete garage by Name
    @DeleteMapping("/delete-garage-name/{garageName}")
    public void deleteGarageByName(@PathVariable String garageName){
        garageService.deleteByGarageName(garageName);

    }
}

