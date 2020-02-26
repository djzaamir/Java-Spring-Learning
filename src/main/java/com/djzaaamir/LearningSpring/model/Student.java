package com.djzaaamir.LearningSpring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

        import java.util.UUID;

public class Student {

    //region VARS
    private UUID id;
    private final String name;
    private final int grade;
    //endregion

    public Student(
            @JsonProperty("id")    UUID id,
            @JsonProperty("name")  String name,
            @JsonProperty("grade") int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}
