package com.tarent.trainingBookingPlatform.service;

import com.tarent.trainingBookingPlatform.constants.Constants;
import com.tarent.trainingBookingPlatform.dao.BookingCourseDao;
import com.tarent.trainingBookingPlatform.dao.TrainingCourseDao;
import com.tarent.trainingBookingPlatform.dto.CourseBookingStatus;
import com.tarent.trainingBookingPlatform.dto.UserTrainingDto;
import com.tarent.trainingBookingPlatform.entity.TraineeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingCourseImpl implements BookingService{

    @Autowired
    BookingCourseDao bookingCourseDao;


    @Override
    public CourseBookingStatus bookCourse(UserTrainingDto userTrainingDto) {
        TraineeInfo traineeInfo = bookingCourseDao.bookTraineeWithCourse(userTrainingDto);
        return new CourseBookingStatus(traineeInfo.getUserInfo().getUserId(),
                traineeInfo.getTrainingCourse().getTrainingCourseId(),
                Constants.BOOKING_DONE);
    }
}
