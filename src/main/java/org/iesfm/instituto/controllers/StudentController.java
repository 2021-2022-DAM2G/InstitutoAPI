package org.iesfm.instituto.controllers;

import org.iesfm.instituto.Student;

import org.iesfm.instituto.services.HighSchool;

import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class StudentController {

    private HighSchool highSchool;

    public StudentController(HighSchool highSchool) {
        this.highSchool = highSchool;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/student")
    public List<Student> getStudents() {
        return highSchool.getStudents();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/student/{nif}")
    public Student getStudent(@PathVariable("nif") String nif) {
        return highSchool.getStudent(nif);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/student/{nif}")
    public void deleteStudent(@PathVariable("nif") String nif) {
        highSchool.deleteStudent(nif);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/student")
    public void addStudent(@RequestBody Student student) {
        highSchool.addStudent(student);
    }

}
