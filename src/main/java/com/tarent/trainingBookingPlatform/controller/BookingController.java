package com.tarent.trainingBookingPlatform.controller;

import com.tarent.trainingBookingPlatform.dto.*;
import com.tarent.trainingBookingPlatform.service.BookingService;
import com.tarent.trainingBookingPlatform.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class BookingController {

    @Autowired
    TrainingService trainingService;

    @Autowired
    BookingService bookingService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * This method gets all the training courses between the start date and the end date
     * @param startDate is the starting date from which courses are to be fetched
     * @param endDate is the end date till which courses are to be fetched
     * @return the saved training course
     */
    @GetMapping("/get")
    public ResponseEntity<List<SavedTrainingCourseDto>> getTrainingCoursesByDateRange
            (@RequestParam("start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
             @RequestParam("end_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return new ResponseEntity<>(trainingService.getListOfTrainings(startDate, endDate),HttpStatus.OK);
    }

    /**
     * This method allows user to be added
     * @param userInfoDto has the attributes pertaining to the user
     * @return added user.
     * This method should ideally create a JWT token for the user
     */
    @PostMapping("/addUser")
    public ResponseEntity<UserInfoDto> addUser(@Valid @RequestBody UserInfoDto userInfoDto){
        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
        return ResponseEntity.ok().body(trainingService.saveUserInfo(userInfoDto).toDto());
    }

    /**
     * This method allows user to book a training
     * @param userTrainingDto contains the course ID, the userDate and the date on
     *                        which the user is getting enrolled on
     * @return the booking confirmation status
     */
    @PostMapping("/book")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<CourseBookingStatus> bookTraining(@Valid @RequestBody UserTrainingDto userTrainingDto){
        return new ResponseEntity<>(bookingService.bookCourse(userTrainingDto),HttpStatus.OK);
    }


}
