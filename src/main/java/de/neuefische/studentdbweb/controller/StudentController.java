package de.neuefische.studentdbweb.controller;

import de.neuefische.studentdbweb.model.Student;
import de.neuefische.studentdbweb.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService = new StudentService();

    @GetMapping
    public List<Student> listStudents(@RequestParam String firstLetter) {
        //if firstLetter is not empty
        if(!firstLetter.isEmpty()) {
            return studentService.list(firstLetter);
        } else {
            return studentService.list("");
        }
    }

    @GetMapping("{studentId}")
    public Student getStudent(@PathVariable String studentId) {
        Student findStudent = studentService.findById(studentId);
        return findStudent;
    }

}
