package Transport.Factory.FineFactoryTests.MajorOffenseTests;

import Transport.Domain.Fines.Fine;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MajorOffenses.MajorOffenseFactory;
import org.junit.Assert;
import org.junit.Test;

public class MajorOffenseFactoryTest {

    @Test
    public void getMajorOffense() {

        FineFactory fine = new FineFactory();

        String type = "Hit and Run";
        Fine value = fine.getFine("AR43675","EB23674580", "0815674389","MajorOffence", false);


        Assert.assertEquals("Type of Major offence: Hit and Run\nVehicles License: EB23674580\nDrivers ID: 0815674389\nFine type: MajorOffence\nFine Paid: false",
                MajorOffenseFactory.getMajorOffense(type,value).toString());


    }
}