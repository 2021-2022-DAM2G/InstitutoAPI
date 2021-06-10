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
                                rs.getString("student_name"),
                                rs.getString("student_surname"),
                                rs.getInt("zipcode"),
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
        Map<String, Object> params = new HashMap<>();

        params.put("nif", student.getNif());
        params.put("name", student.getName());
        params.put("surname", student.getSurname());
        params.put("zipCode", student.getZipCode());
        params.put("address", student.getAddress());
        params.put("email", student.getEmail());

        jdbcTemplate.update(
                "INSERT INTO titleGroup (nif, student_name, student_surname, zipcode, address, email)" +
                        "VALUES (:nif, :name, :surname, :zipCode, :address, :email)",
                params
        );
    }

    @Override
    public Group getGroup(int id) {
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject(
                "SELECT * FROM titleGroup where group_id=:id",
                params,
                (rs, rowNum) ->
                        new Group(
                                rs.getInt("group_id"),
                                rs.getString("class"),
                                rs.getString("grade"),
                                rs.getInt("title"),
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
                                rs.getInt("title"),
                                rs.getInt("groupYear")
                        )
        );
    }

    @Override
    public void deleteGroup(int id) {
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update(
                "DELETE FROM titleGroup where group_id=:id",
                params
        );
    }

    @Override
    public void addGroup(Group group) {
        Map<String, Object> params = new HashMap<>();

        params.put("class", group.getLetter());
        params.put("grade", group.getCourse());
        params.put("title", group.getTitleId());
        params.put("groupYear", group.getYear());

        jdbcTemplate.update(
                "INSERT INTO titleGroup (class, grade, title, groupYear) VALUES (:class, :grade, :title, :groupYear)",
                params
        );
    }

    @Override
    public List<Title> getTitles() {
        return jdbcTemplate.query(
                "SELECT * FROM title",
                (rs, rowNum) ->
                        new Title(
                                rs.getInt("title_id"),
                                rs.getString("title_name"),
                                rs.getString("title_level"),
                                rs.getString("family"),
                                rs.getString("title_description")
                        )
        );
    }

    @Override
    public Title getTitle(int id) {
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject(
                "SELECT * FROM title where title_id=:id",
                params,
                (rs, rowNum) ->
                        new Title(
                                rs.getInt("title_id"),
                                rs.getString("title_name"),
                                rs.getString("title_level"),
                                rs.getString("family"),
                                rs.getString("title_description")
                        )
        );
    }

    @Override
    public void deleteTitle(int id) {
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update(
                "DELETE FROM title where title_id=:id",
                params
        );
    }

    @Override
    public void addTitle(Title title) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", title.getName());
        params.put("level", title.getLevel());
        params.put("area", title.getArea());
        params.put("description", title.getDescription());
        jdbcTemplate.update(
                "INSERT INTO title (title_name, title_level, family, title_description) VALUES (:name, :level, :area, :description)",
                params
        );
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
