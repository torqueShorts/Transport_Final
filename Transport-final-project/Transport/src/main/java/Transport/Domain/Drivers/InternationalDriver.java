package Transport.Domain.Drivers;

public class InternationalDriver {

    private Driver drive;
    private String name;
    private String surname;
    private String dateOfBirth;
    private boolean vehOwned;

    private InternationalDriver()
    {
    }

    private InternationalDriver(IntDriverBuidler builder)
    {
        this.drive = builder.drive;
        this.name = builder.name;
        this.surname = builder.surname;
        this.dateOfBirth = builder.dateOfBirth;
        this.vehOwned = builder.vehOwned;
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

    public Boolean getvehOwned()
    {
        return vehOwned;
    }

    public Driver getDrive()
    {
        return drive;
    }



    public static class IntDriverBuidler
    {
        private Driver drive;
        private String name;
        private String surname;
        private String dateOfBirth;
        private boolean vehOwned;

        public IntDriverBuidler name(String name)
        {
            this.name = name;
            return this;
        }

        public IntDriverBuidler surname(String surname)
        {
            this.surname = surname;
            return this;
        }

        public IntDriverBuidler dateOfBirth(String dateOfBirth)
        {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public IntDriverBuidler vehOwned(boolean vehOwned)
        {
            this.vehOwned = vehOwned;
            return this;
        }

        public IntDriverBuidler driver(Driver drive)
        {
            this.drive = drive;
            return this;
        }

        public InternationalDriver build()
        {
            return new InternationalDriver(this);
        }

    }

    @Override

    public String toString()
    {
        return "International Drivers: \nDrivers ID: " + drive.getDriverID() + "\nDrivers name: " + name + "\nDrivers surname: " + surname + "\nDrivers DOB: " + dateOfBirth +
                "\nDrivers international: " + drive.getInternational() + "\nVehicles license: " + drive.getVehLicense() + "\nVehicles Owned: " +
                vehOwned;
    }



}
