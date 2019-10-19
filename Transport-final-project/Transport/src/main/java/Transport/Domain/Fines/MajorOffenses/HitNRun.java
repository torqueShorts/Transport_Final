package Transport.Domain.Fines.MajorOffenses;

import Transport.Domain.Fines.Fine;

public class HitNRun
{
    private String location;
    private String date;
    private Fine fine;

    private HitNRun()
    {

    }

    private HitNRun(HitNRunBuilder builder)
    {
        this.location = builder.location;
        this.date = builder.date;
        this.fine = builder.fine;
    }

    public String getLocation()
    {
        return location;
    }

    public String getDate()
    {
        return date;
    }

    public Fine getFine()
    {
        return fine;
    }

    public static class HitNRunBuilder
    {
        private String location;
        private String date;
        private Fine fine;

        public HitNRunBuilder location(String location)
        {
            this.location = location;
            return this;
        }

        public HitNRunBuilder date(String date)
        {
            this.date = date;
            return this;
        }

        public HitNRunBuilder fine(Fine fine)
        {
            this.fine = fine;
            return this;
        }

        public HitNRun build()
        {
            return new HitNRun(this);
        }


    }





}

