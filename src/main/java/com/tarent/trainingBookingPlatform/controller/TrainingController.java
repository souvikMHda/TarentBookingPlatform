package com.tarent.trainingBookingPlatform.controller;


import com.tarent.trainingBookingPlatform.dto.TrainingCourseDto;
import com.tarent.trainingBookingPlatform.dto.SavedTrainingCourseDto;
import com.tarent.trainingBookingPlatform.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class TrainingController {

    @Autowired
    TrainingService trainingService;

    @PostMapping("/createTraining")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<SavedTrainingCourseDto> createTraining(@RequestBody TrainingCourseDto trainingCourseDto){
        return trainingService.saveTrainingCourse(trainingCourseDto);
    }

    @PutMapping("/modifyTraining")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public SavedTrainingCourseDto modifyTraining(@RequestBody SavedTrainingCourseDto savedTrainingCourseDto){
        return trainingService.updateTrainingCourse(savedTrainingCourseDto.toEntity());
    }

}
