package Transport.Factory.VehicleFactoryTests;

import Transport.Domain.Vehicles.Vehicle;
import Transport.Factory.VehicleFactories.HeavyDutyFactory;
import Transport.Factory.VehicleFactories.VehicleFactory;
import org.junit.Assert;
import org.junit.Test;

public class HeavyDutyFactoryTest {

    @Test
    public void getHeavyDuty() {

        VehicleFactory veh = new VehicleFactory();

        String colour = "Peach";
        String model = "Truck";
        Vehicle value = veh.getVehicle("LR2375869", "HeavyDuty", "064578932");

        Assert.assertEquals("HeavyDuty: \n HeavyDuty colour: Peach\n HeavyDuty model: Truck\n HeavyDuty license: LR2375869\n Vehicles type: HeavyDuty\n Drivers ID: 064578932",
                HeavyDutyFactory.getHeavyDuty(colour,model, value).toString());





    }
}