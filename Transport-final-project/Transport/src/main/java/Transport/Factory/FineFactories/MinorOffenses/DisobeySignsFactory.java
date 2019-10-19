package Transport.Factory.FineFactories.MinorOffenses;

import Transport.Domain.Fines.MinorOffenses.DisobeySigns;
import Transport.Domain.Fines.Fine;

public class DisobeySignsFactory {

    public static DisobeySigns getDisobeySign(String sign, int amount, Fine fine)
    {
        return new DisobeySigns.DisobeySignsBuilder()
                .sign(sign)
                .amount(amount)
                .fine(fine)
                .build();
    }


}
