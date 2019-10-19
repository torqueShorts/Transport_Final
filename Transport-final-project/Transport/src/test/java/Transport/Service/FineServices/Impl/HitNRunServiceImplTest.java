package Transport.Service.FineServices.Impl;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MajorOffenses.HitNRun;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MajorOffenses.HitNRunFactory;
import Transport.Repository.Impl.FineRepoImplementations.MajorOffenses.HitNRunRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HitNRunServiceImplTest {

    private HitNRunRepositoryImpl repository;

    HitNRunFactory object = new HitNRunFactory();

    FineFactory fine = new FineFactory();

    Fine fin = fine.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);
    Fine fin2 = fine.getFine("AR56784", "BC7859", "0827684", "MinorOffence", false);

    HitNRun value = object.getHitNRun("OverSpeedLimitLow","08/04/1986", fin);
    HitNRun value2 = object.getHitNRun("DisobeySign","07/03/1990",fin2);
    HitNRun value3 = object.getHitNRun("DisobeySign","06/06/1960",fin2);


    @Before
    public void setUp() throws Exception
    {
        this.repository = HitNRunRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<HitNRun> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        HitNRun created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        HitNRun updated = this.repository.update(value3);

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
        HitNRun saved = this.repository.read(value.getFine().getFineNum());

        Assert.assertEquals(value, saved);
    }
}