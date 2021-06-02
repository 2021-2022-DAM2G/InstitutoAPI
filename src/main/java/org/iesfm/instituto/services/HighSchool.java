package org.iesfm.instituto.services;

import org.iesfm.instituto.Student;

import java.util.List;

public interface HighSchool {
    List<Student> getStudents();

    Student getStudent(String nif);

    void deleteStudent(String nif);

    void addStudent(Student student);
}
