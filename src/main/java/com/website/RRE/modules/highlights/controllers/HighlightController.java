package com.website.RRE.modules.highlights.controllers;

import com.website.RRE.modules.highlights.dtos.HighlightDto;
import com.website.RRE.modules.highlights.services.HighlightService;
import com.website.RRE.modules.highlights.entities.Highlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



@RestController
@RequestMapping("rre/api/v1/highlights")
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://127.0.0.1:5501" , "http://localhost:5173", "https://rrefrontend.vercel.app"})
public class HighlightController {
    @Autowired
    private HighlightService highlightService;

    // Retrieve all highlights
    @GetMapping
    public List<HighlightDto> getAllHighlights() {
        return highlightService.findAllHighlights();
    }

    // Retrieve highlights by id
    @GetMapping("/highlight-id/{highlightID}")
    public List<HighlightDto> getHighlightsByID(@PathVariable Long highlightID) {
        return highlightService.findByHighlightID(highlightID);
    }

    // Retrieve highlights by heading
    @GetMapping("/highlight-heading/{highlightHeading}")
    public List<HighlightDto> getHighlightsByHeading(@PathVariable String highlightHeading) {
        return highlightService.findByHighlightHeading(highlightHeading);
    }

    // save a new highlight
    @PostMapping(value = "/add-highlight", consumes = "multipart/form-data")
    public HighlightDto saveHighlight(@RequestPart Highlight highlight,  @RequestPart(value = "file", required = false) MultipartFile file) {
        return highlightService.saveHighlight(highlight, file);
    }

    // Save multiple highlights
    @PostMapping(value = "/add-highlights", consumes = "multipart/form-data")
    public ResponseEntity<List<HighlightDto>> addMultipleHighlights(@RequestBody List<Highlight> highlights, @RequestBody List<MultipartFile> files) {
        List<HighlightDto> savedHighlights = highlightService.saveAll(highlights, files);
        return ResponseEntity.ok(savedHighlights);
    }


    // Update Highlights
    @PatchMapping(value = "/{highlightID}", consumes = "multipart/form-data")
    public ResponseEntity<HighlightDto> updateHighlight(
            @PathVariable Long highlightID,
            @RequestPart("highlightDto") HighlightDto highlightDto,
            @RequestPart(value = "file", required = false) MultipartFile file) {

        HighlightDto updatedHighlight = highlightService.updateHighlight(highlightID, highlightDto, file);
        return ResponseEntity.ok(updatedHighlight);
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
