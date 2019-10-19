package Transport.Factory.FineFactories.MajorOffenses;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MajorOffenses.MajorOffense;

public class MajorOffenseFactory {

    public static MajorOffense getMajorOffense(String type, Fine fine)
    {
        return new MajorOffense.MajorOffenceBuilder()
                .type(type)
                .fine(fine)
                .build();
    }


}
