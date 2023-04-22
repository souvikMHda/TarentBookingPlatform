package com.tarent.trainingBookingPlatform.constants;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Constants {
    public static final String BOOKING_DONE = "BOOKED"; //When a course is booked
    public static final String BOOKING_FAILED = "FAILED";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    public static final Integer BOOKING_LEFT = 10;
}
