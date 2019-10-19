package Transport.Factory.ExternalFactories;

import Transport.Domain.External.Trial;

public class TrialFactory {

    public static Trial getTrial(String trialID,String date, String driverID, String vehicleID)
    {
        return new Trial.TrialBuilder()
                .trialID(trialID)
                .date(date)
                .driverID(driverID)
                .vehicleID(vehicleID)
                .build();
    }



}
