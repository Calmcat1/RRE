package com.website.RRE.modules.garages;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @author Lee Gitonga
// version 1 db table
// entity layer


@Entity
@Table(name = "rre_garages", schema="rre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long garageID;

    @JsonProperty("garageName")
    private int garageName;

    @JsonProperty("garageSpeciality")
    private int garageSpeciality;

//    @JsonProperty("garageLogo")
//    private int garageLogo; -> future implementation for logo images


}
