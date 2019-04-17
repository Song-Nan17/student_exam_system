package model;

import java.util.List;

public class Subject {
    private String id;
    private String name;
    private Teacher teacher;
    private List<Score> scores;

    public Subject() {
    }

    public Subject(String id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    public Subject(String id, String name, Teacher teacher, List<Score> scores) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.scores = scores;
    }

    public List<Score> getScores() {
        return this.scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "课程编号：" + this.id + ", 课程名：" + this.name + ", 授课老师：" + this.teacher.getName();
    }
}
