package model;

public class Teacher extends Person {
    public Teacher(String id, String name, int age, String sex) {
        super(id, name, age, sex);
    }

    @Override
    public String toString() {
        return "教师编号：" + this.getId() + ", 姓名：" + this.getName() +
                ", 年龄：" + this.getAge() + ", 性别：" + this.getSex();
    }
}
