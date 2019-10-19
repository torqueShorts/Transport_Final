package Transport.Factory.FineFactories.MajorOffenses;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MajorOffenses.OverSpeedLimitHigh;

public class OverSpeedLimitHighFactory {

    public static OverSpeedLimitHigh getOverSpeedLimit(int speedLimit, int carSpeed, String date, Fine fine)
    {
        return new OverSpeedLimitHigh.OverHighBuilder()
                .speedLimit(speedLimit)
                .carSpeed(carSpeed)
                .date(date)
                .fine(fine)
                .build();
    }


    public static class HitNRun {

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

        public Fine getFine(Fine fine)
        {
            return fine;
        }

        public String getLocation(String location)
        {
            return location;
        }

        public String getDate(String date)
        {
            return date;
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
}
