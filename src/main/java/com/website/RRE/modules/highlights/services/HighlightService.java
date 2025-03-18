package com.website.RRE.modules.highlights.services;



import com.website.RRE.modules.highlights.dtos.HighlightDto;
import com.website.RRE.modules.highlights.entities.Highlight;
import com.website.RRE.modules.highlights.repositories.HighlightRepository;
import com.website.RRE.modules.utils.DTOMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HighlightService {


    private final HighlightRepository highlightRepository;

    @Autowired
    public HighlightService(HighlightRepository highlightRepository) {
        this.highlightRepository = highlightRepository;
    }

    // finds all results
    public List<HighlightDto> findAllHighlights() {
        return highlightRepository.findAll().stream()
                .map(DTOMapper::toHighlightDTO)
                .collect(Collectors.toList());
    }


    // finds Highlights by highlightID
    public List<HighlightDto> findByHighlightID(Long highlightID) {
        return highlightRepository.findByHighlightID(highlightID).stream()
                .map(DTOMapper::toHighlightDTO)
                .collect(Collectors.toList());
    }


    // finds Highlights by highlightHeading
    public List<HighlightDto> findByHighlightHeading(String highlightHeading) {
        return highlightRepository.findByHighlightHeading(highlightHeading).stream()
                .map(DTOMapper::toHighlightDTO)
                .collect(Collectors.toList());
    }


    // save Highlight details
    public HighlightDto saveHighlight(Highlight highlight) {
        Highlight savedHighlight = highlightRepository.save(highlight);
        return DTOMapper.toHighlightDTO(savedHighlight);
    }


    // save multiple Highlight details
    public List<HighlightDto> saveAll(List<Highlight> highlights) {
        List<Highlight> savedHighlights = highlightRepository.saveAll(highlights);
        return savedHighlights.stream()
                .map(DTOMapper::toHighlightDTO)
                .collect(Collectors.toList());
    }


    // Update Highlight details
    @Transactional
    public HighlightDto updateHighlight(Long highlightID, HighlightDto highlightDto) {
        Highlight highlight = highlightRepository.findById(highlightID)
                .orElseThrow(() -> new RuntimeException("Highlight not found with ID: " + highlightID));

        // update fields if they are provided
        if (highlightDto.getHighlightHeading() != null) {
            highlight.setHighlightHeading(highlightDto.getHighlightHeading());
        }
        if (highlightDto.getHighlightDescription() != null) {
            highlight.setHighlightDescription(highlightDto.getHighlightDescription());
        }
        if (highlightDto.getHighlightImagePath() != null) {
            highlight.setHighlightImagePath(highlightDto.getHighlightImagePath());
        }
        if (highlightDto.getHighlightDate() != null) {
            highlight.setHighlightDate(highlightDto.getHighlightDate());
        }

        Highlight updatedHighlight = highlightRepository.save(highlight);
        return DTOMapper.toHighlightDTO(updatedHighlight);
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
