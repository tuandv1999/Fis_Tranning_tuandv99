package fis.java.bigexample.dao.criminal;

import fis.java.bigexample.dao.detective.DetectiveDAOMemImpl;
import fis.java.bigexample.model.CriminalCase;

public class DAOCriminal implements IDAOCriminal {
    private static DAOCriminal instance = new DAOCriminal();

    public static DAOCriminal getInstance(){
        return instance;
    }
    @Override
    public void add(CriminalCase criminalCase) {

    }

    @Override
    public CriminalCase remove(int code) {
        return null;
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase) {
        return null;
    }
}
