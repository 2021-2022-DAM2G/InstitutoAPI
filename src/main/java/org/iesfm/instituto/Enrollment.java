package org.iesfm.instituto;

import java.util.Objects;

public class Enrollment {

    public static final String ACCEPTED = "Accepted";
    public static final String DENIED = "Denied";
    public static final String INPROCESS = "In process";

    private String studentNif;
    private int year;
    private String title;
    private String course;
    private String status;

    public Enrollment(String studentNif, int year, String title, String course, String status) {
        this.studentNif = studentNif;
        this.year = year;
        this.title = title;
        this.course = course;
        this.status = status;
    }


    // getters setters hashCode equals toString

    public String getStudentNif() {
        return studentNif;
    }

    public void setStudentNif(String studentNif) {
        this.studentNif = studentNif;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return year == that.year &&
                Objects.equals(studentNif, that.studentNif) &&
                Objects.equals(title, that.title) &&
                Objects.equals(course, that.course) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNif, year, title, course, status);
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "studentNif='" + studentNif + '\'' +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", course='" + course + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
