package Transport.Domain.Fines.MajorOffenses;


import Transport.Domain.Fines.Fine;

public class MajorOffense {

    private String type;
    private Fine fine;

    private MajorOffense()
    {

    }

    private MajorOffense(MajorOffenceBuilder builder)
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


    public static class MajorOffenceBuilder {

        private String type;
        private Fine fine;

        public MajorOffenceBuilder type(String type) {
            this.type = type;
            return this;
        }

        public MajorOffenceBuilder fine(Fine fine)
        {
            this.fine = fine;
            return this;
        }

        public MajorOffense build() {
            return new MajorOffense(this);
        }


    }

    @Override

    public String toString()
    {
        return "Type of Major offence: " + type + "\nVehicles License: " + fine.getVehLicense() + "\nDrivers ID: " + fine.getDriverID()
                + "\nFine type: " + fine.getType() + "\nFine Paid: " + fine.getFinePaid();
    }

}
