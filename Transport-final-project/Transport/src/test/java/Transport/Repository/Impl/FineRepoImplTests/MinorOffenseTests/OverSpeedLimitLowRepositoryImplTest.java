package Transport.Repository.Impl.FineRepoImplTests.MinorOffenseTests;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MinorOffenses.OverSpeedLimitLow;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MinorOffenses.OverSpeedLimitLowFactory;
import Transport.Repository.Impl.FineRepoImplementations.MajorOffenses.OverSpeedLimitHighRepositoryImpl;
import Transport.Repository.Impl.FineRepoImplementations.MinorOffenses.OverSpeedLimitLowRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OverSpeedLimitLowRepositoryImplTest {

    OverSpeedLimitLowRepositoryImpl over = OverSpeedLimitLowRepositoryImpl.getRepo();
    OverSpeedLimitLowFactory object = new OverSpeedLimitLowFactory();

    FineFactory fine = new FineFactory();

    Fine fin = fine.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);
    Fine fin2 = fine.getFine("AR56784", "BC7859", "0827684", "MinorOffence", false);
    Fine fin3 = fine.getFine("AR56784", "BC7859", "0827684", "MinorOffence", false);

    OverSpeedLimitLow value = object.getOverSpeedLimitLow(60,100,300,fin);
    OverSpeedLimitLow value2 = object.getOverSpeedLimitLow(80, 90,500,fin2);
    OverSpeedLimitLow value3 = object.getOverSpeedLimitLow(60,80,600,fin3);



    @Test
    public void create()
    {
        over.create(value);
        over.create(value2);

        int amount = over.getAll().size();

        Assert.assertEquals(2,amount);
    }

    @Test
    public void update()
    {
        over.create(value);
        over.create(value2);

        OverSpeedLimitLow min = over.update(value3);

        Assert.assertEquals(value3, min);
    }

    @Test
    public void delete()
    {
        over.create(value);
        over.create(value2);

        String element = value.getFine().getFineNum();

        over.delete(element);

        int amount = over.getAll().size();

        Assert.assertEquals(1,amount);
    }

    @Test
    public void read()
    {
        over.create(value);
        over.create(value2);

        String element = value.getFine().getFineNum();

        OverSpeedLimitLow min = over.read(element);

        Assert.assertEquals(value, min);
    }

    @Test
    public void getAll()
    {
        over.create(value);
        over.create(value2);

        int amount = over.getAll().size();

        Assert.assertEquals(2,amount);
    }
}