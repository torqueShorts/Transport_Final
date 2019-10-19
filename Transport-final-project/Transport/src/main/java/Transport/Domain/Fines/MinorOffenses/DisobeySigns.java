package Transport.Domain.Fines.MinorOffenses;

import Transport.Domain.Fines.Fine;

public class DisobeySigns {

    private String sign;
    private int amount;
    private Fine fine;

    private DisobeySigns()
    {

    }

    private DisobeySigns(DisobeySignsBuilder builder)
    {
        this.sign = builder.sign;
        this.amount = builder.amount;
        this.fine = builder.fine;
    }

    public String getSign()
    {
        return sign;
    }

    public int getAmount()
    {
        return amount;
    }

    public Fine getFine()
    {
        return fine;
    }


    public static class DisobeySignsBuilder
    {
        private String sign;
        private int amount;
        private Fine fine;

        public DisobeySignsBuilder sign(String sign)
        {
            this.sign = sign;
            return this;
        }

        public DisobeySignsBuilder amount(int amount)
        {
            this.amount = amount;
            return this;
        }

        public DisobeySignsBuilder fine(Fine fine)
        {
            this.fine = fine;
            return this;
        }

        public DisobeySigns build()
        {
            return new DisobeySigns(this);
        }

    }


    @Override

    public String toString()
    {
        return "Vehicles License: " + fine.getVehLicense() + "\nDrivers ID: " + fine.getDriverID() + "\nType of offence: " + fine.getType()
                + "\nFine Paid: " + fine.getFinePaid() + "\nThe sign disobeyed: " + sign + "\nAmount due: " + amount;
    }



}
