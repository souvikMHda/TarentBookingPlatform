package com.tarent.trainingBookingPlatform.entity;


import com.tarent.trainingBookingPlatform.dto.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="USER_INFO")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_INFO_ID")
    Long userId;

    @Column(name="NAME")
    String name;

    @Column(name="EMAIL")
    String email;

    @Column(name="PASSWORD")
    String password;

    @Column(name="ROLE")
    String role;

    @Column(name="CREATED_DATE")
    LocalDate createdDate;

    public UserInfoDto toDto(){
        return new UserInfoDto(
                Optional.of(this.userId),
                this.name,this.email,this.password,this.role, Optional.of(this.createdDate));
    }
}
