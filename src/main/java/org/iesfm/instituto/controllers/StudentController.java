package org.iesfm.instituto.controllers;

import org.iesfm.instituto.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @RequestMapping(method = RequestMethod.GET, path = "/student/{}")
    public List<Student> getStudents() {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/student/{nif}")
    public Student getStudent(@PathVariable("nif") String nif) {
        return new Student(nif, "Christian", "Bale", 12345, "c/Invent nº 1", "christianbale@gmail.com");
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/student/{nif}")
    public void deleteStudent(@PathVariable("nif") String nif) {
        System.out.println("Eliminado!");
    }

    @RequestMapping(method = RequestMethod.POST, path = "/student/{nif}")
    public void addStudent(){

    }

}
