package Transport.Factory.FineFactories.MajorOffenses;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MajorOffenses.HitNRun;

public class HitNRunFactory {

    public static HitNRun getHitNRun(String location, String date, Fine fine)
    {
        return new HitNRun.HitNRunBuilder()
                .location(location)
                .date(date)
                .fine(fine)
                .build();
    }


}
