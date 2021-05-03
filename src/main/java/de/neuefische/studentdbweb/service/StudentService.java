package de.neuefische.studentdbweb.service;

import de.neuefische.studentdbweb.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class StudentService {

    private final List<Student> students = List.of(
            new Student("Hannah", "1"),
            new Student("Carl", "2"),
            new Student("Martin", "3")
    );

    public List<Student> list(String firstLetter) {
        List<Student> studentList = new ArrayList<>();
        if (firstLetter.isEmpty()) {
            return students;
        } else {
            for (Student student : students) {
                if (student.getName().toLowerCase(Locale.ROOT).startsWith(firstLetter.toLowerCase(Locale.ROOT))) {
                    studentList.add(student);
                }
            }
            return studentList;
        }
    }

    public Student findById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
                }
            }
            return null;
        }
    }

