package Transport.Factory.VehicleFactoryTests;

import Transport.Factory.VehicleFactories.VehicleFactory;
import org.junit.Assert;
import org.junit.Test;

public class VehicleFactoryTest {

    @Test
    public void getVehicle() {


        String vehLicense = "AC345545";
        String driverID = "08474945";
        String type = "MinorOffence";


        Assert.assertEquals("Vehicles: \nVehicles License: AC345545\nDrivers ID: 08474945\n" +
        "Type: MinorOffence",
                VehicleFactory.getVehicle(vehLicense,driverID,type).toString());

    }
}