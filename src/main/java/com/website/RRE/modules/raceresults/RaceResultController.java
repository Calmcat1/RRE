package com.website.RRE.modules.raceresults;

// result layer

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("rre/api/v1/race-results")
public class RaceResultController {

    @Autowired
    private RaceResultService raceResultService;

    // Retrieve all race results
    @GetMapping
    public List<RaceResult> getAllResults() {
        return raceResultService.findAllResults();
    }


    // Retrieve results by best time
    @GetMapping("/raceResultBestTime/{raceResultBestTime}")
    public Optional<Map<String, Object>> getRaceResultsByBestTime(@PathVariable int raceResultBestTime) {
        return raceResultService.findByRaceResultBestTime(raceResultBestTime);
    }

    // Retrieve results by rank
    @GetMapping("/raceResultRank/{rank}")
    public List<RaceResult> getRaceResultsByRank(@PathVariable int raceResultRank) {
        return raceResultService.findByRaceResultRank(raceResultRank);
    }

    // Get race results by event
    @GetMapping("/race-result-event/{raceResultEvent}")
    public List<RaceResult> getRaceResultsByEvent(@PathVariable String raceResultEvent) {
        return raceResultService.findByRaceResultEvent(raceResultEvent);
    }

    // Get race results by event activity
    @GetMapping("/race-result-event-activity/{raceResultEventActivity}")
    public List<RaceResult> getRaceResultsByEventActivity(@PathVariable String raceResultEventActivity) {
        return raceResultService.findByRaceResultEventActivity(raceResultEventActivity);
    }

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



}

