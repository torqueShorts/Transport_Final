package Transport.Factory.DriverFactoryTests;

import Transport.Domain.Drivers.Driver;
import Transport.Factory.DriversFactories.DriverFactory;
import Transport.Factory.DriversFactories.InternationalDriverFactory;
import org.junit.Assert;
import org.junit.Test;

public class InternationalDriverFactoryTest {

    @Test
    public void getInternationalDriver() {

        DriverFactory drive = new DriverFactory();

        String name = "Kyle";
        String surname = "Storm";
        String dateOfBirth = "13/04/1994";
        boolean vehOwned = true;
        Driver value = drive.getDriver("08123456784", "AC2343765", true);

        Assert.assertEquals("International Drivers: \nDrivers ID: 08123456784\nDrivers name: Kyle\nDrivers surname: Storm\nDrivers DOB: 13/04/1994" +
                "\nDrivers international: true\nVehicles license: AC2343765\nVehicles Owned: true", InternationalDriverFactory.getInternationalDriver(name,surname, dateOfBirth, vehOwned, value).toString());


    }
}