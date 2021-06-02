package org.iesfm.instituto.services.inmemory;

import org.iesfm.instituto.Enrollment;
import org.iesfm.instituto.Group;
import org.iesfm.instituto.Student;
import org.iesfm.instituto.Title;
import org.iesfm.instituto.services.HighSchool;
import org.springframework.context.annotation.Bean;

import java.util.*;

public class InMemoryHighSchool implements HighSchool {

    private Map<Integer, Group> groups;
    private Map<String, Student> students;
    private Map<Integer, Title> titles;
    private List<Enrollment> enrollments;

    public InMemoryHighSchool() {
        groups = new HashMap<>();
        students = new HashMap<>();
        titles = new HashMap<>();
        enrollments = new LinkedList<>();
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = new LinkedList<>();
        students.addAll(this.students.values());
        return students;
    }

    @Override
    public Student getStudent(String nif) {
        return students.get(nif);
    }

    @Override
    public void deleteStudent(String nif) {
        students.remove(nif);
    }

    @Override
    public void addStudent(Student student) {
        students.put(student.getNif(), student);
    }
}
