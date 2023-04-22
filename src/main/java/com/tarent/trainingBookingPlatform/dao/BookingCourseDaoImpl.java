package com.tarent.trainingBookingPlatform.dao;

import com.tarent.trainingBookingPlatform.dto.UserTrainingDto;
import com.tarent.trainingBookingPlatform.entity.TraineeInfo;
import com.tarent.trainingBookingPlatform.entity.TrainingCourse;
import com.tarent.trainingBookingPlatform.entity.UserInfo;
import com.tarent.trainingBookingPlatform.enums.ErrorEnum;
import com.tarent.trainingBookingPlatform.exception.CourseNotFoundException;
import com.tarent.trainingBookingPlatform.exception.UserNotFoundException;
import com.tarent.trainingBookingPlatform.repository.TraineeInfoRepository;
import com.tarent.trainingBookingPlatform.repository.TrainingCourseRepository;
import com.tarent.trainingBookingPlatform.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class BookingCourseDaoImpl implements BookingCourseDao{

    @Autowired
    TrainingCourseRepository trainingCourseRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    TraineeInfoRepository traineeInfoRepository;

    /**
     * This method books the training Course ID against the user ID. In cases where the user is not found,
     * course is not found or course is completely booked out, an exception is thrown
     * @param userTrainingDto
     * @return
     */
    @Override
    public TraineeInfo bookTraineeWithCourse(UserTrainingDto userTrainingDto) {
        Optional<TrainingCourse> trainingCourse= trainingCourseRepository.findById(userTrainingDto.getTrainingCourseId());
        Optional<UserInfo> userInfo= userInfoRepository.findById(userTrainingDto.getUserId());
        if(userInfo.isPresent()){
            if(trainingCourse.isEmpty()){
                throw new CourseNotFoundException(ErrorEnum.COURSE_NOT_FOUND_EXCEPTION.getErrorDesc());
            }else if(trainingCourse.get().getBookingsLeft()==0){
                throw new CourseNotFoundException(ErrorEnum.COURSE_BOOKED_OUT.getErrorDesc());
            }else{
                trainingCourse.get().setBookingsLeft(trainingCourse.get().getBookingsLeft()-1);
                TraineeInfo traineeInfo = new TraineeInfo(trainingCourse.get(),userInfo.get(), LocalDate.now());
                return traineeInfoRepository.save(traineeInfo);
            }
        }else{
            throw new UserNotFoundException(ErrorEnum.USER_NOT_REGISTERED.getErrorDesc());
        }

    }
}
