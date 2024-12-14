package com.netwizsoft.spring_batch_process.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student_details")
@Getter
@Setter
public class StudentDetails {

    @Id
    private String id;

    @JsonProperty("user_id")
    private int userId;

    private String gender;

    private int age;

    private String city;

    private String profession;

    @JsonProperty("academic_pressure")
    private double academicPressure;

    @JsonProperty("work_pressure")
    private double workPressure;

    private double cgpa;

    @JsonProperty("study_satisfaction")
    private double studySatisfaction;

    @JsonProperty("job_satisfaction")
    private double jobSatisfaction;

    @JsonProperty("sleep_duration")
    private String sleepDuration;

    @JsonProperty("dietary_habits")
    private String dietaryHabits;

    private String degree;

    @JsonProperty("suicide_thoughts")
    private String suicideThoughts;

    @JsonProperty("study_hours")
    private double studyHours;

    @JsonProperty("financial_stress")
    private double financialStress;

    @JsonProperty("mental_illeness")
    private String mentalIlleness;

    private double depression;
}
