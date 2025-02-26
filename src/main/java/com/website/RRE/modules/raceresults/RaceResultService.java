package com.website.RRE.modules.raceresults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


// service layer

// finds driver by rank, carNo, driver_name
@Service
public class RaceResultService {

    private final RaceResultRepository raceResultRepository;

    @Autowired
    public RaceResultService(RaceResultRepository raceResultRepository) {
        this.raceResultRepository = raceResultRepository;
    }


    List<RaceResult> findAllResults(){
        return raceResultRepository.findAll();
    }

    List<RaceResult> findByDriverName(String driver) {
        return raceResultRepository.findByDriverName(driver);
    }

    List<RaceResult> findByDriverCarNo(int driverCarNo) {
        return raceResultRepository.findByDriverCarNo(driverCarNo);
    }

    List<RaceResult> findByDriverRank(int driverRank) {
        return raceResultRepository.findByDriverRank(driverRank);
    }

    public RaceResult saveResult(RaceResult result) {
        return raceResultRepository.save(result);

    }
}