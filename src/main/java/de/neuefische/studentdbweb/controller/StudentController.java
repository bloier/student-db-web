package de.neuefische.studentdbweb.controller;

import de.neuefische.studentdbweb.model.Student;
import de.neuefische.studentdbweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> listStudents(@RequestParam Optional<String> firstLetter) {
        //if firstLetter is not empty
        if(firstLetter.isPresent()) {
            return studentService.list(firstLetter.get());
        } else {
            return studentService.list("");
        }
    }

    @GetMapping("{studentId}")
    public Student getStudentById(@PathVariable String studentId) {
        Student findStudent = studentService.findById(studentId);
        return findStudent;
    }

    @PutMapping("{studentId}")
    public Student addStudent(@PathVariable String studentId, @Valid @RequestBody Student student) {
        for (Student tempStudent : studentService.list("")) {
            if(studentId.equals(tempStudent.getStudentId())) {
                tempStudent.setStudentId(studentId);
                tempStudent.setName(student.getName());
            }
        }
        if(!studentId.equals(student.getStudentId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id not matching");
        }
        return studentService.addStudent(student);
    }

}
