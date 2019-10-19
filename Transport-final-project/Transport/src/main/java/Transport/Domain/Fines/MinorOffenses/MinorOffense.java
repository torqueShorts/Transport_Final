package Transport.Domain.Fines.MinorOffenses;

import Transport.Domain.Fines.Fine;

public class MinorOffense {

    private String type;
    private Fine fine;

    private MinorOffense()
    {

    }

    private MinorOffense(MinorOffenceBuilder builder)
    {
        this.type = builder.type;
        this.fine = builder.fine;
    }

    public String getType()
    {
        return type;
    }

    public Fine getFine()
    {
        return fine;
    }


    public static class MinorOffenceBuilder {

        private String type;
        private Fine fine;

        public MinorOffenceBuilder type(String type) {
            this.type = type;
            return this;
        }

        public MinorOffenceBuilder fine(Fine fine)
        {
            this.fine = fine;
            return this;
        }


        public MinorOffense build() {
            return new MinorOffense(this);
        }


    }

    @Override

    public String toString()
    {
        return "Type of Minor offence: " + type + "\nVehicles License: " + fine.getVehLicense() + "\nDrivers ID: " + fine.getDriverID()
                + "\nFine type: " + fine.getType() + "\nFine Paid: " + fine.getFinePaid();
    }

}
