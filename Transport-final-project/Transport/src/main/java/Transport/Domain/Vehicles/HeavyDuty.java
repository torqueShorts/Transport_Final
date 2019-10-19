package Transport.Domain.Vehicles;

public class HeavyDuty {

    private Vehicle veh;
    private String colour;
    private String model;

    private HeavyDuty()
    {

    }

    private HeavyDuty(HeavyDutyBuilder builder)
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

    public static class HeavyDutyBuilder
    {
        private Vehicle veh;
        private String colour;
        private String model;

        public HeavyDutyBuilder colour(String colour)
        {
            this.colour = colour;
            return this;
        }

        public HeavyDutyBuilder model(String model)
        {
            this.model = model;
            return this;
        }

        public HeavyDutyBuilder vehicle(Vehicle veh)
        {
            this.veh = veh;
            return this;
        }

        public HeavyDuty build()
        {
            return new HeavyDuty(this);
        }

    }

    @Override

    public String toString() {
        return "HeavyDuty: \n HeavyDuty colour: " + colour + "\n HeavyDuty model: " + model + "\n " +
                "HeavyDuty license: " + veh.getVehicleLicense() + "\n Vehicles type: " + veh.getType() + "\n Drivers ID: " + veh.getDriverID();
    }






}

