package com.tarent.trainingBookingPlatform.enums;

public enum ErrorEnum {
    COURSE_NOT_FOUND_EXCEPTION("ERROR::Courses not found."),
    COURSE_BOOKING_FAILED("ERROR::Course could not be booked"),
    USER_NOT_REGISTERED("ERROR::Course could not be booked, User is not registered"),
    COURSE_BOOKED_OUT("ERROR:: Course is booked out completely, please try booking for another date");




    private String errorDesc;

    public String getErrorDesc() {
        return this.errorDesc;
    }

    private ErrorEnum(String errorDesc) {
        this.errorDesc = errorDesc;
    }
}
