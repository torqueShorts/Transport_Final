package Transport.Service.ExternalServices.Impl;

import Transport.Domain.External.Warrant;
import Transport.Factory.ExternalFactories.WarrantFactory;
import Transport.Repository.Impl.ExternalRepoImplementations.WarrantRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WarrantServiceImplTest {

    private WarrantRepositoryImpl repository;

    WarrantFactory object = new WarrantFactory();

    Warrant value = object.getWarrant("RD2345", "08453627", "RC3627463", true);
    Warrant value2 = object.getWarrant("RD2672", "0817364", "RC7384003", true);
    Warrant value3 = object.getWarrant("RD2345", "08453627", "RC3627463", false);


    @Before
    public void setUp() throws Exception
    {
        this.repository = WarrantRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<Warrant> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        Warrant created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        Warrant updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getWarrantID());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        Warrant saved = this.repository.read(value.getWarrantID());

        Assert.assertEquals(value, saved);
    }
}