package Transport.Domain.Drivers;

public class NationalDriver {


    private Driver drive;
    private String name;
    private String surname;
    private String dateOfBirth;

    private NationalDriver()
    {
    }

    private NationalDriver(NatDriverBuidler builder)
    {
        this.drive = builder.drive;
        this.name = builder.name;
        this.surname = builder.surname;
        this.dateOfBirth = builder.dateOfBirth;
    }


    public Driver getDrive()
    {
        return drive;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }


    public static class NatDriverBuidler
    {
        private Driver drive;
        private String name;
        private String surname;
        private String dateOfBirth;

        public NatDriverBuidler name(String name)
        {
            this.name = name;
            return this;
        }

        public NatDriverBuidler surname(String surname)
        {
            this.surname = surname;
            return this;
        }

        public NatDriverBuidler dateOfBirth(String dateOfBirth)
        {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public NatDriverBuidler driver(Driver drive)
        {
            this.drive = drive;
            return this;
        }

        public NationalDriver build()
        {
            return new NationalDriver(this);
        }

    }

    @Override

    public String toString()
    {
        return "National Drivers: \nDrivers ID: " + drive.getDriverID() + "\nDrivers name: " + name + "\nDrivers surname: " + surname + "\nDrivers DOB: " + dateOfBirth +
                "\nDrivers international: " + drive.getInternational() + "\nVehicles license: " + drive.getVehLicense();
    }

}
