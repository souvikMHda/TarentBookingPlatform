package com.tarent.trainingBookingPlatform.repository;

import com.tarent.trainingBookingPlatform.entity.TraineeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeInfoRepository extends JpaRepository<TraineeInfo, Long> {
}
