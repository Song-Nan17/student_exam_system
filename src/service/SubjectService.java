package service;

import model.Subject;

import java.util.List;

public class SubjectService {
    public static boolean isExist(List<Subject> subjects) {
        return subjects.size() > 0;
    }

    public static boolean isExist(Subject subject) {
        return subject.getName() != null;
    }
}
