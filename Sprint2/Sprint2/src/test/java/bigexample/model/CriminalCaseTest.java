package bigexample.model;

import fis.java.bigexample.model.CriminalCase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;

public class CriminalCaseTest {
    @Test
    public static List<CriminalCaseTest> creat3CriminalCases() {
        List<CriminalCase> criminalCaseList = new ArrayList<>();
        //Dummy Data
        CriminalCase criminal = new CriminalCase();
        criminal.setId(1L);
        criminal.setVersion(2);
        criminal.setCreatedAt(now());
        criminal.setModifiedAt(now());
        criminal.setNumber("02155454112");
        criminal.setType(null);


        criminalCaseList.add(criminal);

        return null;
    }


}
