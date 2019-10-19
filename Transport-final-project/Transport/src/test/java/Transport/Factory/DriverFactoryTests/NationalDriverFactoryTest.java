package Transport.Factory.DriverFactoryTests;

import Transport.Domain.Drivers.Driver;
import Transport.Factory.DriversFactories.DriverFactory;
import Transport.Factory.DriversFactories.NationalDriverFactory;
import org.junit.Assert;
import org.junit.Test;

public class NationalDriverFactoryTest {

    @Test
    public void getNationalDriver() {

        DriverFactory drive = new DriverFactory();

        String name = "Luke";
        String surname = "Storm";
        String dateOfBirth = "12/04/1996";
        Driver value = drive.getDriver("08137856784", "AC23576765", false);

        Assert.assertEquals("National Drivers: \nDrivers ID: 08137856784\nDrivers name: Luke\nDrivers surname: Storm\nDrivers DOB: 12/04/1996" +
                "\nDrivers international: false\nVehicles license: AC23576765", NationalDriverFactory.getNationalDriver(name,surname, dateOfBirth, value).toString());




    }
}