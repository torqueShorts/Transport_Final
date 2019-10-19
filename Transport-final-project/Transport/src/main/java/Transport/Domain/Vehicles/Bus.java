package Transport.Domain.Vehicles;

public class Bus {


    private Vehicle veh;
    private String colour;
    private String model;

    private Bus()
    {

    }

    private Bus(BusBuilder builder)
    {
        this.colour = builder.colour;
        this.model = builder.model;
        this.veh = builder.veh;
    }

    public String getColour()
    {
        return colour;
    }

    public String getModel()
    {
        return model;
    }

    public Vehicle getVeh()
    {
        return veh;
    }

    public static class BusBuilder
    {
        private Vehicle veh;
        private String colour;
        private String model;

        public BusBuilder colour(String colour)
        {
            this.colour = colour;
            return this;
        }

        public BusBuilder model(String model)
        {
            this.model = model;
            return this;
        }

        public BusBuilder vehicle(Vehicle veh)
        {
            this.veh = veh;
            return this;
        }

        public Bus build()
        {
            return new Bus(this);
        }

    }

    @Override

    public String toString() {
        return "Bus: \n Bus colour: " + colour + "\n Bus model: " + model + "\n " +
                "Bus license: " + veh.getVehicleLicense() + "\n Vehicles type: " + veh.getType() + "\n Drivers ID: " + veh.getDriverID();
    }



}
