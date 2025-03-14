package com.website.RRE.modules.highlights.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HighlightDto {
        private Long highlightID;
        private String highlightHeading;
        private String highlightDescription;
        private String highlightImagePath;
        private Date highlightDate;
}
