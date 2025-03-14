package com.website.RRE.modules.raceresults.services;


import com.website.RRE.modules.raceresults.dtos.RaceResultDto;
import com.website.RRE.modules.utils.DTOMapper;
import com.website.RRE.modules.raceresults.entities.RaceResult;
import com.website.RRE.modules.raceresults.repositories.RaceResultRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
    public List<RaceResultDto> findAllRaceResults() {
        List<Map<String, Object>> rawResults = raceResultRepository.findAllRaceResults();
        return rawResults.stream()
                .map(DTOMapper::toRaceResultDTO)
                .collect(Collectors.toList());
    }

    // find race results by best time
    public List<RaceResultDto> findByRaceResultBestTime(double raceResultBestTime) {
        List<Map<String, Object>> rawResults = raceResultRepository.findByRaceResultBestTime(raceResultBestTime);
        return rawResults.stream()
                .map(DTOMapper::toRaceResultDTO) // Assuming the toRaceResultDTO method is correctly implemented
                .collect(Collectors.toList());
    }


    // find race results by rank
    public List<RaceResultDto> findByRaceResultRank(int raceResultRank) {
        List<Map<String, Object>> rawResults = raceResultRepository.findByRaceResultRank(raceResultRank);
        return rawResults.stream()
                .map(DTOMapper::toRaceResultDTO) // Ensure this method correctly maps from Map<String, Object> to RaceResultDto
                .collect(Collectors.toList());
    }


    // find race results by event
    public List<RaceResultDto> findByRaceResultEvent(String raceResultEvent) {
        List<Map<String, Object>> rawResults = raceResultRepository.findByRaceResultEvent(raceResultEvent);
        return rawResults.stream()
                .map(DTOMapper::toRaceResultDTO) // Ensure this method correctly converts Map<String, Object> to RaceResultDto
                .collect(Collectors.toList());
    }


    // find race results by eventActivity
    public List<RaceResultDto> findByRaceResultEventActivity(String raceResultEventActivity) {
        List<Map<String, Object>> rawResults = raceResultRepository.findByRaceResultEventActivity(raceResultEventActivity);
        return rawResults.stream()
                .map(DTOMapper::toRaceResultDTO) // Convert Map<String, Object> to RaceResultDto
                .collect(Collectors.toList());
    }


    // find race results by eventYear
    public List<RaceResultDto> findByRaceResultYear(String raceResultYear) {
        List<Map<String, Object>> rawResults = raceResultRepository.findByRaceResultYear(raceResultYear);
        return rawResults.stream()
                .map(DTOMapper::toRaceResultDTO) // Convert Map<String, Object> to RaceResultDto
                .collect(Collectors.toList());
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