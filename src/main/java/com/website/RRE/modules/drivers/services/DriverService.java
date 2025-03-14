package com.website.RRE.modules.drivers.services;

import com.website.RRE.modules.drivers.dtos.DriverDto;
import com.website.RRE.modules.drivers.entities.Driver;
import com.website.RRE.modules.drivers.repositories.DriverRepository;
import com.website.RRE.modules.utils.DTOMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    // Finds all drivers
    public List<DriverDto> findAllDrivers() {
        return driverRepository.findAll().stream()
                .map(DTOMapper::toDriverDTO)
                .collect(Collectors.toList());
    }


    // Finds drivers by name
    public List<DriverDto> findByDriverName(String driverName) {
        return driverRepository.findByDriverName(driverName)
                .stream()
                .map(DTOMapper::toDriverDTO)
                .collect(Collectors.toList());

    }

    // Finds drivers by car make
    public List<DriverDto> findByDriverCarMake(String driverCarMake) {
        return driverRepository.findByDriverName(driverCarMake)
                .stream()
                .map(DTOMapper::toDriverDTO)
                .collect(Collectors.toList());
    }

    // Saves driver details
    public DriverDto saveDriver(Driver driver) {
        Driver savedDriver = driverRepository.save(driver);
        return DTOMapper.toDriverDTO(savedDriver);
    }

    // Saves multiple driver details
    public List<DriverDto> saveAll(List<Driver> drivers) {
        List<Driver> savedDrivers = driverRepository.saveAll(drivers);
        return savedDrivers.stream()
                .map(DTOMapper::toDriverDTO)
                .collect(Collectors.toList());
    }

    // endpoints to be added in v2
    // deletes drivers by driverID
    @Transactional
    public void deleteByDriverID(Long driverID){
        driverRepository.deleteByDriverID(driverID);
    }

    // deletes drivers by driverName
    @Transactional
    public void deleteByDriverName(String driverName){
        driverRepository.deleteByDriverName(driverName);
    }
}

