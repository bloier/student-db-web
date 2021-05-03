package de.neuefische.studentdbweb.model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @GetMapping
    public List<Student> getStudent() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Hannah"));
        studentList.add(new Student("Carl"));
        studentList.add(new Student("Martin"));
        return studentList;
    }

}
