package service.query;

import dao.Select;
import model.Score;
import tools.Input;

import java.sql.SQLException;
import java.util.List;

public class QueryScore {
    public static void queryByStudent(String name) throws SQLException {
        String sql = "SELECT s4.name, s3.subject, s1.score FROM score_sheet AS s1 \n" +
                "LEFT JOIN exam AS s2 ON s2.id = s1.exam_id\n" +
                "LEFT JOIN subject AS s3 ON s3.id = s2.subject\n" +
                "LEFT JOIN student AS s4 ON s4.stu_id=s1.stu_id\n" +
                "WHERE s4.name = \"" + name + "\";";
        Select select = new Select();
        List<Score> scores = select.selectScores(sql);
        System.out.println(name + "的各科成绩为：");
        scores.forEach(score ->
                System.out.println("科目：" + score.getSubject() + ", 成绩：" + score.getScore()));
    }

    public static void queryByTeacher() throws SQLException {
        System.out.println("请输入老师姓名：");
        String name = Input.getInput();
        String sql = "SELECT s2.name, s4.subject, s1.score FROM score_sheet AS s1 \n" +
                "LEFT JOIN student AS s2 ON s2.stu_id=s1.stu_id\n" +
                "LEFT JOIN exam AS s3 ON s3.id = s1.exam_id\n" +
                "LEFT JOIN subject AS s4 ON s4.id = s3.subject\n" +
                "LEFT JOIN teacher AS s5 ON s5.id = s4.teacher\n" +
                "WHERE s5.name = \"" + name + "\";";
        Select select = new Select();
        List<Score> scores = select.selectScores(sql);
        System.out.println(name + "的所有学生及其成绩为：");
        scores.forEach(score ->
                System.out.println("学生：" + score.getStudent() + ", 成绩：" + score.getScore()));
    }
}
