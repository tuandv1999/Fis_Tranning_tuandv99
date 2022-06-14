package fis.java.bigexample.dao.jdbc;

import fis.java.bigexample.dao.criminal.IDAOCriminalCase;
import fis.java.bigexample.model.CriminalCase;
import org.junit.jupiter.api.Test;

import java.util.List;


class JDBCCriminalCaseDAOTest {

    @Test
    void getAll() {
        //A1
        IDAOCriminalCase criminalCaseDAO = new JDBCCriminalCaseDAO();

        //A2
        List<CriminalCase> criminalCaseList = criminalCaseDAO.getAll();

        //A3: Assert
        System.out.println(criminalCaseList);
    }
}