package bigexample.model;

import fis.java.bigexample.model.Detective;
import fis.java.bigexample.model.Person;
import fis.java.bigexample.model.enums.EmploymentStatus;
import fis.java.bigexample.model.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetectiveTest {

    @Test
    public void testConstructor(){
        //Arrange
        Detective detective = new Detective(1L, null, "1", Rank.TRANEE, true,
                EmploymentStatus.ACTIVE);

        //Action
        long id = detective.getId();

        //Assert
        assertEquals(1L, id);
    }

    public static List<Detective> create3Detective(){
        List<Detective> detectiveList = new ArrayList<>();
        //Dummy Data
        Person person = new Person();
        person.setUserName("phuocnt");
        person.setFirstName("Phuoc");
        person.setLastName("Nguyen Thanh");

        Detective detective = new Detective(1L, person, "1", Rank.TRANEE, true,
                EmploymentStatus.ACTIVE);


        detectiveList.add(detective);

        return detectiveList;
    }
}