package Transport.Factory.VehicleFactories;

import Transport.Domain.Vehicles.HeavyDuty;
import Transport.Domain.Vehicles.Vehicle;

public class HeavyDutyFactory {

    public static HeavyDuty getHeavyDuty(String colour, String model, Vehicle veh)
    {
        return new HeavyDuty.HeavyDutyBuilder()
                .colour(colour)
                .model(model)
                .vehicle(veh)
                .build();
    }






}
