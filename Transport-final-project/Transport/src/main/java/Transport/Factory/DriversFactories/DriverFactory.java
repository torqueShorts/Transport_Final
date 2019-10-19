package Transport.Factory.DriversFactories;

import Transport.Domain.Drivers.Driver;

public class DriverFactory {

    public static Driver getDriver(String driverID, String vehLicense, boolean international)
    {
        return new Driver.DriverBuilder()
                .driverID(driverID)
                .vehLicense(vehLicense)
                .international(international)
                .build();
    }


}
