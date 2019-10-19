package Transport.Factory.DepartmentFactoryTests;

import org.junit.Assert;
import org.junit.Test;

public class TrafficClerkFactoryTest {

    @Test
    public void getTrafficClerk()
    {
        String clerkID = "27772380";
        String name = "Jamie";
        String surname = "Storm";
        String fineCode = "RAR2345";
        boolean finePaid = true;

        Assert.assertEquals("Clerk ID: 27772380\nClerk name: Jamie\nClerk surname: Storm\nFine code: RAR2345\nFine Paid: true",
                TrafficClerkFactory.getTrafficClerk(clerkID, name, surname, fineCode, finePaid).toString());
    }
}