package com.tarent.trainingBookingPlatform.constants;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Constants {
    public static final String BOOKING_DONE = "BOOKED"; //When a course is booked
    public static final String BOOKING_FAILED = "FAILED"; //When a course booking fails
    public static final String ROLE_ADMIN = "ROLE_ADMIN"; //ADMIN users can create and modify courses
    public static final String ROLE_USER = "ROLE_USER"; //USER users can see, book courses
    public static final Integer BOOKING_LEFT = 10; //maximum number of bookings for a course on a certain date
}
