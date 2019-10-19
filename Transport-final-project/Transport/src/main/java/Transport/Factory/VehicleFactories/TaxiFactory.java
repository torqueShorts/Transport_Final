package Transport.Factory.VehicleFactories;

import Transport.Domain.Vehicles.Taxi;
import Transport.Domain.Vehicles.Vehicle;

public class TaxiFactory {

    public static Taxi getTaxi(String colour, String model, Vehicle veh)
    {
        return new Taxi.TaxiBuilder()
                .colour(colour)
                .model(model)
                .veh(veh)
                .build();
    }


}
