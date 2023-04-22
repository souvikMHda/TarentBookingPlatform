package com.tarent.trainingBookingPlatform.serviceTestCases;


import com.tarent.trainingBookingPlatform.constants.Constants;
import com.tarent.trainingBookingPlatform.dto.*;
import com.tarent.trainingBookingPlatform.exception.CourseNotFoundException;
import com.tarent.trainingBookingPlatform.service.BookingService;
import com.tarent.trainingBookingPlatform.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TrainingServiceTest {

    @Autowired
    TrainingService trainingService;

    @Autowired
    BookingService bookingService;

    @Test
    void testSaveTrainingCourse(){
        LocalDate[] localDates = {LocalDate.now(), LocalDate.now().plusDays(1)};
        TrainingCourseDto trainingCourseDto = new TrainingCourseDto
                (Optional.ofNullable(null),"test course","test instructor",
                        "test description",00.00, Arrays.asList(localDates));
        assertThat(!trainingService.saveTrainingCourse(trainingCourseDto).isEmpty());
    }

    @Test
    void testGetListOfTrainings(){
        LocalDate[] localDates = {LocalDate.now(), LocalDate.now().plusDays(1)};
        TrainingCourseDto trainingCourseDto = new TrainingCourseDto
                (Optional.ofNullable(null),"test course","test instructor",
                        "test description",00.00, Arrays.asList(localDates));
        trainingService.saveTrainingCourse(trainingCourseDto);
        assertThat(!trainingService.getListOfTrainings(LocalDate.now().minusDays(1),LocalDate.now().plusDays(1)).isEmpty());
    }

    @Test
    void testSaveUserInfo(){
        UserInfoDto userInfoDto = new UserInfoDto
                (Optional.ofNullable(null), "user name", "user@email.com",
                        "strongPassword", Constants.ROLE_USER, Optional.of(LocalDate.now()));
        assertThat(trainingService.saveUserInfo(userInfoDto).toDto().getUserId().isPresent());
    }

    @Test
    void testBookCourse(){
        LocalDate[] localDates = {LocalDate.now(), LocalDate.now().plusDays(1)};
        List<SavedTrainingCourseDto> savedTrainingCourseDtoList = trainingService.saveTrainingCourse(new TrainingCourseDto
                (Optional.ofNullable(null),"test course","test instructor",
                        "test description",00.00, Arrays.asList(localDates)));

        UserInfoDto userInfoDto = trainingService.saveUserInfo(new UserInfoDto
                (Optional.ofNullable(null), "user name", "user@email.com",
                        "strongPassword", Constants.ROLE_USER, Optional.of(LocalDate.now()))).toDto();

        assertThat(bookingService.bookCourse(new UserTrainingDto(userInfoDto.getUserId().get(),
                        savedTrainingCourseDtoList.get(0).getTrainingCourseId().get(), LocalDate.now())).
                getStatusOfBooking().equals(Constants.BOOKING_DONE));



    }
}
