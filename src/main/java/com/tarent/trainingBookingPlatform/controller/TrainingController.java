package com.tarent.trainingBookingPlatform.controller;


import com.tarent.trainingBookingPlatform.dto.TrainingCourseDto;
import com.tarent.trainingBookingPlatform.dto.SavedTrainingCourseDto;
import com.tarent.trainingBookingPlatform.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class TrainingController {

    @Autowired
    TrainingService trainingService;

    /**
     * This method allows admin users to create training courses
     * @param trainingCourseDto information related to training courses
     * @return saved training course
     */
    @PostMapping("/createTraining")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    //@PreAuthorize("hasRole('ROLE_ADMIN') and #userId == authentication.principal.id")
    public ResponseEntity<List<SavedTrainingCourseDto>> createTraining(@RequestBody TrainingCourseDto trainingCourseDto){
        return new ResponseEntity<>(trainingService.saveTrainingCourse(trainingCourseDto), HttpStatus.CREATED);
    }

    /**
     * This method allows Admin users to modify an existing training course
     * @param savedTrainingCourseDto saved training course
     * @return modified/updated training course
     */
    @PutMapping("/modifyTraining")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<SavedTrainingCourseDto> modifyTraining(@RequestBody SavedTrainingCourseDto savedTrainingCourseDto){
        return new ResponseEntity<>(trainingService.updateTrainingCourse(savedTrainingCourseDto.toEntity()),HttpStatus.ACCEPTED);
    }

}
