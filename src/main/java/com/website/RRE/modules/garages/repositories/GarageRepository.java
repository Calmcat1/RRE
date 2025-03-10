package com.website.RRE.modules.garages.repositories;


import com.website.RRE.modules.garages.entities.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// @author Lee Gitonga
// repository layer

@Repository
public interface GarageRepository extends JpaRepository<Garage, Long> {
    List<Garage> findByGarageName(String garageName);
    List<Garage> findByGarageSpeciality(String garageSpeciality);
    void deleteByGarageID(Long garageID);
    void deleteByGarageName(String garageName);
}



