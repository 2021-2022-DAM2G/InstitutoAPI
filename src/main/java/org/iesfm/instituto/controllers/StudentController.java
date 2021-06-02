package org.iesfm.instituto.controllers;

import org.iesfm.instituto.Student;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class StudentController {

    @RequestMapping(method = RequestMethod.GET, path = "/student")
    public List<Student> getStudents() {
        List<Student> students = new LinkedList<>();
        students.add(new Student("11111111A", "Christian", "Bale", 12345, "c/Invent nº 1", "christianbale@gmail.com"));
        return students;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/student/{nif}")
    public Student getStudent(@PathVariable("nif") String nif) {
        return new Student(nif, "Christian", "Bale", 12345, "c/Invent nº 1", "christianbale@gmail.com");
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/student/{nif}")
    public void deleteStudent(@PathVariable("nif") String nif) {
        System.out.println("El estudiante con nif: " + nif + " se ha añadido con éxito");
    }

    @RequestMapping(method = RequestMethod.POST, path = "/student/{nif}")
    public void addStudent(@RequestBody Student student){

    }

}
