package Transport.Factory.DriversFactories;

import Transport.Domain.Drivers.Driver;
import Transport.Domain.Drivers.NationalDriver;

public class NationalDriverFactory {

    public static NationalDriver getNationalDriver(String name, String surname, String dateOfBirth, Driver drive)
    {
        return new NationalDriver.NatDriverBuidler()
                .name(name)
                .surname(surname)
                .dateOfBirth(dateOfBirth)
                .driver(drive)
                .build();

    }

}
