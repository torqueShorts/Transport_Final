package Transport.Factory.FineFactories.MinorOffenses;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MinorOffenses.OverSpeedLimitLow;

public class OverSpeedLimitLowFactory {

    public static OverSpeedLimitLow getOverSpeedLimitLow(int speedLimit, int carSpeed, int amount, Fine fine)
    {
        return new OverSpeedLimitLow.OverLowBuilder()
                .speedLimit(speedLimit)
                .carSpeed(carSpeed)
                .amount(amount)
                .fine(fine)
                .build();
    }


}
