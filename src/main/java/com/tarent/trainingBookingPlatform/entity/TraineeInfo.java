package com.tarent.trainingBookingPlatform.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name="TRAINEE_INFO")
public class TraineeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TRAINEE_INFO_ID")
    Long traineeInfoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRAINING_COURSE_ID")
    private TrainingCourse trainingCourse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_INFO_ID")
    private UserInfo userInfo;

    @Column(name="ENROLLMENT_DATE")
    LocalDate enrollmentDate;

    public TraineeInfo(TrainingCourse trainingCourse, UserInfo userInfo, LocalDate enrollmentDate) {
        this.trainingCourse = trainingCourse;
        this.userInfo = userInfo;
        this.enrollmentDate = enrollmentDate;
    }
}
