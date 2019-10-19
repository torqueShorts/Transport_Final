package Transport.Repository.Impl.DepartmentRepoImplTests;

import Transport.Domain.Department.TrafficClerk;
import Transport.Factory.DepartmentFactoryTests.TrafficClerkFactory;
import Transport.Repository.Impl.DepartmentRepoImplementations.TrafficClerkRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

public class TrafficClerkRepositoryImplTest {

    TrafficClerkRepositoryImpl trafClerk = TrafficClerkRepositoryImpl.getRepo();
    TrafficClerkFactory object = new TrafficClerkFactory();

    TrafficClerk value = object.getTrafficClerk("AR2334","John", "Bonny", "RD2345", false);
    TrafficClerk value2 = object.getTrafficClerk("AR5768","Brad", "Sonny", "RD7585", false);
    TrafficClerk value3 = object.getTrafficClerk("AR2334","John", "Benji", "RD2345", true);


    @Test
    public void create()
    {
        trafClerk.create(value);
        trafClerk.create(value2);

        int amount = trafClerk.getAll().size();

        Assert.assertEquals(2,amount);

    }

    @Test
    public void update()
    {
        trafClerk.create(value);
        trafClerk.create(value2);

        TrafficClerk trafValue = trafClerk.update(value3);

        Assert.assertEquals(value3,trafValue);

    }

    @Test
    public void delete()
    {
        trafClerk.create(value);
        trafClerk.create(value2);

        String element = value.getClerkID();

        trafClerk.delete(element);

        int amount = trafClerk.getAll().size();

        Assert.assertEquals(1,amount);


    }

    @Test
    public void read()
    {
        trafClerk.create(value);
        trafClerk.create(value2);

        String element = value.getClerkID();

        TrafficClerk trafValue = trafClerk.read(element);

        Assert.assertEquals(value, trafValue);
    }

    @Test
    public void getAll()
    {
        trafClerk.create(value);
        trafClerk.create(value2);

        int amount = trafClerk.getAll().size();

        Assert.assertEquals(2,amount);
    }
}