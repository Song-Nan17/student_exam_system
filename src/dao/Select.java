package dao;

import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Select {
    final ConnectMySql connectMySql = new ConnectMySql();
    final Connection connection = connectMySql.getConnect();
    final Statement statement = connectMySql.getStatement(connection);

    public Account selectAdministrator(String sql) throws SQLException {
        ResultSet resultSet = connectMySql.executeSQL(statement, sql);
        String id = "";
        String password = "";
        while (resultSet.next()) {
            id = resultSet.getString("id");
            password = resultSet.getString("password");
        }
        connectMySql.closeConnect(resultSet, statement, connection);
        return new Account(id, password);
    }

    public void selectPerson(String sql) throws SQLException {
        List<Person> people = new ArrayList<>();
        ResultSet resultSet = connectMySql.executeSQL(statement, sql);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String sex = resultSet.getString("sex");
            if (sql.contains("student")) {
                people.add(new Student(id, name, age, sex));
            } else if (sql.contains("teacher")) {
                people.add(new Teacher(id, name, age, sex));
            }
        }
        people.forEach(person -> System.out.println(person.toString())
        );
        connectMySql.closeConnect(resultSet, statement, connection);
    }

    public List<Score> selectScores(String sql) throws SQLException {
        List<Score> scores = new ArrayList<>();
        ResultSet resultSet = connectMySql.executeSQL(statement, sql);
//        while (resultSet.next()) {
//            String name = resultSet.getString("name");
//            String subject = resultSet.getString("subject");
//            double score = resultSet.getDouble("score");
//            scores.add(new Score(name, subject, score));
//        }
        connectMySql.closeConnect(resultSet, statement, connection);
        return scores;
    }

    public void selectSubject(String sql) throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        ResultSet resultSet = connectMySql.executeSQL(statement, sql);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String subject = resultSet.getString("subject");
            String teacher = resultSet.getString("teacher");
//            subjects.add(new Subject(id, subject, teacher));
        }
        subjects.forEach(subject -> System.out.println(subject.toString()));
        connectMySql.closeConnect(resultSet, statement, connection);
    }

}
