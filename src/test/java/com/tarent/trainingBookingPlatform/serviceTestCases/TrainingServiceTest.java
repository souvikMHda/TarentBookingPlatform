package com.tarent.trainingBookingPlatform;


import com.tarent.trainingBookingPlatform.dto.TrainingCourseDto;
import com.tarent.trainingBookingPlatform.service.BookingService;
import com.tarent.trainingBookingPlatform.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TrainingServiceTest {

    @Autowired
    TrainingService trainingService;

    @Autowired
    BookingService bookingService;

    void testSaveTrainingCourse(){
        TrainingCourseDto trainingCourseDto = new TrainingCourseDto
                (Optional.ofNullable(null),"test course","test instructor",
                        "test description",00.00, 10, LocalDate.now());
        assertThat(trainingService.saveTrainingCourse(trainingCourseDto).getTrainingCourseId().isPresent());
    }
}
