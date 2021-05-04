package de.neuefische.studentdbweb.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Student {
    @Size(min =2, max =20, message = "student name is required")
    private String name;
    @NotBlank(message = "student ID is required")
    private String studentId;

    public Student (String name, String studentId){
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
