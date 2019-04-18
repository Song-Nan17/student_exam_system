package tools;

import model.Student;

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

    public static List<String> formatInput() {
        return Arrays.stream(getInput().split("，"))
                .map(s -> s.split("："))
                .flatMap(arr -> Arrays.stream(arr))
                .collect(Collectors.toList());
    }
}
