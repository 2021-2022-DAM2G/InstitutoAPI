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
        groups.put(1, new Group(1, "1ºDAM", "C", "DAM", 2020));
        students = new HashMap<>();
        students.put("234343434F", new Student("234343434F", "Mikel", "San Vicente", 34234, "Calle falsa", "mikelsa@gmsdf.domc"));
        titles = new HashMap<>();
        titles.put(1, new Title(1, "DAM", Title.GS, Title.IT, "descripcion"));
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

    @Override
    public List<Group> getGroups() {
        List<Group> groups = new LinkedList<>();
        groups.addAll(this.groups.values());
        return groups;
    }

    @Override
    public Group getGroup(int id) {
        return groups.get(id);
    }

    @Override
    public void deleteGroup(int id) {
        groups.remove(id);
    }

    @Override
    public void addGroup(Group group) {
        groups.put(group.getId(), group);
    }

    @Override
    public List<Title> getTitles() {
        List<Title> titles = new LinkedList<>();
        titles.addAll(this.titles.values());
        return titles;
    }

    @Override
    public Title getTitle(int id) {
        return titles.get(id);
    }

    @Override
    public void deleteTitle(int id) {
        titles.remove(id);
    }

    @Override
    public void addTitle(Title title) {
        titles.put(title.getId(), title);
    }

    @Override
    public List<Enrollment> getEnrollments() {
        return this.enrollments;
    }

    @Override
    public Enrollment getEnrollment(String studentNif) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentNif().equals(studentNif)) {
                return enrollment;
            }
        }
        return null;
    }

    @Override
    public void deleteEnrollment(String studentNif) {
        enrollments.remove(getEnrollment(studentNif));
    }

    @Override
    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }
}
