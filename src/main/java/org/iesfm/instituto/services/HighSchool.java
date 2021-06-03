package org.iesfm.instituto.services;

import org.iesfm.instituto.Group;
import org.iesfm.instituto.Student;
import org.iesfm.instituto.Title;

import java.util.List;

public interface HighSchool {

    List<Student> getStudents();

    Student getStudent(String nif);

    void deleteStudent(String nif);

    void addStudent(Student student);

    Group getGroup(int id);

    List<Group> getGroups();

    void deleteGroup(int id);

    void addGroup(Group group);

    List<Title> getTitles();

    Title getTitle(int id);

    void deleteTitle(int id);

    void addTitle(Title title);
}


