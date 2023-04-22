package com.tarent.trainingBookingPlatform.entity;


import com.tarent.trainingBookingPlatform.dto.SavedTrainingCourseDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name="TRAINING_COURSE")
public class TrainingCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TRAINING_COURSE_ID")
    Long trainingCourseId;

    @Column(name="COURSE_NAME")
    String courseName;

    @Column(name="INSTRUCTOR_NAME")
    String instructorName;

    @Column(name="DESCRIPTION")
    String description;

    @Column(name="FEE")
    Double fee;

    @Column(name="BOOKINGS_LEFT")
    Integer bookingsLeft;

    @Column(name="TRAINING_DATE")
    LocalDate trainingDate;

    public SavedTrainingCourseDto toDto(){
        return new SavedTrainingCourseDto(java.util.Optional.ofNullable(this.trainingCourseId),
                this.courseName,this.instructorName,this.description,
                this.fee,this.bookingsLeft,this.trainingDate);

    }
}
