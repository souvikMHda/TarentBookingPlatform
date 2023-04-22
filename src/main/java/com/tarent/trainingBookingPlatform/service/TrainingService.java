package com.tarent.trainingBookingPlatform.service;

import com.tarent.trainingBookingPlatform.dto.*;
import com.tarent.trainingBookingPlatform.entity.TrainingCourse;
import com.tarent.trainingBookingPlatform.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface TrainingService {
    List<SavedTrainingCourseDto> saveTrainingCourse(TrainingCourseDto trainingCourseDto);
    List<SavedTrainingCourseDto> getListOfTrainings(LocalDate startDate, LocalDate endDate);
    UserInfo saveUserInfo(UserInfoDto userInfoDto);
    SavedTrainingCourseDto updateTrainingCourse(TrainingCourse trainingCourse);
}
