package com.tarent.trainingBookingPlatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserTrainingDto {
    @NotNull
    private Long userId;

    @NotNull
    private Long trainingCourseId;
    private LocalDate enrollmentDate;
}
