package com.tarent.trainingBookingPlatform.service;

import com.tarent.trainingBookingPlatform.dao.TrainingCourseDao;
import com.tarent.trainingBookingPlatform.dto.*;
import com.tarent.trainingBookingPlatform.entity.TrainingCourse;
import com.tarent.trainingBookingPlatform.entity.UserInfo;
import com.tarent.trainingBookingPlatform.enums.ErrorEnum;
import com.tarent.trainingBookingPlatform.exception.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TrainingServiceImpl implements TrainingService{
    @Autowired
    TrainingCourseDao trainingCourseDao;

    /**
     * This method saves courses
     * @param trainingCourseDto contains the course details including the days on which it would take place
     * @return saved Training Courses
     */
    @Override
    public List<SavedTrainingCourseDto> saveTrainingCourse(TrainingCourseDto trainingCourseDto) {
        return trainingCourseDao.saveTraining(trainingCourseDto.toEntity()).
                stream().map(TrainingCourse::toDto).collect(Collectors.toList());
    }

    /**
     * This method gets training courses in between the start date and the end date
     * @param startDate starting from which, courses are to be fetched
     * @param endDate till which , courses are to be fetched
     * @return Training courses in between dates
     */
    @Override
    public List<SavedTrainingCourseDto> getListOfTrainings(LocalDate startDate, LocalDate endDate) {
        Optional<List<TrainingCourse>> trainingCoursesList = trainingCourseDao.getTrainings(startDate,endDate);
        if(trainingCoursesList.isPresent() && !trainingCoursesList.get().isEmpty()){
            return trainingCoursesList.get().stream().
                            map(TrainingCourse::toDto).collect(Collectors.toList());
        }else{
           throw new CourseNotFoundException(ErrorEnum.COURSE_NOT_FOUND_EXCEPTION.getErrorDesc());
        }
    }

    /**
     * This method saves user information
     * @param userInfoDto validated user information
     * @return saved user information
     */
    @Override
    public UserInfo saveUserInfo(UserInfoDto userInfoDto) {
        if(!userInfoDto.getCreatedDate().isPresent()){
            userInfoDto.setCreatedDate(Optional.of(LocalDate.now()));
        }
        return trainingCourseDao.saveUserInfo(userInfoDto.toEntity());
    }

    /**
     * This method updates an existing training course
     * @param trainingCourse is the course to be updated
     * @return updated course details
     */
    @Override
    public SavedTrainingCourseDto updateTrainingCourse(TrainingCourse trainingCourse) {
        return trainingCourseDao.updateTrainingCourse(trainingCourse).toDto();
    }

}
