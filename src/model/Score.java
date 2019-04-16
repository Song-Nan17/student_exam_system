package model;

public class Score {
    private String student;
    private String subject;
    private double score;

    public Score(String student, String subject, double score) {
        this.student = student;
        this.subject = subject;
        this.score = score;
    }

    public String getStudent() {
        return this.student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
