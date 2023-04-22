package com.tarent.trainingBookingPlatform.repository;

import com.tarent.trainingBookingPlatform.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
    Optional<UserInfo> findByEmail(String email);
}
