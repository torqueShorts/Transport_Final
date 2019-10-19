package Transport.Domain.External;

public class Payment {

    private int amount;
    private String driverID;
    private String fineNum;
    private boolean finePaid;

    private Payment()
    {

    }

    private Payment(PaymentBuilder builder)
    {
        this.amount = builder.amount;
        this.driverID = builder.driverID;
        this.fineNum = builder.fineNum;
        this.finePaid = builder.finePaid;
    }

    public int getAmount()
    {
        return amount;
    }

    public String getDriverID()
    {
        return driverID;
    }

    public String getFineNum()
    {
        return fineNum;
    }

    public boolean getFinePaid()
    {
        return finePaid;
    }

    public static class PaymentBuilder
    {
        private int amount;
        private String driverID;
        private String fineNum;
        private boolean finePaid;

        public PaymentBuilder amount(int amount)
        {
            this.amount = amount;
            return this;
        }

        public PaymentBuilder driverID(String driverID)
        {
            this.driverID = driverID;
            return this;
        }

        public PaymentBuilder finNum(String fineNum)
        {
            this.fineNum = fineNum;
            return this;
        }

        public PaymentBuilder finePaid(boolean finePaid)
        {
            this.finePaid = finePaid;
            return this;
        }

        public Payment build()
        {
            return new Payment(this);
        }

    }


    public String toString()
    {
        return "Payment amount: " + amount + "\nDrivers ID: " + driverID + "\nFine number: " + fineNum + "\nFine paid: " + finePaid;
    }



}
