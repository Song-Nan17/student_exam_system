package model;

import java.util.List;

public class Teacher extends Person {
    private List<Subject> subjects;

    public Teacher() {
    }

    public Teacher(String id, String name, int age, String sex) {
        super(id, name, age, sex);
    }

    public Teacher(String id, String name, int age, String sex, List<Subject> subjects) {
        super(id, name, age, sex);
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "教师编号：" + this.getId() + ", 姓名：" + this.getName() +
                ", 年龄：" + this.getAge() + ", 性别：" + this.getSex();
    }
}
