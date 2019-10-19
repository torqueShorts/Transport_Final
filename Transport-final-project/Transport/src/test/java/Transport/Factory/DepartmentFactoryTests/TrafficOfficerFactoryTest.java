package Transport.Factory.DepartmentFactoryTests;

import org.junit.Assert;
import org.junit.Test;

public class TrafficOfficerFactoryTest {

    @Test
    public void getOfficer() {

        String officerID = "AC2D3D";
        String name = "Jeff";
        String surname = "Geff";
        String fineDue = "27/04/2019";
        String warrant = "2356789A";

        Assert.assertEquals("TrafficOfficer: " +
                "\nofficerID: AC2D3D" +
                "\nName: Jeff" +
                "\nSurname: Geff" +
                "\nFine Due: 27/04/2019" +
                "\nWarrant: 2356789A",
                TrafficOfficerFactory.getOfficer(officerID,name,surname,fineDue,warrant).toString());

    }
}