package fis.java.bigexample.dao.criminal;

import fis.java.bigexample.dao.MemoryDataSource;
import fis.java.bigexample.model.CriminalCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class DAOCriminalCaseTest {

    public static Logger LOG = LoggerFactory.getLogger(DAOCriminalCase.class);

    @BeforeEach
    public void initTest(){
        LOG.info("initTest");
    }
    @BeforeEach
    public void initDataEachTest(){
        LOG.info("initDataEachTest");
        MemoryDataSource.CRIMINAL_CASES.clear();
        CriminalCase criminalCase1  = new CriminalCase();
        criminalCase1.setId(1);
        CriminalCase criminalCase2  = new CriminalCase();
        criminalCase2.setId(2);
        CriminalCase criminalCase3  = new CriminalCase();
        criminalCase3.setId(3);

        MemoryDataSource.CRIMINAL_CASES.add(criminalCase1);
        MemoryDataSource.CRIMINAL_CASES.add(criminalCase2);
        MemoryDataSource.CRIMINAL_CASES.add(criminalCase3);
    }

    @Test
    void save_CriminalCaseNotExits() {
        //A1: Arrange
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(4);
        criminalCase.setNumber("0001");
        // init data
        // ...
        //A2: Action
        int before = MemoryDataSource.CRIMINAL_CASES.size();
        IDAOCriminalCase iCriminalCaseDAO = new DAOCriminalCase() {
        };
        iCriminalCaseDAO.save(criminalCase);
        //A3: Assert
        assertEquals(4, MemoryDataSource.CRIMINAL_CASES.size());


    }

    @Test
    void save_CriminalCaseExits() {
        CriminalCase criminalCase = new CriminalCase();

        //A1
        criminalCase = new CriminalCase();
        criminalCase.setId(1);
        criminalCase.setNumber("0001");

        //A2
        IDAOCriminalCase iCriminalCaseDAO = new DAOCriminalCase();
        iCriminalCaseDAO.save(criminalCase);

        //A3
        assertEquals(4,MemoryDataSource.CRIMINAL_CASES.size());
    }
    @Test
    void get() {
        LOG.info("test get");
    }

    @Test
    void getAll(

    ) {
        List<CriminalCase> actual=MemoryDataSource.CRIMINAL_CASES;
        CriminalCase criminalCase1=new CriminalCase();
        criminalCase1.setId(1);
        CriminalCase criminalCase2=new CriminalCase();
        criminalCase2.setId(2);
        CriminalCase criminalCase3=new CriminalCase();
        criminalCase3.setId(3);

        
    }

    @Test
    void update() {
        LOG.info("test update");
    }

    @Test
    void delete() {
        LOG.info("test delete");
    }

    @AfterEach
    public void clearDataEachTest() {
        LOG.info("clearDataEachTest");
    }

    @AfterAll
    public static void clearTest(){
        LOG.info("clearTest");
    }
}