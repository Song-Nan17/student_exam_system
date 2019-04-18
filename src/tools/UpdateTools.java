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

public class UpdateTools {
    public static void updateStudentById() {
        System.out.println("请输入要修改的学生学号：");
        String id = Input.getInput();
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.selectStudentById(id);
        if (StudentService.isExist(student)) {
            System.out.println("该生信息为：" + student);
            System.out.println("请输入修改后的学生信息(例如：学号：1001，姓名： 小明，年龄： 18，性别： 男)：");
            Student newStudent = Input.generateStudentByInput();
            if (StudentService.isUpdate(newStudent)) {
                System.out.println("学生[" + student.getName() + student.getId() + "]的信息修改成功！");
            } else {
                System.out.println("学生信息修改失败！");
            }
        } else {
            System.out.println("学生[学号：" + id + "]不存在！");
        }
    }

    public static void updateSubjectById() {
        System.out.println("请输入要修改的课程编号：");
        String id = Input.getInput();
        SubjectDao subjectDao = new SubjectDao();
        Subject subject = subjectDao.selectSubjectById(id);
        if (SubjectService.isExist(subject)) {
            System.out.println("该课程信息为：" + subject);
            System.out.println("请输入修改后的课程信息(例如：课程编号：3，课程名：英语，授课老师编号：4)：");
            Subject newSubject = Input.generateSubjectByInput();
            if (SubjectService.isUpdate(newSubject)) {
                System.out.println("课程[" + subject.getName() + subject.getId() + "]的信息修改成功！");
            } else {
                System.out.println("课程信息修改失败！");
            }
        } else {
            System.out.println("课程[编号：" + id + "]不存在");
        }
    }

    public static void updateTeacherById() {
        System.out.println("请输入要修改的老师的编号：");
        String id = Input.getInput();
        TeacherDao teacherDao = new TeacherDao();
        Teacher teacher = teacherDao.selectTeacherById(id);
        if (TeacherService.isExist(teacher)) {
            System.out.println("该老师的信息为：" + teacher);
            System.out.println("请输入修改后的老师信息(例如：老师编号：5，姓名：强哥，年龄：33，性别：男)：");
            Teacher newTeacher = Input.generateTeacherByInput();
            if (TeacherService.isUpdate(newTeacher)) {
                System.out.println("老师[" + teacher.getName() + teacher.getId() + "]的信息修改成功！");
            } else {
                System.out.println("老师信息修改失败！");
            }
        } else {
            System.out.println("老师[编号：" + id + "]不存在！");
        }
    }
}
