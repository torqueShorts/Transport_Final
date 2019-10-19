package Transport.Factory.VehicleFactories;

import Transport.Domain.Vehicles.Bus;
import Transport.Domain.Vehicles.Vehicle;

public class BusFactory {

    public static Bus getBus(String colour, String model, Vehicle veh)
    {
        return new Bus.BusBuilder()
                .colour(colour)
                .model(model)
                .vehicle(veh)
                .build();
    }





}
