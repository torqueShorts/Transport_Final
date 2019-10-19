package Transport.Factory.ExternalFactories;

import Transport.Domain.External.Warrant;


public class WarrantFactory {

    public static Warrant getWarrant(String warrantID, String driverID, String vehLicense, boolean active)
    {
        return new Warrant.WarrantBuilder()
                .warrantID(warrantID)
                .driverID(driverID)
                .vehLicense(vehLicense)
                .active(active)
                .build();
    }


}
