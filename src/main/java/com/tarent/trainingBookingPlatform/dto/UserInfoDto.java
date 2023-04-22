package com.tarent.trainingBookingPlatform.dto;

import com.tarent.trainingBookingPlatform.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfoDto {

    private Optional<Long> userId;

    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String name;

    @NotBlank
    @Email(message = "Invalid email address format")
    private String email;

    @NotEmpty
    @Size(min = 8, message = "password should have at least 8 characters")
    private String password;

    @Pattern(regexp = "ROLE_USER|ROLE_ADMIN", message = "Role must be either ROLE_USER or ROLE_ADMIN")
    private String role;

    private Optional<LocalDate> createdDate;

    public UserInfo toEntity(){
        return new UserInfo(this.userId.orElse(null),
                this.name, this.email, this.password, this.role, this.createdDate.orElse(null));
    }
}
