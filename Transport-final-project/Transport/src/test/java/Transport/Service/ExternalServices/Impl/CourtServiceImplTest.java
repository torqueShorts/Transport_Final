package Transport.Service.ExternalServices.Impl;

import Transport.Domain.External.Court;
import Transport.Factory.ExternalFactories.CourtFactory;
import Transport.Repository.Impl.ExternalRepoImplementations.CourtRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CourtServiceImplTest {


    private CourtRepositoryImpl repository;

    CourtFactory object = new CourtFactory();

    Court value = object.getCourt("Larrisons Court","AR3456", "Lucas Ericson");
    Court value2 = object.getCourt("SmithenWest Court", "AT3746", "John Doe");
    Court value3 = object.getCourt("JohnRiften Court", "AR7869", "Jeff Jeff");


    @Before
    public void setUp() throws Exception
    {
        this.repository = CourtRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<Court> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        Court created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        Court updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getCourtName());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        Court saved = this.repository.read(value.getCourtName());

        Assert.assertEquals(value, saved);
    }
}