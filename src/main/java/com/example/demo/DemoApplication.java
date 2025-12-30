package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import entity.UserProfile;
import entity.SkillGap;
import entity.UserSkill;
import newentity.DailyProgress;
import newentity.WeeklyPlan;
import com.demo.project.dto.ApiResponse;
import com.demo.project.dto.SecurityConfig;
@SpringBootApplication
@EntityScan(basePackageClasses = {UserProfile.class, SkillGap.class, UserSkill.class, WeeklyPlan.class, DailyProgress.class,ApiResponse.class,SecurityConfig.class})
@ComponentScan(basePackages = {"com.example.demo", "Controller", "service", "repository", "entity", "Priority", "SkillLevel","com.demo.project.dto","com.demo.project.dto"})
@EnableJpaRepositories(basePackages = "repository")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
