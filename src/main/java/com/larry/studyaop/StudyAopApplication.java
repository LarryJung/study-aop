package com.larry.studyaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@SpringBootApplication
public class StudyAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyAopApplication.class, args);
	}
}
