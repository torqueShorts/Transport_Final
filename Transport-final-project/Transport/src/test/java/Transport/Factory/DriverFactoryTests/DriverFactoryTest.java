package Transport.Factory.DriverFactoryTests;

import Transport.Factory.DriversFactories.DriverFactory;
import org.junit.Assert;
import org.junit.Test;

public class DriverFactoryTest {

    @Test
    public void getDriver() {


        String driverID = "08456789";
        String vehLicense = "AC23647";
        boolean international = false;


        Assert.assertEquals("Drivers ID: 08456789\nVehicles license: AC23647\nInternational: false",
                DriverFactory.getDriver(driverID,vehLicense,international).toString());
    }
}