package org.iesfm.instituto;

import java.util.Objects;

public class Group {

    private Integer id;
    private String course;
    private String letter;
    private Integer titleId;
    private int year;

    public Group(Integer id, String course, String letter, Integer titleId, int year) {
        this.id = id;
        this.course = course;
        this.letter = letter;
        this.titleId = titleId;
        this.year = year;
    }


    // getters setters hashCode equals toString

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id &&
                year == group.year &&
                Objects.equals(course, group.course) &&
                Objects.equals(letter, group.letter) &&
                Objects.equals(titleId, group.titleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course, letter, titleId, year);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", course='" + course + '\'' +
                ", letter='" + letter + '\'' +
                ", title='" + titleId + '\'' +
                ", year=" + year +
                '}';
    }
}
