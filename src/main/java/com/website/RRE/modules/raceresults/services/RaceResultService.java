package com.website.RRE.modules.raceresults.services;


import com.website.RRE.modules.raceresults.entities.RaceResult;
import com.website.RRE.modules.raceresults.repositories.RaceResultRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


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
    public List<Map<String, Object>> findAllRaceResults(){
        return raceResultRepository.findAllRaceResults();
    }

    // find race results by best time
    public List<Map<String, Object>> findByRaceResultBestTime(double raceResultBestTime) {
        return raceResultRepository.findByRaceResultBestTime(raceResultBestTime);
    }

    // find race results by rank
    public List<Map<String, Object>> findByRaceResultRank(int raceResultRank){
        return raceResultRepository.findByRaceResultRank(raceResultRank);
    }

    // find race results by event
    public List<Map<String, Object>> findByRaceResultEvent(String raceResultEvent){
        return raceResultRepository.findByRaceResultEvent(raceResultEvent);
    }

    // find race results by eventActivity
    public List<Map<String, Object>> findByRaceResultEventActivity(String raceResultEventActivity){
        return raceResultRepository.findByRaceResultEventActivity(raceResultEventActivity);
    }

    // find race results by eventYear
    List<Map<String, Object>> findByRaceResultYear(String raceResultYear){
        return raceResultRepository.findByRaceResultYear(raceResultYear);
    }



    // save a race result
    public RaceResult saveResult(RaceResult result) {
        return raceResultRepository.save(result);

    }

    //saves multiple racing results
    public List<RaceResult> saveAll(List<RaceResult> raceResults) {
        return raceResultRepository.saveAll(raceResults);
    }

    //deletes racing events
    @Transactional
    public void deleteByRaceResultID(Long raceResultID) {
        raceResultRepository.deleteById(raceResultID);
    }


}