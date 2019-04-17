package model;

public class Score {
    private Student student;
    private Subject subject;
    private double score;

    public Score() {
    }

    public Score(Subject subject, double score) {
        this.subject = subject;
        this.score = score;
    }

    public Score(Student student, Subject subject, double score) {
        this.student = student;
        this.subject = subject;
        this.score = score;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return this.subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
