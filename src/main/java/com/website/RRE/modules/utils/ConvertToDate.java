package com.website.RRE.modules.utils;

import java.sql.Date;
import java.sql.Timestamp;


public class ConvertToDate {

    // ✅ Helper method to convert Timestamp to Date safely
    static Date convertToDate(Object dateObject) {
        if (dateObject instanceof Timestamp) {
            return new Date(((Timestamp) dateObject).getTime()); // Convert Timestamp to Date
        } else if (dateObject instanceof Date) {
            return (Date) dateObject; // Already a Date, return as is
        }
        throw new IllegalArgumentException("Invalid date type: " + dateObject.getClass().getName());
    }
}
