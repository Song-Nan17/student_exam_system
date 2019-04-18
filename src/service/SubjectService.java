package service;

import dao.SubjectDao;
import model.Subject;

public class SubjectService {
    public static boolean isInsert(Subject subject) {
        SubjectDao subjectDao = new SubjectDao();
        return subjectDao.insertSubject(subject) == 1;
    }
}
