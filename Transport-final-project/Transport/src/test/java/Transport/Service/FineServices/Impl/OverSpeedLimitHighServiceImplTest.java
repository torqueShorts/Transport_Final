package Transport.Service.FineServices.Impl;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MajorOffenses.OverSpeedLimitHigh;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MajorOffenses.OverSpeedLimitHighFactory;
import Transport.Repository.Impl.FineRepoImplementations.MajorOffenses.OverSpeedLimitHighRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OverSpeedLimitHighServiceImplTest {

    private OverSpeedLimitHighRepositoryImpl repository;

    OverSpeedLimitHighFactory object = new OverSpeedLimitHighFactory();

    FineFactory fine = new FineFactory();

    Fine fin = fine.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);
    Fine fin2 = fine.getFine("AR56784", "BC7859", "0827684", "MinorOffence", false);
    Fine fin3 = fine.getFine("AR56784", "BC7859", "0827684", "MinorOffence", false);

    OverSpeedLimitHigh value = object.getOverSpeedLimit(60,100,"07/03/1990",fin);
    OverSpeedLimitHigh value2 = object.getOverSpeedLimit(60,120,"07/03/1990",fin2);
    OverSpeedLimitHigh value3 = object.getOverSpeedLimit(60,110,"07/03/1990",fin2);


    @Before
    public void setUp() throws Exception
    {
        this.repository = OverSpeedLimitHighRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<OverSpeedLimitHigh> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        OverSpeedLimitHigh created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        OverSpeedLimitHigh updated = this.repository.update(value3);

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
        OverSpeedLimitHigh saved = this.repository.read(value.getFine().getFineNum());

        Assert.assertEquals(value, saved);
    }
}