package com.website.RRE.modules.highlights.services;



import com.website.RRE.modules.highlights.dtos.HighlightDto;
import com.website.RRE.modules.highlights.entities.Highlight;
import com.website.RRE.modules.highlights.repositories.HighlightRepository;
import com.website.RRE.modules.utils.DTOMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HighlightService {

    private static final String UPLOAD_DIR = "uploads/";

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


    // Saves an image and returns its path
    public String saveImage(MultipartFile file) {
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path uploadPath = Paths.get(UPLOAD_DIR);

            // Ensure the directory exists
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return "/uploads/" + fileName;
            // catches the error in failure to image upload
        } catch (IOException e) {
            throw new RuntimeException("Failed to store image", e);
        }
    }

    // Save Highlight with Image
    public HighlightDto saveHighlight(Highlight highlight, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            String imagePath = saveImage(file);
            highlight.setHighlightImagePath(imagePath);
        }

        Highlight savedHighlight = highlightRepository.save(highlight);
        return DTOMapper.toHighlightDTO(savedHighlight);
    }

    // Save Multiple highlights and Images
    public List<HighlightDto> saveAll(List<Highlight> highlights, List<MultipartFile> files) {
        if (files != null && !files.isEmpty()) {
            for (int i = 0; i < highlights.size(); i++) {
                if (i < files.size() && !files.get(i).isEmpty()) {
                    String imagePath = saveImage(files.get(i));
                    highlights.get(i).setHighlightImagePath(imagePath);
                }
            }
        }
        List<Highlight> savedHighlights = highlightRepository.saveAll(highlights);
        return savedHighlights.stream().map(DTOMapper::toHighlightDTO).collect(Collectors.toList());
    }

    // Update Highlight with Image
    @Transactional
    public HighlightDto updateHighlight(Long highlightID, HighlightDto highlightDto, MultipartFile file) {
        Highlight highlight = highlightRepository.findById(highlightID)
                .orElseThrow(() -> new RuntimeException("Highlight not found with ID: " + highlightID));

        if (highlightDto.getHighlightHeading() != null) {
            highlight.setHighlightHeading(highlightDto.getHighlightHeading());
        }
        if (highlightDto.getHighlightDescription() != null) {
            highlight.setHighlightDescription(highlightDto.getHighlightDescription());
        }
        if (highlightDto.getHighlightDate() != null) {
            highlight.setHighlightDate(highlightDto.getHighlightDate());
        }
        if (file != null && !file.isEmpty()) {
            String imagePath = saveImage(file);
            highlight.setHighlightImagePath(imagePath);
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
