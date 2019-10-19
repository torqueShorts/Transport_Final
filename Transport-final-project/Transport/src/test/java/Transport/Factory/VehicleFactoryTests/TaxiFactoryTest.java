package Transport.Factory.VehicleFactoryTests;

import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.TaxiFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
import org.junit.Assert;
import org.junit.Test;

public class TaxiFactoryTest {

    @Test
    public void getTaxi() {

        VehicleFactory veh = new VehicleFactory();

        String colour = "White";
        String model = "Toyota Quantum";
        Vehicle value = veh.getVehicle("RS23456", "Taxi", "28374905");

        Assert.assertEquals("Taxi: \n Taxi colour: White\n Taxi model: Toyota Quantum\n Taxi license: RS23456\n Vehicles type: Taxi\n Drivers ID: 28374905",
                TaxiFactory.getTaxi(colour,model, value).toString());





    }
}