package com.website.RRE.modules.garages;

// Controller layer

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rre/api/v1/garages")
public class GarageController {

    @Autowired
    private GarageService garageService;

    // Retrieve all garages
    @GetMapping("/allGarages")
    public List<Garage> getAllGarages() {
        return garageService.findAllGarages();
    }

    // Retrieve garages by name
    @GetMapping("/garageName/{garageName}")
    public List<Garage> getGaragesByName(@PathVariable String garageName) {
        return garageService.findByGarageName(garageName);
    }

    // Retrieve garages by speciality
    @GetMapping("/garageSpeciality/{garageSpeciality}")
    public List<Garage> getGaragesBySpeciality(@PathVariable String garageSpeciality) {
        return garageService.findByGarageSpeciality(garageSpeciality);
    }

    // Save a new garage
    @PostMapping("/add-garage")
    public Garage saveGarage(@RequestBody Garage garage) {
        return garageService.saveGarage(garage);
    }
}

