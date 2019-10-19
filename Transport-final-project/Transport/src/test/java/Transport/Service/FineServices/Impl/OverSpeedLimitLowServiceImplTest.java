package Transport.Service.FineServices.Impl;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MinorOffenses.OverSpeedLimitLow;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MinorOffenses.OverSpeedLimitLowFactory;
import Transport.Repository.Impl.FineRepoImplementations.MinorOffenses.OverSpeedLimitLowRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OverSpeedLimitLowServiceImplTest {

    private OverSpeedLimitLowRepositoryImpl repository;

    OverSpeedLimitLowFactory object = new OverSpeedLimitLowFactory();

    FineFactory fine = new FineFactory();

    Fine fin = fine.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);
    Fine fin2 = fine.getFine("AR56784", "BC7859", "0827684", "MinorOffence", false);
    Fine fin3 = fine.getFine("AR56784", "BC7859", "0827684", "MinorOffence", false);

    OverSpeedLimitLow value = object.getOverSpeedLimitLow(60,100,300,fin);
    OverSpeedLimitLow value2 = object.getOverSpeedLimitLow(80, 90,500,fin2);
    OverSpeedLimitLow value3 = object.getOverSpeedLimitLow(60,80,600,fin3);


    @Before
    public void setUp() throws Exception
    {
        this.repository = OverSpeedLimitLowRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<OverSpeedLimitLow> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        OverSpeedLimitLow created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        OverSpeedLimitLow updated = this.repository.update(value3);

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
        OverSpeedLimitLow saved = this.repository.read(value.getFine().getFineNum());

        Assert.assertEquals(value, saved);
    }
}