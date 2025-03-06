package com.website.RRE.modules.garages;

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

    // save multiple garage details
    public List<Garage> saveAll(List<Garage> garages) {
        return garageRepository.saveAll(garages);
    }

    // endpoints to be added in v2
    // deletes garages by garageID
    @Transactional
    public List<Garage> deleteByGarageID(Long garageID){
        return garageRepository.deleteByGarageID(garageID);
    }

    // deletes garages by garageName
    @Transactional
    public List<Garage> deleteByGarageName(String garageName){
        return garageRepository.deleteByGarageName(garageName);
    }


}
