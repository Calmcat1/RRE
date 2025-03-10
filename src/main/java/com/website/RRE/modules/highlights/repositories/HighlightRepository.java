package com.website.RRE.modules.highlights.repositories;


import com.website.RRE.modules.highlights.entities.Highlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HighlightRepository extends JpaRepository<Highlight, Long> {

    List<Highlight> findByHighlightID(Long highlightID);
    List<Highlight> findByHighlightHeading(String highlightHeading);
    void deleteByHighlightID(Long highlightID);
    void deleteByHighlightHeading(String highlightHeading);

}
