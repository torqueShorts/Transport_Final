package Transport.Repository.Impl.DepartmentRepoImplTests;

import Transport.Domain.Department.TrafficChief;
import Transport.Factory.DepartmentFactoryTests.TraffiChiefFactory;
import Transport.Repository.Impl.DepartmentRepoImplementations.TrafficChiefRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

public class TrafficChiefRepositoryImplTest {


    TrafficChiefRepositoryImpl chief = TrafficChiefRepositoryImpl.getRepo();
    TraffiChiefFactory object = new TraffiChiefFactory();

    TrafficChief value = object.getTrafficChief("RD2345", "Denny", "Lenny", "RA2345");
    TrafficChief value2 = object.getTrafficChief("RD4565", "Seth", "Donny", "RA7685");
    TrafficChief value3 = object.getTrafficChief("RD2345", "Denny", "Benji", "RA7485");

    @Test
    public void create()
    {
        chief.create(value);
        chief.create(value2);

        int amount = chief.getAll().size();

        Assert.assertEquals(2,amount);

    }

    @Test
    public void update()
    {
        chief.create(value);
        chief.create(value2);

        TrafficChief chee = chief.update(value3);

        Assert.assertEquals(value3,chee);

    }

    @Test
    public void delete()
    {
        chief.create(value);
        chief.create(value2);

        String element = value.getChiefID();

        chief.delete(element);

        int amount = chief.getAll().size();

        Assert.assertEquals(1, amount);

    }

    @Test
    public void read()
    {
        chief.create(value);
        chief.create(value2);

        String element = value.getChiefID();

        TrafficChief trafValue = chief.read(element);

        Assert.assertEquals(value, trafValue);

    }

    @Test
    public void getAll()
    {
        chief.create(value);
        chief.create(value2);

        int amount = chief.getAll().size();

        Assert.assertEquals(2,amount);

    }
}