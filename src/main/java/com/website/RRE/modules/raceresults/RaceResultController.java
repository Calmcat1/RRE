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

    // Retrieve results by driver name
    @GetMapping("/driver/{name}")
    public List<RaceResult> getResultsByDriver(@PathVariable String name) {
        return raceResultService.findByDriverName(name);
    }

    // Retrieve results by driver rank
    @GetMapping("/driver/{rank}")
    public List<RaceResult> getResultsByRank(@PathVariable int rank) {
        return raceResultService.findByDriverRank(rank);
    }

    // Retrieve results by car number
    @GetMapping("/driver/{carNo}")
    public List<RaceResult> getResultsByCarNo(@PathVariable int carNo) {
        return raceResultService.findByDriverCarNo(carNo);
    }

    // Save a new race result
    @PostMapping("/add-race-results")
    public RaceResult saveResult(@RequestBody RaceResult result) {
        return raceResultService.saveResult(result);
    }
}

