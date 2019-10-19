package Transport.Domain.Department;

public class TrafficChief {

    private String chiefID;
    private String name;
    private String surname;
    private String fineCode;

    private TrafficChief()
    {

    }

    private TrafficChief(TrafficChiefBuilder builder)
    {
        this.chiefID = builder.chiefID;
        this.name = builder.name;
        this.surname = builder.surname;
        this.fineCode = builder.fineCode;
    }

    public String getChiefID()
    {
        return chiefID;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getFineCode()
    {
        return fineCode;
    }



    public static class TrafficChiefBuilder
    {
        private String chiefID;
        private String name;
        private String surname;
        private String fineCode;

        public TrafficChiefBuilder chiefID(String chiefID)
        {
            this.chiefID = chiefID;
            return this;
        }

        public TrafficChiefBuilder name(String name)
        {
            this.name = name;
            return this;
        }

        public TrafficChiefBuilder surname(String surname)
        {
            this.surname = surname;
            return this;
        }

        public TrafficChiefBuilder fineCode(String fineCode)
        {
            this.fineCode = fineCode;
            return this;
        }

        public TrafficChief build()
        {
            return new TrafficChief(this);
        }




    }

    @Override

    public String toString() {
        return "Traffic Chief: " + "\nChief ID = " + chiefID + "\nChief name: " + name + "\nChief surname: " + surname + "\n" +
                "Traffic Fine: " + fineCode;
    }

}
