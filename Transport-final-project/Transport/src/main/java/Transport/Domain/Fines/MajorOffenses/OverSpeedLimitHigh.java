package Transport.Domain.Fines.MajorOffenses;

import Transport.Domain.Fines.Fine;

public class OverSpeedLimitHigh {

    private int speedLimit;
    private int carSpeed;
    private String date;
    private Fine fine;

    private OverSpeedLimitHigh()
    {

    }

    private OverSpeedLimitHigh(OverHighBuilder builder)
    {
        this.speedLimit = builder.speedLimit;
        this.carSpeed = builder.carSpeed;
        this.date = builder.date;
        this.fine = builder.fine;
    }

    public int getSpeedLimit()
    {
        return speedLimit;
    }

    public int getCarSpeed()
    {
        return carSpeed;
    }

    public String getDate()
    {
        return date;
    }

    public Fine getFine()
    {
        return fine;
    }

    public static class OverHighBuilder
    {
        private int speedLimit;
        private int carSpeed;
        private String date;
        private Fine fine;


        public OverHighBuilder speedLimit(int speedLimit)
        {
            this.speedLimit = speedLimit;
            return this;
        }

        public OverHighBuilder carSpeed(int carSpeed)
        {
            this.carSpeed = carSpeed;
            return this;
        }

        public OverHighBuilder date(String date)
        {
            this.date = date;
            return this;
        }

        public OverHighBuilder fine(Fine fine)
        {
            this.fine = fine;
            return this;
        }

        public OverSpeedLimitHigh build()
        {
            return new OverSpeedLimitHigh(this);
        }

    }

    @Override

    public String toString()
    {
        return "Vehicles License: " + fine.getVehLicense() + "\nDrivers ID: " + fine.getDriverID() + "\nType of offence: " + fine.getType()
                + "\nFine Paid: " + fine.getFinePaid() + "\nThe speed of the driver: " + carSpeed +"\nThe speed limit of the road: "
                + speedLimit +   "\nCourt summons date: " + date;
    }


}

