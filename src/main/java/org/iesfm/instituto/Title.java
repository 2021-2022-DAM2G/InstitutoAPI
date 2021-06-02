package org.iesfm.instituto;

import java.util.Objects;

public class Title {

    // level constants
    public static final String GS = "GS";
    public static final String GM = "GM";
    public static final String FPB = "FPB";

    // area constants
    public static final String IT = "IT";
    public static final String MECHANICS = "Mechanics";
    public static final String ADMINISTRATION = "Administration";

    private int id;
    private String name;
    private String level;
    private String area;
    private String description;

    public Title(int id, String name, String level, String area, String description) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.area = area;
        this.description = description;
    }

    // getters setters hashCode equals toString

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return id == title.id &&
                Objects.equals(name, title.name) &&
                Objects.equals(level, title.level) &&
                Objects.equals(area, title.area) &&
                Objects.equals(description, title.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, level, area, description);
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", area='" + area + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
