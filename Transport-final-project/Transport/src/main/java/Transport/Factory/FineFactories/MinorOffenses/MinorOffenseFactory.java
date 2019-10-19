package Transport.Factory.FineFactories.MinorOffenses;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MinorOffenses.MinorOffense;

public class MinorOffenseFactory {

    public static MinorOffense getMinorOffense(String type, Fine fine)
    {
        return new MinorOffense.MinorOffenceBuilder()
                .type(type)
                .fine(fine)
                .build();
    }

}
