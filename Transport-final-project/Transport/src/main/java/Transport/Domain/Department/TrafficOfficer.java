package Transport.Domain.Department;

public class TrafficOfficer {

    private String officerID;
    private String name;
    private String surname;
    private String fineDue;
    private String warrant;

    private  TrafficOfficer()
    {

    }

    private TrafficOfficer(TrafficOfficerBuilder builder)
    {
        this.officerID = builder.officerID;
        this.name = builder.name;
        this.surname = builder.surname;
        this.fineDue = builder.fineDue;
        this.warrant = builder.warrant;
    }

    public String getOfficerID()
    {
        return officerID;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getFineDue()
    {
        return fineDue;
    }

    public String getWarrant()
    {
        return warrant;
    }

    public static class TrafficOfficerBuilder
    {
        private String officerID;
        private String name;
        private String surname;
        private String fineDue;
        private String warrant;

        public TrafficOfficerBuilder officerID(String officerID)
        {
            this.officerID = officerID;
            return this;
        }

        public TrafficOfficerBuilder name(String name)
        {
            this.name = name;
            return this;
        }

        public TrafficOfficerBuilder surname(String surname)
        {
            this.surname = surname;
            return this;
        }

        public TrafficOfficerBuilder fineDue(String fineDue)
        {
            this.fineDue = fineDue;
            return this;
        }

        public TrafficOfficerBuilder warrant(String warrant)
        {
            this.warrant = warrant;
            return this;
        }

        public TrafficOfficer build()
        {
            return new TrafficOfficer(this);
        }

    }


    @Override
    public String toString() {
        return "TrafficOfficer: " +
                "\nofficerID: " + officerID +
                "\nName: " + name +
                "\nSurname: " + surname +
                "\nFine Due: " + fineDue +
                "\nWarrant: "+ warrant;
    }
}
