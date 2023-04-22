package com.tarent.trainingBookingPlatform.dto;


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
public class TrainingCourseDtoResponse {

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
}
