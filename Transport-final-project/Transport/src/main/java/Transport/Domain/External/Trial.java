package Transport.Domain.External;

public class Trial {

    private String trialID;
    private String date;
    private String driverID;
    private String vehicleID;


    private Trial()
    {

    }

    private Trial(TrialBuilder builder)
    {
        this.trialID = builder.trialID;
        this.date = builder.date;
        this.driverID = builder.driverID;
        this.vehicleID = builder.vehicleID;
    }

    public String getTrialID(){return trialID;}

    public String getDate()
    {
        return date;
    }

    public String getDriverID(){ return driverID; }

    public String getVehicleID(){ return vehicleID; }

    public static class TrialBuilder
    {
        private String trialID;
        private String date;
        private String driverID;
        private String vehicleID;


        public TrialBuilder trialID(String trialID)
        {
            this.trialID = trialID;
            return this;
        }

        public TrialBuilder date(String date)
        {
            this.date = date;
            return this;
        }

        public TrialBuilder driverID(String driverID)
        {
            this.driverID = driverID;
            return this;
        }

        public TrialBuilder vehicleID(String vehicleID)
        {
            this.vehicleID = vehicleID;
            return this;
        }


        public Trial build()
        {
            return new Trial(this);
        }

    }

    public String toString()
    {
        return "Trial ID: " + trialID + "\nDate of Trial: " + date + "\nDrivers ID: " + driverID + "\nVehicles ID: " + vehicleID;
    }

}
