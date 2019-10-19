package Transport.Service.DepartmentServices.Impl;

import Transport.Domain.Department.TrafficDepartment;
import Transport.Domain.Department.TrafficOfficer;
import Transport.Factory.DepartmentFactoryTests.TrafficOfficerFactory;
import Transport.Repository.Impl.DepartmentRepoImplementations.TrafficOfficerRepositoryImpl;
import Transport.Repository.Repositories.DepartmentRepositories.TrafficOfficerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TrafficOfficerServiceImplTest {

    private TrafficOfficerRepositoryImpl repository;

    TrafficOfficerFactory object = new TrafficOfficerFactory();

    TrafficOfficer value = object.getOfficer("AR2334","John", "Bonny", "RD2345", "JID2345");
    TrafficOfficer value2 = object.getOfficer("AR5768","Brad", "Sonny", "RD7585", "DRE3343");
    TrafficOfficer value3 = object.getOfficer("AR2334","John", "Benji", "RD2345", "JID2345");




    @Before
    public void setUp() throws Exception
    {
        this.repository = TrafficOfficerRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<TrafficOfficer> officers = this.repository.getAll();
        Assert.assertEquals(officers, this.repository.getAll());
    }

    @Test
    public void create()
    {
            TrafficOfficer created = this.repository.create(value);
            Assert.assertNotNull(created);
            Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        TrafficOfficer updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getOfficerID());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        TrafficOfficer saved = this.repository.read(value.getOfficerID());

        Assert.assertEquals(value, saved);
    }
}