package com.tarent.trainingBookingPlatform.dao;

import com.tarent.trainingBookingPlatform.dto.UserTrainingDto;
import com.tarent.trainingBookingPlatform.entity.TraineeInfo;
import org.springframework.stereotype.Service;

@Service
public interface BookingCourseDao {
    TraineeInfo bookTraineeWithCourse(UserTrainingDto userTrainingDto);
}
