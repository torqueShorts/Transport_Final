package Transport.Factory.VehicleFactories;

import Transport.Domain.Vehicles.Car;
import Transport.Domain.Vehicles.Vehicle;

public class CarFactory {

    public static Car getCar(String colour, String model, Vehicle vhe)
    {
        return new Car.CarBuilder()
                .colour(colour)
                .model(model)
                .veh(vhe)
                .build();
    }


}
