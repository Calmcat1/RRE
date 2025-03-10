package com.website.RRE.modules.raceresults.controllers;

// result layer

import com.website.RRE.modules.raceresults.entities.RaceResult;
import com.website.RRE.modules.raceresults.services.RaceResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rre/api/v1/race-results")
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://127.0.0.1:5501"})

public class RaceResultController {

    @Autowired
    private RaceResultService raceResultService;

    // Retrieve all race results
    @GetMapping
    public List<Map<String, Object>> getAllRaceResults() {
        return raceResultService.findAllRaceResults();
    }


    // Retrieve results by best time
    @GetMapping("/race-result-best-time/{raceResultBestTime}")
    public List<Map<String, Object>> getRaceResultsByBestTime(@PathVariable double raceResultBestTime) {
        return raceResultService.findByRaceResultBestTime(raceResultBestTime);
    }

    // Retrieve results by rank
    @GetMapping("/race-result-rank/{raceResultRank}")
    public List<Map<String, Object>> getRaceResultsByRank(@PathVariable int raceResultRank) {
        return raceResultService.findByRaceResultRank(raceResultRank);
    }

    // Get race results by event
    @GetMapping("/race-result-event/{raceResultEvent}")
    public List<Map<String, Object>> getRaceResultsByEvent(@PathVariable String raceResultEvent) {
        return raceResultService.findByRaceResultEvent(raceResultEvent);
    }

    // Get race results by event activity
    @GetMapping("/race-result-event-activity/{raceResultEventActivity}")
    public List<Map<String, Object>> getRaceResultsByEventActivity(@PathVariable String raceResultEventActivity) {
        return raceResultService.findByRaceResultEventActivity(raceResultEventActivity);
    }

    // Get race results by event year


    // Save a new race result
    @PostMapping("/add-race-result")
    public RaceResult saveResult(@RequestBody RaceResult result) {
        System.out.println("Received RaceResult: " + result);
        return raceResultService.saveResult(result);

    }

    // Save multiple racing results
    @PostMapping("/add-race-results")
    public ResponseEntity<List<RaceResult>> addMultipleRaceResults(@RequestBody List<RaceResult> raceResults) {
        List<RaceResult> savedRaceResults = raceResultService.saveAll(raceResults);
        return ResponseEntity.ok(savedRaceResults);
    }

    // Delete a race result
    @DeleteMapping("/delete-race-result-by-id/{raceResultID}")
    public ResponseEntity<String> deleteRaceResult(@PathVariable Long raceResultID) {
        raceResultService.deleteByRaceResultID(raceResultID);
        return ResponseEntity.ok("Race result deleted successfully for raceID %d".formatted(raceResultID));
    }



}

