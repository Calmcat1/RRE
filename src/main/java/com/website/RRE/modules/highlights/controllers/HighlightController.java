package com.website.RRE.modules.highlights.controllers;

import com.website.RRE.modules.highlights.services.HighlightService;
import com.website.RRE.modules.highlights.entities.Highlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("rre/api/v1/highlights")
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://127.0.0.1:5501"})
public class HighlightController {
    @Autowired
    private HighlightService highlightService;

    // Retrieve all highlights
    @GetMapping
    public List<Highlight> getAllHighlights() {
        return highlightService.findAllHighlights();
    }

    // Retrieve highlights by id
    @GetMapping("/highlight-id/{highlightID}")
    public List<Highlight> getHighlightsByID(@PathVariable Long highlightID) {
        return highlightService.findByHighlightID(highlightID);
    }

    // Retrieve highlights by heading
    @GetMapping("/highlight-heading/{highlightHeading}")
    public List<Highlight> getHighlightsByHeading(@PathVariable String highlightHeading) {
        return highlightService.findByHighlightHeading(highlightHeading);
    }

    // save a new highlight
    @PostMapping("/add-highlight")
    public Highlight saveHighlight(@RequestBody Highlight highlight) {
        return highlightService.saveHighlight(highlight);
    }

    // Save multiple highlights
    @PostMapping("/add-highlights")
    public ResponseEntity<List<Highlight>> addMultipleHighlights(@RequestBody List<Highlight> highlights) {
        List<Highlight> savedHighlights = highlightService.saveAll(highlights);
        return ResponseEntity.ok(savedHighlights);
    }

    // Delete Highlights by ID
    @DeleteMapping("/delete-highlight-id/{highlightID}")
    public void deleteHighlightByID(@PathVariable Long highlightID){
        highlightService.deleteByHighlightID(highlightID);

    }

    // Delete Highlights by Name
    @DeleteMapping("/delete-highlight-name/{highlightName}")
    public void deleteHighlightByName(@PathVariable String highlightName){
        highlightService.deleteByHighlightName(highlightName);

    }






}
