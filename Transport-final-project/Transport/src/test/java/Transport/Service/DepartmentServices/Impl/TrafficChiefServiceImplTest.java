package Transport.Service.DepartmentServices.Impl;

import Transport.Domain.Department.TrafficChief;
import Transport.Factory.DepartmentFactoryTests.TraffiChiefFactory;
import Transport.Repository.Impl.DepartmentRepoImplementations.TrafficChiefRepositoryImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class TrafficChiefServiceImplTest {


    private TrafficChiefRepositoryImpl repository;
    private TrafficChief chief;

    TraffiChiefFactory object = new TraffiChiefFactory();

    TrafficChief value = object.getTrafficChief("RD2345", "Denny", "Lenny", "RA2345");
    TrafficChief value2 = object.getTrafficChief("RD4565", "Seth", "Donny", "RA7685");
    TrafficChief value3 = object.getTrafficChief("RD2345", "Denny", "Benji", "RA7485");

    @Before
    public void setUp() throws Exception {
        this.repository = TrafficChiefRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<TrafficChief> chiefs = this.repository.getAll();
        Assert.assertEquals(chiefs, this.repository.getAll());
    }

    @Test
    public void create()
    {
        TrafficChief created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        TrafficChief updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);

    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getChiefID());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        TrafficChief saved = this.repository.read(value.getChiefID());

        Assert.assertEquals(value, saved);
    }
}