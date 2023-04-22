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

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class TrainingCourseDaoImpl implements TrainingCourseDao{

    @Autowired
    TrainingCourseRepository trainingCourseRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    TraineeInfoRepository traineeInfoRepository;

    @Override
    @Transactional
    public List<TrainingCourse> saveTraining(List<TrainingCourse> trainingCourseList) {
        return trainingCourseRepository.saveAll(trainingCourseList);
    }

    @Override
    public Optional<List<TrainingCourse>> getTrainings(LocalDate startDate, LocalDate endDate) {
        return trainingCourseRepository.findByTrainingDateBetween(startDate,endDate);
    }

    @Override
    @Transactional
    public UserInfo saveUserInfo(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    @Transactional
    public TrainingCourse updateTrainingCourse(TrainingCourse trainingCourse){
        Optional<TrainingCourse> savedTrainingCourse =
                trainingCourseRepository.findById(trainingCourse.getTrainingCourseId());
        if(savedTrainingCourse.isPresent()){
            savedTrainingCourse.get().setTrainingDate(trainingCourse.getTrainingDate());
            savedTrainingCourse.get().setCourseName(trainingCourse.getCourseName());
            savedTrainingCourse.get().setDescription(trainingCourse.getDescription());
            savedTrainingCourse.get().setFee(trainingCourse.getFee());
            savedTrainingCourse.get().setBookingsLeft(trainingCourse.getBookingsLeft());
            savedTrainingCourse.get().setInstructorName(trainingCourse.getInstructorName());
            return trainingCourseRepository.save(savedTrainingCourse.get());
        }else{
            return trainingCourseRepository.save(trainingCourse);
        }
    }
}
