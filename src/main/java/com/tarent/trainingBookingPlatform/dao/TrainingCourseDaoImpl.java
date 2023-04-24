package com.tarent.trainingBookingPlatform.dao;

import com.tarent.trainingBookingPlatform.entity.TrainingCourse;
import com.tarent.trainingBookingPlatform.entity.UserInfo;
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

    /**
     * This method saves training courses
     * @param trainingCourseList List of Training courses
     * @return List of saved training courses
     */
    @Override
    @Transactional
    public List<TrainingCourse> saveTraining(List<TrainingCourse> trainingCourseList) {
        return trainingCourseRepository.saveAll(trainingCourseList);
    }

    /**
     * This method gets all the training courses in between the startDate and endDate
     * @param startDate is the starting date, from which courses should be fetched
     * @param endDate is the ending date, till which courses should be fetched
     * @return training courses in the date range
     */
    @Override
    public Optional<List<TrainingCourse>> getTrainings(LocalDate startDate, LocalDate endDate) {
        return trainingCourseRepository.findByTrainingDateBetween(startDate,endDate);
    }

    /**
     * This method saves user information
     * @param userInfo user information details
     * @return saved user information
     */
    @Override
    @Transactional
    public UserInfo saveUserInfo(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    /**
     * This method updates a specific training course
     * @param trainingCourse is the course to be modified
     * @return updated training course
     */
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
