package Transport.Factory.FineFactoryTests;

import Transport.Domain.Fines.Fine;
import Transport.Factory.FineFactories.FineFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FineFactoryTest {

    Fine.FineBuilder fin = new Fine.FineBuilder();

    @Test
    public void getFine()
    {
        String fineNumb = "AR1234";
        String vehLic = "ACT2736";
        String driveId = "083201";
        String Type = "MinorFine";
        boolean finePay = true;

        Assert.assertEquals(
                "Fine: " +
                        "fineNum='AR1234" + '\'' +
                        ", vehLicense='ACT2736" + '\'' +
                        ", driverID='083201" + '\'' +
                        ", type='MinorFine"+ '\'' +
                        ", finePaid=true", FineFactory.getFine(fineNumb,vehLic,driveId, Type,finePay).toString());
    }
}