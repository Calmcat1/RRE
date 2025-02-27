package com.website.RRE.modules.raceresults;

// result layer

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    // Retrieve results by car number
    @GetMapping("/raceResultCarNo/{carNo}")
    public List<RaceResult> getRaceResultsByCarNo(@PathVariable int raceResultCarNo) {
        return raceResultService.findByRaceResultCarNo(raceResultCarNo);
    }

    // Retrieve results by best time
    @GetMapping("/raceResultBestTime/{bestTime}")
    public List<RaceResult> getRaceResultsByBestTime(@PathVariable int raceResultBestTime) {
        return raceResultService.findByRaceResultBestTime(raceResultBestTime);
    }

    // Retrieve results by rank
    @GetMapping("/raceResultRank/{rank}")
    public List<RaceResult> getRaceResultsByRank(@PathVariable int raceResultRank) {
        return raceResultService.findByRaceResultRank(raceResultRank);
    }

    // Save a new race result
    @PostMapping("/add-race-results")
    public RaceResult saveResult(@RequestBody RaceResult result) {
        return raceResultService.saveResult(result);
    }
}

