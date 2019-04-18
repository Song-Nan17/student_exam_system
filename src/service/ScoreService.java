package service;

import dao.ScoreDao;
import model.Score;

public class ScoreService {
    public static boolean isInsert(Score score) {
        ScoreDao scoreDao = new ScoreDao();
        return scoreDao.insertScore(score) == 1;
    }

    public static boolean isUpdate(Score score) {
        ScoreDao scoreDao = new ScoreDao();
        return scoreDao.update(score) > 0;
    }
}
