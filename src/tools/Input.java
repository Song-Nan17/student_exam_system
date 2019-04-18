package tools;

import model.Student;
import model.Subject;
import model.Teacher;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {
    public static String getInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static String[] formatLoginInput() {
        return getInput().split(":");
    }

    public static Student generateStudentByInput() {
        List<String> infos = formatInput();
        String id = infos.get(infos.indexOf("学号") + 1);
        String name = infos.get(infos.indexOf("姓名") + 1);
        int age = Integer.parseInt(infos.get(infos.indexOf("年龄") + 1));
        String sex = infos.get(infos.indexOf("性别") + 1);
        return new Student(id, name, age, sex);
    }

    public static Subject generateSubjectByInput() {
        List<String> infos = formatInput();
        String id = infos.get(infos.indexOf("课程编号") + 1);
        String name = infos.get(infos.indexOf("课程名") + 1);
        String teacherId = infos.get(infos.indexOf("授课老师编号") + 1);
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        return new Subject(id, name, teacher);
    }

    public static List<String> formatInput() {
        return Arrays.stream(getInput().split("，"))
                .map(s -> s.split("："))
                .flatMap(arr -> Arrays.stream(arr))
                .collect(Collectors.toList());
    }
}
