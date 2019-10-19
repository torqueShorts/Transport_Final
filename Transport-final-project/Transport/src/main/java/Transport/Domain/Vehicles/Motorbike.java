package Transport.Domain.Vehicles;

public class Motorbike {

    private Vehicle veh;
    private String colour;
    private String model;

    private Motorbike()
    {

    }

    private Motorbike(MotorbikeBuilder builder)
    {
        this.veh = builder.veh;
        this.colour = builder.colour;
        this.model = builder.model;

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

    public static class MotorbikeBuilder
    {
        private Vehicle veh;
        private String colour;
        private String model;

        public MotorbikeBuilder colour(String colour)
        {
            this.colour = colour;
            return this;
        }

        public MotorbikeBuilder model(String model)
        {
            this.model = model;
            return this;
        }

        public MotorbikeBuilder vehicle(Vehicle veh)
        {
            this.veh = veh;
            return this;
        }


        public Motorbike build()
        {
            return new Motorbike(this);
        }

    }

    @Override

    public String toString() {
        return "Motorbike: \n Motorbike colour: " + colour + "\n Motorbike model: " + model + "\n " +
                "Motorbike license: " + veh.getVehicleLicense() + "\n Vehicles type: " + veh.getType() + "\n Drivers ID: " + veh.getDriverID();
    }

}
