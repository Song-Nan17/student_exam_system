package tools;

import dao.StudentDao;
import model.Student;
import service.StudentService;

public class DeleteTools {
    public static void deleteStudentById() {
        System.out.println("删除学生之后，该学生信息将不能恢复，是否要继续删除？\n" +
                "1. 是\n" +
                "2. 否");
        if (sureToDelet()) {
            System.out.println("请输入要删除的学生学号：");
            String id = Input.getInput();
            Student student = new StudentDao().selectStudentById(id);
            if (StudentService.isExist(student)) {
                StudentDao studentDao = new StudentDao();
                studentDao.deleteStudentById(id);
                System.out.println("删除学生[" + student.getName() + student.getId() + "]成功！");
            } else {
                System.out.println("学生[学号" + id + "]不存在！");
            }
        }
    }

    public static boolean sureToDelet() {
        return Input.getInput().equals("1");
    }


}
