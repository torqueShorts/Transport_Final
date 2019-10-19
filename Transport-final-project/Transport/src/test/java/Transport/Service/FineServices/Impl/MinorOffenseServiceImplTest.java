package Transport.Service.FineServices.Impl;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MinorOffenses.MinorOffense;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MinorOffenses.MinorOffenseFactory;
import Transport.Repository.Impl.FineRepoImplementations.MinorOffenses.MinorOffenceRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MinorOffenseServiceImplTest {

    private MinorOffenceRepositoryImpl repository;

    MinorOffenseFactory object = new MinorOffenseFactory();


    FineFactory fine = new FineFactory();

    Fine fin = fine.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);
    Fine fin2 = fine.getFine("AR56784", "BC7859", "0827684", "MinorOffence", false);

    MinorOffense value = object.getMinorOffense("OverSpeedLimitLow", fin);
    MinorOffense value2 = object.getMinorOffense("DisobeySign",fin2);
    MinorOffense value3 = object.getMinorOffense("DisobeySign",fin2);


    @Before
    public void setUp() throws Exception
    {
        this.repository = MinorOffenceRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<MinorOffense> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        MinorOffense created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        MinorOffense updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getFine().getFineNum());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        MinorOffense saved = this.repository.read(value.getFine().getFineNum());

        Assert.assertEquals(value, saved);
    }
}