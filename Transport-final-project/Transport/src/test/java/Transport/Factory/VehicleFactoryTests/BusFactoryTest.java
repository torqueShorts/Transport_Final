package Transport.Factory.VehicleFactoryTests;

import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.BusFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
import org.junit.Assert;
import org.junit.Test;

public class BusFactoryTest {

    @Test
    public void getBus() {


        VehicleFactory veh = new VehicleFactory();

        String colour = "Green";
        String model = "Golden Arrow";
        Vehicle value = veh.getVehicle("WD1236789", "Bus", "0845679321");

        Assert.assertEquals("Bus: \n Bus colour: Green\n Bus model: Golden Arrow\n Bus license: WD1236789\n Vehicles type: Bus\n Drivers ID: 0845679321",
                BusFactory.getBus(colour,model, value).toString());


    }
}