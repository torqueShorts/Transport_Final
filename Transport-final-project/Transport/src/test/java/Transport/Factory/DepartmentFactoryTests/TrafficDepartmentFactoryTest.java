package Transport.Factory.DepartmentFactoryTests;

import org.junit.Assert;
import org.junit.Test;

public class TrafficDepartmentFactoryTest {

    @Test
    public void getTrafficDepartment() {

        String address = "62 Baker street, Tygerburg";
        String deptCode = "RED3249";

        Assert.assertEquals("Department address: 62 Baker street, Tygerburg\nDepartment code: RED3249",
                TrafficDepartmentFactory.getTrafficDepartment(address, deptCode).toString());

    }
}