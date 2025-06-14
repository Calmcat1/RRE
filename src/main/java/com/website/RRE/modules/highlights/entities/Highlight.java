package com.website.RRE.modules.highlights.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "rre_highlights", schema="rre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Highlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("highlightID")
    private Long highlightID;

    @JsonProperty("highlightHeading")
    private String highlightHeading;

    @JsonProperty("highlightDescription")
    private String highlightDescription;

    @JsonProperty("highlightImagePath")
    private String highlightImagePath;

    @JsonProperty("highlightDate")
    private Date highlightDate;


}
