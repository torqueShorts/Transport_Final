package Transport.Factory.FineFactories;

import Transport.Domain.Fines.Fine;

public class FineFactory {

    public static Fine getFine(String fineNum,String vehLicense, String driverID, String type, boolean finePaid)
    {
        return new Fine.FineBuilder()
                .fineNum(fineNum)
                .vehLicense(vehLicense)
                .driverID(driverID)
                .type(type)
                .finePaid(finePaid)
                .build();
    }


}
