package com.website.RRE.modules.raceresults.controllers;

// result layer

import com.website.RRE.modules.raceresults.dtos.RaceResultDto;
import com.website.RRE.modules.raceresults.entities.RaceResult;
import com.website.RRE.modules.raceresults.services.RaceResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rre/api/v1/race-results")
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://127.0.0.1:5501", "http://localhost:5173", "https://rrefrontend.vercel.app"})
public class RaceResultController {

    @Autowired
    private RaceResultService raceResultService;

    // Retrieve all race results
    @GetMapping
    public List<RaceResultDto> getAllRaceResults() {
        return raceResultService.findAllRaceResults();
    }


    // Retrieve results by best time
    @GetMapping("/race-result-best-time/{raceResultBestTime}")
    public List<RaceResultDto> getRaceResultsByBestTime(@PathVariable double raceResultBestTime) {
        return raceResultService.findByRaceResultBestTime(raceResultBestTime);
    }

    // Retrieve results by rank
    @GetMapping("/race-result-rank/{raceResultRank}")
    public List<RaceResultDto> getRaceResultsByRank(@PathVariable int raceResultRank) {
        return raceResultService.findByRaceResultRank(raceResultRank);
    }

    // Get race results by event
    @GetMapping("/race-result-event/{raceResultEvent}")
    public List<RaceResultDto> getRaceResultsByEvent(@PathVariable String raceResultEvent) {
        return raceResultService.findByRaceResultEvent(raceResultEvent);
    }

    // Get race results by event activity
    @GetMapping("/race-result-event-activity/{raceResultEventActivity}")
    public List<RaceResultDto> getRaceResultsByEventActivity(@PathVariable String raceResultEventActivity) {
        return raceResultService.findByRaceResultEventActivity(raceResultEventActivity);
    }

    // Get race results by event year


    // Save a new race result
    @PostMapping("/add-race-result")
    public RaceResultDto saveResult(@RequestBody RaceResult result) {
        System.out.println("Received RaceResult: " + result);
        return raceResultService.saveResult(result);

   }

    // Save multiple racing results
    @PostMapping("/add-race-results")
    public ResponseEntity<List<RaceResultDto>> addMultipleRaceResults(@RequestBody List<RaceResult> raceResults) {
        List<RaceResultDto> savedRaceResults = raceResultService.saveAll(raceResults);
        return ResponseEntity.ok(savedRaceResults);
    }


    // Update race results
    // Update race result by ID (PATCH)
    @PatchMapping("/{raceResultID}")
    public ResponseEntity<RaceResultDto> updateRaceResult(
            @PathVariable Long raceResultID,
            @RequestBody RaceResultDto raceResultDto) {
        RaceResultDto updatedRaceResult = raceResultService.updateRaceResult(raceResultID, raceResultDto);
        return ResponseEntity.ok(updatedRaceResult);
    }

    // Delete a race result
    @DeleteMapping("/delete-race-result-by-id/{raceResultID}")
    public ResponseEntity<String> deleteRaceResult(@PathVariable Long raceResultID) {
        raceResultService.deleteByRaceResultID(raceResultID);
        return ResponseEntity.ok("Race result deleted successfully for raceID %d".formatted(raceResultID));
    }



}

