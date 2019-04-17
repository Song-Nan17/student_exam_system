package model;

import java.util.List;

public class Student extends Person {
    private List<Score> scores;

    public Student() {
    }

    public Student(String id, String name, int age, String sex) {
        super(id, name, age, sex);
    }

    public Student(String id, String name, int age, String sex, List<Score> scores) {
        super(id, name, age, sex);
        this.scores = scores;
    }

    public List<Score> getScores() {
        return this.scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "学号：" + this.getId() + "，姓名： " + this.getName() +
                ", 年龄： " + this.getAge() + ", 性别： " + this.getSex();
    }
}
