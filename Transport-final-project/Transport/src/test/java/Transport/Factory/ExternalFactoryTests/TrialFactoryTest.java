package Transport.Factory.ExternalFactoryTests;

import Transport.Factory.ExternalFactories.TrialFactory;
import org.junit.Assert;
import org.junit.Test;

public class TrialFactoryTest {

    @Test
    public void getTrial() {

        String trialID = "RD345";
        String date = "20/03/2019";
        String driverID = "08456789";
        String vehicleID = "AC2345678";

        Assert.assertEquals("Trial ID: RD345\nDate of Trial: 20/03/2019\nDrivers ID: 08456789\nVehicles ID: AC2345678",
                TrialFactory.getTrial(trialID,date,driverID,vehicleID).toString());

    }
}