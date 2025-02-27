package com.website.RRE.modules.raceresults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


// service layer

// finds raceResult by rank, carNo, raceResult_name
@Service
public class RaceResultService {

    private final RaceResultRepository raceResultRepository;

    @Autowired
    public RaceResultService(RaceResultRepository raceResultRepository) {
        this.raceResultRepository = raceResultRepository;
    }

    // finds all results
    List<RaceResult> findAllResults(){
        return raceResultRepository.findAll();
    }

    List<RaceResult> findByRaceResultCarNo(int raceResultCarNo) {
        return raceResultRepository.findByRaceResultCarNo(raceResultCarNo);
    }

    List<RaceResult> findByRaceResultBestTime(int raceResultBestTime) {
        return raceResultRepository.findByRaceResultBestTime(raceResultBestTime);
    }

    List<RaceResult> findByRaceResultRank(int raceResultRank){
        return raceResultRepository.findByRaceResultRank(raceResultRank);
    }

    public RaceResult saveResult(RaceResult result) {
        return raceResultRepository.save(result);

    }
}