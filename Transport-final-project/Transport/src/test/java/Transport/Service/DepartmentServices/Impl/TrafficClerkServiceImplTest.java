package Transport.Service.DepartmentServices.Impl;

import Transport.Domain.Department.TrafficClerk;
import Transport.Factory.DepartmentFactoryTests.TrafficClerkFactory;
import Transport.Repository.Impl.DepartmentRepoImplementations.TrafficClerkRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TrafficClerkServiceImplTest {

    private TrafficClerkRepositoryImpl repository;


    TrafficClerkFactory object = new TrafficClerkFactory();

    TrafficClerk value = object.getTrafficClerk("AR2334","John", "Bonny", "RD2345", false);
    TrafficClerk value2 = object.getTrafficClerk("AR5768","Brad", "Sonny", "RD7585", false);
    TrafficClerk value3 = object.getTrafficClerk("AR2334","John", "Benji", "RD2345", true);

    @Before
    public void setUp() throws Exception {
        this.repository = TrafficClerkRepositoryImpl.getRepo();
    }


    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<TrafficClerk> chiefs = this.repository.getAll();
        Assert.assertEquals(chiefs, this.repository.getAll());
    }

    @Test
    public void create()
    {
        TrafficClerk created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        TrafficClerk updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getClerkID());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        TrafficClerk saved = this.repository.read(value.getClerkID());

        Assert.assertEquals(value, saved);
    }
}