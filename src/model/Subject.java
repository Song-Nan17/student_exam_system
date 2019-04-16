package model;

public class Subject {
    private String id;
    private String subject;
    private String teacher;

    public Subject(String id, String subject, String teacher) {
        this.id = id;
        this.subject = subject;
        this.teacher = teacher;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "课程编号：" + this.id + ", 课程名：" + this.subject + ", 授课老师：" + this.teacher;
    }
}
