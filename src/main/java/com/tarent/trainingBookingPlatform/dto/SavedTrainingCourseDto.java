package com.tarent.trainingBookingPlatform.dto;


import com.tarent.trainingBookingPlatform.entity.TrainingCourse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SavedTrainingCourseDto {

    private Optional<Long> trainingCourseId;

    @NotEmpty
    private String courseName;

    @NotEmpty
    private String instructorName;

    @NotEmpty
    private String description;

    @NotEmpty
    private Double fee;

    private Integer bookingsLeft;
    private LocalDate trainingDate;

    /**
     * This method allows the object to be transformed to its corresponding Entity object
     * @return Entity object
     */
    public TrainingCourse toEntity(){
        TrainingCourse trainingCourse = new TrainingCourse();
        trainingCourse.setTrainingCourseId(this.trainingCourseId.orElse(null));
        trainingCourse.setCourseName(this.courseName);
        trainingCourse.setInstructorName(this.instructorName);
        trainingCourse.setDescription(this.description);
        trainingCourse.setFee(this.fee);
        trainingCourse.setBookingsLeft(this.bookingsLeft);
        trainingCourse.setTrainingDate(this.trainingDate);
        return trainingCourse;
    }
}
