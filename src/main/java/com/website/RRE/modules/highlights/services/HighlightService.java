package com.website.RRE.modules.highlights.services;



import com.website.RRE.modules.highlights.entities.Highlight;
import com.website.RRE.modules.highlights.repositories.HighlightRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighlightService {


    private final HighlightRepository highlightRepository;

    @Autowired
    public HighlightService(HighlightRepository highlightRepository) {
        this.highlightRepository = highlightRepository;
    }

    // finds all results
    public List<Highlight> findAllHighlights(){
        return highlightRepository.findAll();
    }

    // finds Highlights by highlightID
    public List<Highlight> findByHighlightID(Long highlightID){
        return highlightRepository.findByHighlightID(highlightID);
    }

    // finds Highlights by highlightHeading
    public List<Highlight> findByHighlightHeading(String highlightHeading){
        return highlightRepository.findByHighlightHeading(highlightHeading);
    }

    // save Highlight details
    public Highlight saveHighlight(Highlight highlight) {
        return highlightRepository.save(highlight);
    }

    // save multiple Highlight details
    public List<Highlight> saveAll(List<Highlight> highlights) {
        return highlightRepository.saveAll(highlights);
    }

    // deletes highlights by highlightID
    @Transactional
    public void deleteByHighlightID(Long highlightID){
        highlightRepository.deleteByHighlightID(highlightID);
    }

    // deletes highlights by highlightHeading
    @Transactional
    public void deleteByHighlightName(String highlightHeading){
        highlightRepository.deleteByHighlightHeading(highlightHeading);
    }


}
