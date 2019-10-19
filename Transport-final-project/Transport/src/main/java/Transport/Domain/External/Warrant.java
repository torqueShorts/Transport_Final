package Transport.Domain.External;

public class Warrant {

    private String warrantID;
    private String driverID;
    private String vehLicense;
    private boolean active;

    private Warrant()
    {

    }

    private Warrant(WarrantBuilder builder)
    {
        this.warrantID = builder.warrantID;
        this.driverID = builder.driverID;
        this.vehLicense = builder.vehLicense;
        this.active = builder.active;

    }

    public String getWarrantID(){ return warrantID;}

    public String getDriverID()
    {
        return driverID;
    }

    public String getVehLicense()
    {
        return vehLicense;
    }

    public boolean getActive()
    {
        return active;
    }

    public static class WarrantBuilder
    {
        private String warrantID;
        private String driverID;
        private String vehLicense;
        private boolean active;

        public WarrantBuilder warrantID(String warrantID)
        {
            this.warrantID = warrantID;
            return this;
        }
        public WarrantBuilder driverID(String driverID)
        {
            this.driverID = driverID;
            return this;
        }

        public WarrantBuilder vehLicense(String vehLicense)
        {
            this.vehLicense = vehLicense;
            return this;
        }

        public WarrantBuilder active(boolean active)
        {
            this.active = active;
            return this;
        }

        public Warrant build()
        {
            return new Warrant(this);
        }

    }


    public String toString()
    {
        return "Warrant ID: " + warrantID + "\nDrivers ID: " + driverID + "\nVehicles License: " + vehLicense + "\nWarrant valid: " + active;
    }


}
