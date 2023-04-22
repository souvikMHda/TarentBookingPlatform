DROP TABLE IF EXISTS TRAINING_COURSE;
CREATE TABLE TRAINING_COURSE(
  TRAINING_COURSE_ID INT AUTO_INCREMENT  PRIMARY KEY,
  COURSE_NAME VARCHAR(250) DEFAULT NULL,
  INSTRUCTOR_NAME VARCHAR(250) DEFAULT NULL,
  DESCRIPTION VARCHAR(250) DEFAULT NULL,
  FEE DECIMAL DEFAULT 0.00,
  BOOKINGS_LEFT INT DEFAULT 10,
  TRAINING_DATE DATE
);

DROP TABLE IF EXISTS USER_INFO;
CREATE TABLE USER_INFO(
  USER_INFO_ID INT AUTO_INCREMENT PRIMARY KEY,
  EMAIL VARCHAR(250) DEFAULT NULL,
  PASSWORD VARCHAR(250) DEFAULT NULL,
  NAME VARCHAR(250) DEFAULT NULL,
  ROLE VARCHAR(250) DEFAULT 'ROLE_USER',
  CREATED_DATE DATE DEFAULT CURRENT_DATE
);

DROP TABLE IF EXISTS TRAINEE_INFO;
CREATE TABLE TRAINEE_INFO(
  TRAINEE_INFO_ID INT AUTO_INCREMENT PRIMARY KEY,
  TRAINING_COURSE_ID INT DEFAULT NULL,
  USER_INFO_ID INT DEFAULT NULL,
  ENROLLMENT_DATE DATE,
  FOREIGN KEY (TRAINING_COURSE_ID) REFERENCES TRAINING_COURSE(TRAINING_COURSE_ID),
  FOREIGN KEY (USER_INFO_ID) REFERENCES USER_INFO(USER_INFO_ID)
);
