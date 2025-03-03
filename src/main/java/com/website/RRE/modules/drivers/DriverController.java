package com.website.RRE.modules.drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rre/api/v1/drivers")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    // Retrieve all drivers
    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.findAllDrivers();
    }

    // Retrieve drivers by name
    @GetMapping("/name/{driverName}")
    public List<Driver> getDriversByName(@PathVariable String driverName) {
        return driverService.findByDriverName(driverName);
    }

    // Retrieve drivers by car make
    @GetMapping("/car-make/{carMake}")
    public List<Driver> getDriversByCarMake(@PathVariable String carMake) {
        return driverService.findByDriverCarMake(carMake);
    }

    // Save a new driver
    @PostMapping("/add-driver")
    public Driver saveDriver(@RequestBody Driver driver) {
        return driverService.saveDriver(driver);
    }

    // Save multiple drivers
    @PostMapping("/add-drivers")
    public ResponseEntity<List<Driver>> addMultipleDrivers(@RequestBody List<Driver> drivers) {
        List<Driver> savedDrivers = driverService.saveAll(drivers);
        return ResponseEntity.ok(savedDrivers);
    }

}

