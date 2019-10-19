package Transport.Repository.Impl.FineRepoImplTests.MajorOffenseTests;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MajorOffenses.HitNRun;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MajorOffenses.HitNRunFactory;
import Transport.Repository.Impl.FineRepoImplementations.MajorOffenses.HitNRunRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HitNRunRepositoryImplTest {

    HitNRunRepositoryImpl hitNRun = HitNRunRepositoryImpl.getRepo();
    HitNRunFactory object = new HitNRunFactory();

    FineFactory fine = new FineFactory();

    Fine fin = fine.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);
    Fine fin2 = fine.getFine("AR56784", "BC7859", "0827684", "MinorOffence", false);

    HitNRun value = object.getHitNRun("OverSpeedLimitLow","08/04/1986", fin);
    HitNRun value2 = object.getHitNRun("DisobeySign","07/03/1990",fin2);
    HitNRun value3 = object.getHitNRun("DisobeySign","06/06/1960",fin2);

    @Test
    public void create()
    {
        hitNRun.create(value);
        hitNRun.create(value2);

        int amount = hitNRun.getAll().size();

        Assert.assertEquals(2,amount);
    }

    @Test
    public void update()
    {
        hitNRun.create(value);
        hitNRun.create(value2);

        HitNRun min = hitNRun.update(value3);

        Assert.assertEquals(value3, min);
    }

    @Test
    public void delete()
    {
        hitNRun.create(value);
        hitNRun.create(value2);

        String element = value.getFine().getFineNum();

        hitNRun.delete(element);

        int amount = hitNRun.getAll().size();

        Assert.assertEquals(1,amount);

    }

    @Test
    public void read()
    {
        hitNRun.create(value);
        hitNRun.create(value2);

        String element = value.getFine().getFineNum();

        HitNRun min = hitNRun.read(element);

        Assert.assertEquals(value, min);
    }

    @Test
    public void getAll()
    {
        hitNRun.create(value);
        hitNRun.create(value2);

        int amount = hitNRun.getAll().size();

        Assert.assertEquals(2,amount);
    }
}