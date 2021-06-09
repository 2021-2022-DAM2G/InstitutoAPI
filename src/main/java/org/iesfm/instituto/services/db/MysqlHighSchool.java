package org.iesfm.instituto.services.db;

import org.iesfm.instituto.Enrollment;
import org.iesfm.instituto.Group;
import org.iesfm.instituto.Student;
import org.iesfm.instituto.Title;
import org.iesfm.instituto.services.HighSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MysqlHighSchool implements HighSchool {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getStudents() {
        return jdbcTemplate.query(
                "select * from student",
                (rs, rowNum) ->
                        new Student(
                                rs.getString("nif"),
                                rs.getString("name"),
                                rs.getString("surname"),
                                rs.getInt("zipCode"),
                                rs.getString("address"),
                                rs.getString("email")
                        )
        );
    }

    @Override
    public Student getStudent(String nif) {
        Map<String, String> params = new HashMap<>();
        params.put("nif", nif);
        return jdbcTemplate.queryForObject(
                "select * from student where nif=:nif",
                params,
                (rs, rowNum) ->
                        new Student(
                                rs.getString("nif"),
                                rs.getString("name"),
                                rs.getString("surname"),
                                rs.getInt("zipCode"),
                                rs.getString("address"),
                                rs.getString("email")
                        )
        );
    }

    @Override
    public void deleteStudent(String nif) {
        Map<String, String> params = new HashMap<>();
        params.put("nif", nif);
        jdbcTemplate.update(
                "DELETE FROM student where nif=:nif",
                params
        );
    }

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public Group getGroup(int id) {
        return null;
    }

    @Override
    public List<Group> getGroups() {
        return null;
    }

    @Override
    public void deleteGroup(int id) {

    }

    @Override
    public void addGroup(Group group) {

    }

    @Override
    public List<Title> getTitles() {
        return null;
    }

    @Override
    public Title getTitle(int id) {
        return null;
    }

    @Override
    public void deleteTitle(int id) {

    }

    @Override
    public void addTitle(Title title) {

    }

    @Override
    public List<Enrollment> getEnrollments() {
        return null;
    }

    @Override
    public Enrollment getEnrollment(String studentNif) {
        return null;
    }

    @Override
    public void deleteEnrollment(String studentNif) {

    }

    @Override
    public void addEnrollment(Enrollment enrollment) {

    }
}
