package com.tarent.trainingBookingPlatform.dto;

import com.tarent.trainingBookingPlatform.constants.Constants;
import com.tarent.trainingBookingPlatform.entity.TrainingCourse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrainingCourseDto {


    private Optional<Long> trainingCourseId;

    @NotEmpty
    private String courseName;

    @NotEmpty
    private String instructorName;

    @NotEmpty
    private String description;

    @NotEmpty
    private Double fee;

    private List<LocalDate> trainingDates;

    /**
     * This method converts training course details to individual courses
     * @return
     */
    public List<TrainingCourse> toEntity(){
        List<TrainingCourse> trainingCourseList = new ArrayList<>();
        for(LocalDate date: this.trainingDates){
            TrainingCourse trainingCourse = new TrainingCourse();
            trainingCourse.setTrainingCourseId(this.trainingCourseId.orElse(null));
            trainingCourse.setCourseName(this.courseName);
            trainingCourse.setDescription(this.description);
            trainingCourse.setInstructorName(this.instructorName);
            trainingCourse.setBookingsLeft(Constants.BOOKING_LEFT);
            trainingCourse.setFee(this.fee);
            trainingCourse.setTrainingDate(date);
            trainingCourseList.add(trainingCourse);
        }
        return trainingCourseList;
    }
}
