package com.website.RRE.modules.raceresults;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


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

    // find race results by best time
    Optional<Map<String, Object>> findByRaceResultBestTime(int raceResultBestTime) {
        return raceResultRepository.findByRaceResultBestTime(raceResultBestTime);
    }

    // find race results by rank
    List<RaceResult> findByRaceResultRank(int raceResultRank){
        return raceResultRepository.findByRaceResultRank(raceResultRank);
    }

    // find race results by event
    List<RaceResult> findByRaceResultEvent(String raceResultEvent){
        return raceResultRepository.findByRaceResultEvent(raceResultEvent);
    }

    // find race results by eventActivity
    List<RaceResult> findByRaceResultEventActivity(String raceResultEventActivity){
        return raceResultRepository.findByRaceResultEvent(raceResultEventActivity);
    }



    // save a race result
    public RaceResult saveResult(RaceResult result) {
        return raceResultRepository.save(result);

    }

    //saves multiple racing results
    public List<RaceResult> saveAll(List<RaceResult> raceResults) {
        return raceResultRepository.saveAll(raceResults);
    }






}