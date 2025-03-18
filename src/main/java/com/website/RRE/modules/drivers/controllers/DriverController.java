package com.website.RRE.modules.drivers.controllers;

import com.website.RRE.modules.drivers.dtos.DriverDto;
import com.website.RRE.modules.drivers.entities.Driver;
import com.website.RRE.modules.drivers.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rre/api/v1/drivers")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    // Retrieve all drivers
    @GetMapping
    public List<DriverDto> getAllDrivers() {
        return driverService.findAllDrivers();
    }

    // Retrieve drivers by name
    @GetMapping("/driver-name/{driverName}")
    public List<DriverDto> getDriversByName(@PathVariable String driverName) {
        return driverService.findByDriverName(driverName);
    }

    // Retrieve drivers by car make
    @GetMapping("/driver-car-make/{carMake}")
    public List<DriverDto> getDriversByCarMake(@PathVariable String carMake) {
        return driverService.findByDriverCarMake(carMake);
    }

    // Save a new driver
    @PostMapping("/add-driver")
    public DriverDto saveDriver(@RequestBody Driver driver) {
        return driverService.saveDriver(driver);
    }

    // Save multiple drivers
    @PostMapping("/add-drivers")
    public ResponseEntity<List<DriverDto>> addMultipleDrivers(@RequestBody List<Driver> drivers) {
        List<DriverDto> savedDrivers = driverService.saveAll(drivers);
        return ResponseEntity.ok(savedDrivers);
    }


    // Delete driver by ID
    @DeleteMapping("/delete-driver-id/{driverID}")
    public void deleteGarageByID(@PathVariable Long driverID){
        driverService.deleteByDriverID(driverID);

    }

    // Delete driver by Name
    @DeleteMapping("/delete-driver-name/{driverName}")
    public void deleteGarageByName(@PathVariable String driverName){
        driverService.deleteByDriverName(driverName);

    }

    // Update driver fields partially
    // PATCH endpoint to update driver by ID
    @PatchMapping("/{driverID}")
    public ResponseEntity<DriverDto> updateDriver(
            @PathVariable Long driverID,
            @RequestBody DriverDto driverDto) {

        DriverDto updatedDriver = driverService.updateDriver(driverID, driverDto);
        return ResponseEntity.ok(updatedDriver);
    }



}

