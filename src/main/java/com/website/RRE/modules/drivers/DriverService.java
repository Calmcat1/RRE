package com.website.RRE.modules.drivers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    // Finds all drivers
    public List<Driver> findAllDrivers() {
        return driverRepository.findAll();
    }

    // Finds drivers by name
    public List<Driver> findByDriverName(String driverName) {
        return driverRepository.findByDriverName(driverName);
    }

    // Finds drivers by car make
    public List<Driver> findByDriverCarMake(String carMake) {
        return driverRepository.findByDriverCarMake(carMake);
    }

    // Saves driver details
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    // Saves multiple driver details
    public List<Driver> saveAll(List<Driver> drivers) {
        return driverRepository.saveAll(drivers);
    }

    // endpoints to be added in v2
    // deletes drivers by driverID
    @Transactional
    public List<Driver> deleteByDriverID(Long driverID){
        return driverRepository.deleteByDriverID(driverID);
    }

    // deletes drivers by driverName
    @Transactional
    public List<Driver> deleteByDriverName(String driverName){
        return driverRepository.deleteByDriverName(driverName);
    }
}

