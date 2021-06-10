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
                "SELECT * FROM student",
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
                "SELECT * FROM student where nif=:nif",
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
        return jdbcTemplate.query(
                "SELECT * FROM title",
                (rs, rowNum) ->
                        new Title(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("level"),
                                rs.getString("area"),
                                rs.getString("description")
                        )
        );
    }

    @Override
    public Title getTitle(int id) {
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject(
                "SELECT * FROM title where id=:id",
                params,
                (rs, rowNum) ->
                        new Title(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("level"),
                                rs.getString("area"),
                                rs.getString("description")
                        )
        );
    }

    @Override
    public void deleteTitle(int id) {
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update(
                "DELETE FROM title where id=:id",
                params
        );
    }

    @Override
    public void addTitle(Title title) {

    }

    @Override
    public List<Enrollment> getEnrollments() {

        return jdbcTemplate.query(
                "SELECT * FROM enrollment",
                (rs, rowNum) ->
                        new Enrollment(
                                rs.getInt("id"),
                                rs.getString("studentNif"),
                                rs.getInt("year"),
                                rs.getString("title"),
                                rs.getString("course"),
                                rs.getString("status")
                        )
        );
    }

    @Override
    public Enrollment getEnrollment(Integer id) {

        HashMap<String, Integer> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject(
                "SELECT * FROM enrollment where id=:id",
                params,
                (rs, rowNum) ->
                        new Enrollment(
                                rs.getInt("id"),
                                rs.getString("studentNif"),
                                rs.getInt("year"),
                                rs.getString("title"),
                                rs.getString("course"),
                                rs.getString("status")
                        )
        );
    }

    @Override
    public void deleteEnrollment(Integer id) {
        HashMap<String, Integer> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update(
                "DELETE FROM enrollment where id=:id",
                params
        );
    }

    @Override
    public void addEnrollment(Enrollment enrollment) {

        HashMap<String, Object> params = new HashMap<>();
        params.put("studentNif", enrollment.getStudentNif());
        params.put("year", enrollment.getYear());
        params.put("title", enrollment.getTitle());
        params.put("course", enrollment.getCourse());
        params.put("status", enrollment.getStatus());
        jdbcTemplate.update(
                "INSERT INTO enrollment (studentNif, year, title, course, status) VALUES (:studentNif, :year, :title, :course, :status)",
                params
        );
    }
}
