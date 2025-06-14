package com.website.RRE.modules.highlights.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "rre_highlights", schema="rre",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "highlightHeading"), // unique constraint
                @UniqueConstraint(columnNames = "highlightDescription") // unique constraint
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Highlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("highlightID")
    private Long highlightID;

    @Column(nullable = false, unique = true)
    @JsonProperty("highlightHeading")
    private String highlightHeading;


    @Column(nullable = false, unique = true)
    @JsonProperty("highlightDescription")
    private String highlightDescription;

    @JsonProperty("highlightImagePath")
    private String highlightImagePath;

    @JsonProperty("highlightDate")
    private Date highlightDate;


}
