package Transport.Domain.Drivers;

public class Driver {

    private String driverID;
    private String vehLicense;
    private boolean international;

        private Driver()
            {

            }

            private Driver(DriverBuilder builder)
            {
                this.driverID = builder.driverID;
                this.vehLicense = builder.vehLicense;
                this.international = builder.international;
            }

            public String getDriverID()
            {
                return driverID;
            }

            public String getVehLicense()
            {
                return vehLicense;
            }

            public boolean getInternational()
            {
                return international;
            }


            public static class DriverBuilder {
                private String driverID;
                private String vehLicense;
                private boolean international;

                public DriverBuilder driverID(String driverID) {
                    this.driverID = driverID;
                    return this;
                }


                public DriverBuilder vehLicense(String vehLicense) {
                    this.vehLicense = vehLicense;
                    return this;
                }

                public DriverBuilder international(boolean international)
                {
                    this.international = international;
                    return this;
                }

                public Driver build() {
                    return new Driver(this);
                }


    }


    public String toString() {

        return "Drivers ID: " + driverID + "\nVehicles license: " + vehLicense + "\nInternational: " + international;
    }

}
