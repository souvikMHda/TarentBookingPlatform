package com.tarent.trainingBookingPlatform.dao;

import com.tarent.trainingBookingPlatform.dto.CourseBookingStatus;
import com.tarent.trainingBookingPlatform.dto.TrainingCourseDto;
import com.tarent.trainingBookingPlatform.dto.UserTrainingDto;
import com.tarent.trainingBookingPlatform.entity.TraineeInfo;
import com.tarent.trainingBookingPlatform.entity.TrainingCourse;
import com.tarent.trainingBookingPlatform.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface TrainingCourseDao {
    List<TrainingCourse> saveTraining(List<TrainingCourse> trainingCourse);
    Optional<List<TrainingCourse>> getTrainings(LocalDate startDate, LocalDate endDate);
    UserInfo saveUserInfo(UserInfo userInfo);
    TrainingCourse updateTrainingCourse(TrainingCourse trainingCourse);
}
