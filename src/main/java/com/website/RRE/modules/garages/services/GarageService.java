package com.website.RRE.modules.garages.services;

import com.website.RRE.modules.garages.dtos.GarageDto;
import com.website.RRE.modules.garages.entities.Garage;
import com.website.RRE.modules.garages.repositories.GarageRepository;
import com.website.RRE.modules.utils.DTOMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class GarageService {

    private final GarageRepository garageRepository;

    @Autowired
    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    // finds all results
    public List<GarageDto> findAllGarages() {
        return garageRepository.findAll().stream()
                .map(DTOMapper::toGarageDTO)
                .collect(Collectors.toList());
    }

    // Finds garages by name
    public List<GarageDto> findByGarageName(String garageName) {
        return garageRepository.findByGarageName(garageName).stream()
                .map(DTOMapper::toGarageDTO)
                .collect(Collectors.toList());
    }

    // Finds garages by speciality
    public List<GarageDto> findByGarageSpeciality(String speciality) {
        return garageRepository.findByGarageSpeciality(speciality).stream()
                .map(DTOMapper::toGarageDTO)
                .collect(Collectors.toList());
    }

    // save garage details
    public GarageDto saveGarage(Garage garage) {
        Garage savedGarage = garageRepository.save(garage);
        return DTOMapper.toGarageDTO(savedGarage);
    }


    // save multiple garage details
    public List<GarageDto> saveAll(List<Garage> garages) {
        List<Garage> savedGarages = garageRepository.saveAll(garages);
        return savedGarages.stream()
                .map(DTOMapper::toGarageDTO)
                .collect(Collectors.toList());
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
