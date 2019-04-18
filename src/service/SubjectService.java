package service;

import dao.SubjectDao;
import model.Subject;

import java.util.List;

public class SubjectService {
    public static boolean isExist(List<Subject> subjects) {
        return subjects.size() > 0;
    }

    public static boolean isInsert(Subject subject) {
        SubjectDao subjectDao = new SubjectDao();
        return subjectDao.insertSubject(subject) == 1;
    }
}
