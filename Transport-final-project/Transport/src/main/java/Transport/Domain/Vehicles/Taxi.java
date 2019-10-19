package Transport.Domain.Vehicles;

public class Taxi {

    private Vehicle veh;
    private String colour;
    private String model;

    private Taxi()
    {

    }

    private Taxi(TaxiBuilder builder)
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

    public static class TaxiBuilder
    {
        private String colour;
        private String model;
        private Vehicle veh;

        public TaxiBuilder colour(String colour)
        {
            this.colour = colour;
            return this;
        }

        public TaxiBuilder model(String model)
        {
            this.model = model;
            return this;
        }

        public TaxiBuilder veh(Vehicle veh)
        {
            this.veh = veh;
            return this;
        }


        public Taxi build()
        {
            return new Taxi(this);
        }

    }

    @Override

    public String toString() {
        return "Taxi: \n Taxi colour: " + colour + "\n Taxi model: " + model + "\n " +
                "Taxi license: " + veh.getVehicleLicense() + "\n Vehicles type: " + veh.getType() + "\n Drivers ID: " + veh.getDriverID();
    }




}
