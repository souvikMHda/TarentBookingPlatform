package com.tarent.trainingBookingPlatform.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name="ADMIN_USER")
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ADMIN_USER_ID")
    Long adminUserId;

    @Column(name="NAME")
    String name;

    @Column(name="EMAIL")
    String email;

    @Column(name="CREATED_DATE")
    LocalDate createdDate;
}
