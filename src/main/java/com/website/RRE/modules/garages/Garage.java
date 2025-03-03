package com.website.RRE.modules.garages;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    private String garageName;

    @JsonProperty("garageSpeciality")
    private String garageSpeciality;

//    @JsonProperty("garageLogo")
//    private int garageLogo; -> future implementation for logo images


}
