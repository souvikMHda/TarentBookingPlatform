package com.tarent.trainingBookingPlatform.service;

import com.tarent.trainingBookingPlatform.dto.CourseBookingStatus;
import com.tarent.trainingBookingPlatform.dto.UserTrainingDto;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    CourseBookingStatus bookCourse(UserTrainingDto userTrainingDto);
}
