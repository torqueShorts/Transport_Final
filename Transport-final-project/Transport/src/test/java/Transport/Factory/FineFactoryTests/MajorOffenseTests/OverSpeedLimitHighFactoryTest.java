package Transport.Factory.FineFactoryTests.MajorOffenseTests;

import Transport.Domain.Fines.Fine;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MajorOffenses.OverSpeedLimitHighFactory;
import org.junit.Assert;
import org.junit.Test;

public class OverSpeedLimitHighFactoryTest {

    @Test
    public void getOverSpeedLimit() {

        FineFactory fine = new FineFactory();

        int speedLimit = 60;
        int carSpeed = 110;
        String date = "20/04/2020";

        Fine value = fine.getFine("AR48752","BS238749584", "081556748", "MajorOffence", false);

        Assert.assertEquals("Vehicles License: BS238749584\nDrivers ID: 081556748\nType of offence: MajorOffence" +
                "\nFine Paid: false\nThe speed of the driver: 110\nThe speed limit of the road: 60\nCourt summons date: 20/04/2020",
                OverSpeedLimitHighFactory.getOverSpeedLimit(speedLimit, carSpeed, date, value).toString());

    }
}