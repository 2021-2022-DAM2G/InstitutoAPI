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
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject(
                "SELECT * FROM titleGroup where id=:id",
                params,
                (rs, rowNum) ->
                        new Group(
                                rs.getInt("group_id"),
                                rs.getString("class"),
                                rs.getString("grade"),
                                rs.getString("title"),
                                rs.getInt("groupYear")
                        )
        );
    }

    @Override
    public List<Group> getGroups() {
        return jdbcTemplate.query(
                "SELECT * FROM titleGroup",
                (rs, rowNum) ->
                        new Group(
                                rs.getInt("group_id"),
                                rs.getString("class"),
                                rs.getString("grade"),
                                rs.getString("title"),
                                rs.getInt("groupYear")
                        )
        );
    }

    @Override
    public void deleteGroup(int id) {
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update(
                "DELETE FROM titleGroup where nif=:nif",
                params
        );
    }

    @Override
    public void addGroup(Group group) {
        Map<String, Group> params = new HashMap<>();
        params.put("group", group);
        jdbcTemplate.update(
                "INSERT INTO title VALUES (:group_id, :class, :grade, :title, :groupYear)",
                params
        );
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
                "SELECT * FROM Enrollment",
                (rs, rowNum) ->
                        new Enrollment(
                                rs.getString("studentNif"),
                                rs.getInt("year"),
                                rs.getString("title"),
                                rs.getString("course"),
                                rs.getString("status")
                        )
        );
    }

    @Override
    public Enrollment getEnrollment(String studentNif) {

        HashMap<String, String> params = new HashMap<>();
        params.put("studentNif", studentNif);
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Enrollment where studentNif=:studentNif",
                params,
                (rs, rowNum) ->
                        new Enrollment(
                                rs.getString("studentNif"),
                                rs.getInt("year"),
                                rs.getString("title"),
                                rs.getString("course"),
                                rs.getString("status")
                        )
        );
    }

    @Override
    public void deleteEnrollment(String studentNif) {
        HashMap<String, String> params = new HashMap<>();
        params.put("studentNif", studentNif);
        jdbcTemplate.update(
                "DELETE FROM Enrollment where studentNif=:studentNif",
                params
        );
    }

    @Override
    public void addEnrollment(Enrollment enrollment) {

    }
}
