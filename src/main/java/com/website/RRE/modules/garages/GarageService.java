package com.website.RRE.modules.garages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GarageService {

    private final GarageRepository garageRepository;

    @Autowired
    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    // finds all results
    List<Garage> findAllGarages(){
        return garageRepository.findAll();
    }

    // Finds garages by name
    public List<Garage> findByGarageName(String garageName) {
        return garageRepository.findByGarageName(garageName);
    }

    // Finds garages by speciality
    public List<Garage> findByGarageSpeciality(String speciality) {
        return garageRepository.findByGarageSpeciality(speciality);
    }

    // save garage details
    public Garage saveGarage(Garage garage) {
        return garageRepository.save(garage);
    }




}
