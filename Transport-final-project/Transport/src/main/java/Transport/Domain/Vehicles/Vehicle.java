package Transport.Domain.Vehicles;

public class Vehicle {

    private String vehicleLicense;
    private String type;
    private String driverID;

    private Vehicle()
    {

    }

    private Vehicle(VehicleBuilder builder)
    {
        this.vehicleLicense = builder.vehicleLicense;
        this.type = builder.type;
        this.driverID = builder.driverID;
    }

    public String getVehicleLicense()
    {
        return vehicleLicense;
    }

    public String getType()
    {
        return type;
    }

    public String getDriverID()
    {
        return driverID;
    }


    public static class VehicleBuilder {
        private String vehicleLicense;
        private String type;
        private String driverID;

        public VehicleBuilder vehicleLicense(String vehicleLicense) {
            this.vehicleLicense = vehicleLicense;
            return this;
        }

        public VehicleBuilder type(String type) {
            this.type = type;
            return this;
        }

        public VehicleBuilder driverID(String driverID) {
            this.driverID = driverID;
            return this;
        }


        public Vehicle build() {
            return new Vehicle(this);
        }


    }
        public String toString() {
            return "Vehicles: " +
                    "\nVehicles License: " + vehicleLicense +
                    "\nDrivers ID: " + driverID +
                    "\nType: " + type;
        }



}
