package org.iesfm.instituto;

import java.util.Objects;

public class Group {

    private String course;
    private String letter;
    private String title;
    private int year;

    public Group(String course, String letter, String title, int year) {
        this.course = course;
        this.letter = letter;
        this.title = title;
        this.year = year;
    }


    // getters setters hashCode equals toString

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return year == group.year &&
                Objects.equals(course, group.course) &&
                Objects.equals(letter, group.letter) &&
                Objects.equals(title, group.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, letter, title, year);
    }

    @Override
    public String toString() {
        return "Group{" +
                "course='" + course + '\'' +
                ", letter='" + letter + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
