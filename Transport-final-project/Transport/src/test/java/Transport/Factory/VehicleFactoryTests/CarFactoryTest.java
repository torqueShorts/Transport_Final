package Transport.Factory.VehicleFactoryTests;

import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.CarFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarFactoryTest {



    @Before
    public void setUp() throws Exception {



    }

    @Test
    public void getCar() {


        String colour = "Blue";
        String model = "BMW M3";
        VehicleFactory veh = new VehicleFactory();
        Vehicle value = veh.getVehicle("AC23343", "Car", "18272832");


        Assert.assertEquals("Car: \n Car colour: Blue\n Car model: BMW M3\n Car license: AC23343\n Vehicles type: Car\n Drivers ID: 18272832",
                CarFactory.getCar(colour,model,value).toString());


    }
}