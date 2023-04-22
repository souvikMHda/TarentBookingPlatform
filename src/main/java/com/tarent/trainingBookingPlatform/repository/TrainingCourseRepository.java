package com.tarent.trainingBookingPlatform.repository;

import com.tarent.trainingBookingPlatform.entity.TrainingCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingCourseRepository extends JpaRepository<TrainingCourse,Long> {

    @Query("SELECT tc FROM TrainingCourse tc WHERE tc.trainingDate BETWEEN ?1 AND ?2")
    Optional<List<TrainingCourse>> findByTrainingDateBetween(LocalDate startDate, LocalDate endDate);
}
