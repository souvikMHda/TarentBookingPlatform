package com.tarent.trainingBookingPlatform.service;

import com.tarent.trainingBookingPlatform.dto.UserInfoDetail;
import com.tarent.trainingBookingPlatform.entity.UserInfo;
import com.tarent.trainingBookingPlatform.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByEmail(userEmail);
        return userInfo.map(UserInfoDetail::new).orElseThrow(
                ()-> new UsernameNotFoundException(userEmail + " Not Found"));
    }
}
