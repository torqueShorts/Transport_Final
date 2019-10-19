package Transport.Repository.Impl.DepartmentRepoImplTests;

import Transport.Domain.Department.TrafficOfficer;
import Transport.Factory.DepartmentFactoryTests.TrafficOfficerFactory;
import Transport.Repository.Impl.DepartmentRepoImplementations.TrafficOfficerRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

public class TrafficOfficerRepositoryImplTest {


    TrafficOfficerRepositoryImpl trafOfficer = TrafficOfficerRepositoryImpl.getRepo();
    TrafficOfficerFactory object = new TrafficOfficerFactory();

    TrafficOfficer value = object.getOfficer("AR2334","John", "Bonny", "RD2345", "JID2345");
    TrafficOfficer value2 = object.getOfficer("AR5768","Brad", "Sonny", "RD7585", "DRE3343");
    TrafficOfficer value3 = object.getOfficer("AR2334","John", "Benji", "RD2345", "JID2345");


    @Test
    public void create()
    {
        trafOfficer.create(value);
        trafOfficer.create(value2);

        int amount = trafOfficer.getAll().size();

        Assert.assertEquals(2,amount);
    }

    @Test
    public void update()
    {
        trafOfficer.create(value);
        trafOfficer.create(value2);

        TrafficOfficer trafValue = trafOfficer.update(value3);

        Assert.assertEquals(value3,trafValue);
    }

    @Test
    public void delete()
    {
        trafOfficer.create(value);
        trafOfficer.create(value2);

        int amount = trafOfficer.getAll().size();

        Assert.assertEquals(1,amount);
    }

    @Test
    public void read()
    {
        trafOfficer.create(value);
        trafOfficer.create(value2);

        String element = value.getOfficerID();

        TrafficOfficer trafValue = trafOfficer.read(element);

        Assert.assertEquals(value, trafValue);
    }

    @Test
    public void getAll()
    {
        trafOfficer.create(value);
        trafOfficer.create(value2);

        int amount = trafOfficer.getAll().size();

        Assert.assertEquals(2,amount);

    }
}