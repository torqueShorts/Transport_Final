package Transport.Factory.FineFactoryTests.MinorOffenseTests;

import Transport.Domain.Fines.Fine;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MinorOffenses.OverSpeedLimitLowFactory;
import org.junit.Assert;
import org.junit.Test;

public class OverSpeedLimitLowFactoryTest {

    @Test
    public void getOverSpeedLimitLow() {

        FineFactory fine = new FineFactory();

        int speedLimit = 60;
        int carSpeed = 80;
        int amount = 1500;

        Fine value = fine.getFine("AR36475","AC23898473", "084768532", "MinorOffence", false);

        Assert.assertEquals("Vehicles License: AC23898473\nDrivers ID: 084768532\nType of offence: MinorOffence" +
                "\nFine Paid: false\nThe speed of the driver: 80\nThe speed limit of the road: 60\nAmount due: 1500",
                OverSpeedLimitLowFactory.getOverSpeedLimitLow(speedLimit, carSpeed, amount, value).toString());
    }
}