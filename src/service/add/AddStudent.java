package service.add;

import model.Student;
import tools.Input;

import java.util.Arrays;
import java.util.List;

public class AddStudent {
    public static void add() {
        System.out.println("请输入学生信息(例如：学号：1001，姓名： 小明, 年龄： 18, 性别： 男)：");
        String input = Input.getInput();

    }

    public static Student getNewStudent(String input) {
        List<String> inputs = Arrays.asList(input.split("，"));
        inputs.stream().map(str -> str.split("： ")).toArray();
        String id = inputs.get(inputs.indexOf("学号") + 1);
        String name = inputs.get(inputs.indexOf("姓名") + 1);
        int age = Integer.parseInt(inputs.get(inputs.indexOf("姓名") + 1));
        String sex = inputs.get(inputs.indexOf("性别") + 1);
        return new Student(id, name, age, sex);
    }
}
