package Transport.Factory.ExternalFactoryTests;

import Transport.Factory.ExternalFactories.WarrantFactory;
import org.junit.Assert;
import org.junit.Test;

public class WarrantFactoryTest {

    @Test
    public void getWarrant() {

        String warrantID = "VNT3847";
        String driverID = "08145896";
        String vehicleID = "AC239034";
        boolean actiive = true;

        Assert.assertEquals("Warrant ID: VNT3847\nDrivers ID: 08145896\nVehicles License: AC239034\nWarrant valid: true",
                WarrantFactory.getWarrant(warrantID, driverID,vehicleID,actiive).toString());


    }
}