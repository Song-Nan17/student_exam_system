package tools;

import dao.StudentDao;
import dao.SubjectDao;
import dao.TeacherDao;
import model.Student;
import model.Subject;
import model.Teacher;
import service.StudentService;
import service.SubjectService;
import service.TeacherService;

public class DeleteTools {
    public static void deleteStudentById() {
        System.out.println("删除学生之后，该学生信息将不能恢复，是否要继续删除？\n" +
                "1. 是\n" +
                "2. 否");
        if (sureToDelete()) {
            System.out.println("请输入要删除的学生学号：");
            String id = Input.getInput();
            Student student = new StudentDao().selectStudentById(id);
            if (StudentService.isExist(student)) {
                new StudentDao().deleteStudentById(id);
                System.out.println("删除学生[" + student.getName() + student.getId() + "]成功！");
            } else {
                System.out.println("学生[学号" + id + "]不存在！");
            }
        }
    }

    public static void deleteSubjectById() {
        System.out.println("删除课程之后，该课程信息将不能恢复，是否要继续删除？\n" +
                "1. 是\n" +
                "2. 否");
        if (sureToDelete()) {
            System.out.println("请输入要删除的课程编号：");
            String id = Input.getInput();
            Subject subject = new SubjectDao().selectSubjectById(id);
            if (SubjectService.isExist(subject)) {
                new SubjectDao().deleteById(id);
                System.out.println("删除课程[" + subject.getName() + subject.getId() + "]成功！");
            } else {
                System.out.println("课程[编号" + id + "]不存在！");
            }
        }
    }

    public static void deleteTeacherById() {
        System.out.println("删除老师之后，该老师信息将不能恢复，是否要继续删除？\n" +
                "1. 是\n" +
                "2. 否");
        if (sureToDelete()) {
            System.out.println("请输入要删除的老师编号：");
            String id = Input.getInput();
            Teacher teacher = new TeacherDao().selectTeacherById(id);
            if (TeacherService.isExist(teacher)) {
                new TeacherDao().deleteById(id);
                System.out.println("删除老师[" + teacher.getName() + teacher.getId() + "]成功！");
            } else {
                System.out.println("课程[编号" + id + "]不存在！");
            }
        }
    }

    public static boolean sureToDelete() {
        return Input.getInput().equals("1");
    }
}
