package Transport.Factory.VehicleFactories;

import Transport.Domain.Vehicles.Motorbike;
import Transport.Domain.Vehicles.Vehicle;

public class MotobikeFactory {

    public static Motorbike getMotorbike(String colour, String model, Vehicle veh)
    {
        return new Motorbike.MotorbikeBuilder()
                .colour(colour)
                .model(model)
                .vehicle(veh)
                .build();
    }





}
