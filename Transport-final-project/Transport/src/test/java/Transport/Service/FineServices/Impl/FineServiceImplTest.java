package Transport.Service.FineServices.Impl;

import Transport.Domain.Fines.Fine;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Repository.Impl.FineRepoImplementations.FineRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FineServiceImplTest {

    private FineRepositoryImpl repository;

    FineRepositoryImpl fine = FineRepositoryImpl.getRepo();
    FineFactory fi = new FineFactory();

    Fine value = fi.getFine("AR2390","AC7465993","081475354", "MinorOffence", false);
    Fine value2 = fi.getFine("BW37484","AC465498", "081374657", "MajorOffence", true);
    Fine value3 = fi.getFine("AR2390","AC461234", "081374657", "MinorOffence", false);


    @Before
    public void setUp() throws Exception
    {
        this.repository = FineRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<Fine> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        Fine created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        Fine updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getFineNum());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        Fine saved = this.repository.read(value.getFineNum());

        Assert.assertEquals(value, saved);
    }
}