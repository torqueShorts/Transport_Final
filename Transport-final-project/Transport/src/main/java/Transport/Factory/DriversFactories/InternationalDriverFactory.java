package Transport.Factory.DriversFactories;

import Transport.Domain.Drivers.Driver;
import Transport.Domain.Drivers.InternationalDriver;

public class InternationalDriverFactory {

    public static InternationalDriver getInternationalDriver(String name, String surname, String dateOfBirth, boolean vehOwned, Driver drive)
    {
        return new InternationalDriver.IntDriverBuidler()
                .name(name)
                .surname(surname)
                .dateOfBirth(dateOfBirth)
                .vehOwned(vehOwned)
                .driver(drive)
                .build();
    }



}
