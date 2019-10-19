package Transport.Domain.Fines.MinorOffenses;

import Transport.Domain.Fines.Fine;

public class OverSpeedLimitLow {

    private int speedLimit;
    private int carSpeed;
    private int amount;
    private Fine fine;

    private OverSpeedLimitLow()
    {

    }

    private OverSpeedLimitLow(OverLowBuilder builder)
    {
        this.speedLimit = builder.speedLimit;
        this.carSpeed = builder.carSpeed;
        this.amount = builder.amount;
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

    public int getAmount()
    {
        return amount;
    }

    public Fine getFine()
    {
        return fine;
    }

    public static class OverLowBuilder
    {
        private int speedLimit;
        private int carSpeed;
        private int amount;
        private Fine fine;


        public OverLowBuilder speedLimit(int speedLimit)
        {
            this.speedLimit = speedLimit;
            return this;
        }

        public OverLowBuilder carSpeed(int carSpeed)
        {
            this.carSpeed = carSpeed;
            return this;
        }

        public OverLowBuilder amount(int amount)
        {
            this.amount = amount;
            return this;
        }


        public OverLowBuilder fine(Fine fine)
        {
            this.fine = fine;
            return this;
        }


        public OverSpeedLimitLow build()
        {
            return new OverSpeedLimitLow(this);
        }

    }


    @Override

    public String toString()
    {
        return "Vehicles License: " + fine.getVehLicense() + "\nDrivers ID: " + fine.getDriverID() + "\nType of offence: " + fine.getType()
                + "\nFine Paid: " + fine.getFinePaid() + "\nThe speed of the driver: " + carSpeed +"\nThe speed limit of the road: "
                + speedLimit +   "\nAmount due: " + amount;
    }


}
