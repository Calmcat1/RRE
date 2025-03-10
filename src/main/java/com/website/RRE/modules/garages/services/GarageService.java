package com.website.RRE.modules.garages.services;

import com.website.RRE.modules.garages.entities.Garage;
import com.website.RRE.modules.garages.repositories.GarageRepository;
import jakarta.transaction.Transactional;
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
    public List<Garage> findAllGarages(){
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

    // save multiple garage details
    public List<Garage> saveAll(List<Garage> garages) {

        return garageRepository.saveAll(garages);
    }


    // deletes garages by garageID
    @Transactional
    public void deleteByGarageID(Long garageID){
        garageRepository.deleteByGarageID(garageID);
    }

    // deletes garages by garageName
    @Transactional
    public void deleteByGarageName(String garageName){
        garageRepository.deleteByGarageName(garageName);
    }


}
