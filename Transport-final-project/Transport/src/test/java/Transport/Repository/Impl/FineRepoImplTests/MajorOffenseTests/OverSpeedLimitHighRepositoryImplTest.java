package Transport.Repository.Impl.FineRepoImplTests.MajorOffenseTests;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MajorOffenses.OverSpeedLimitHigh;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MajorOffenses.OverSpeedLimitHighFactory;
import Transport.Repository.Impl.FineRepoImplementations.MajorOffenses.OverSpeedLimitHighRepositoryImpl;
import Transport.Repository.Repositories.FineRepositories.OverSpeedLimitHighRepository;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OverSpeedLimitHighRepositoryImplTest {

    OverSpeedLimitHighRepositoryImpl over = OverSpeedLimitHighRepositoryImpl.getRepo();
    OverSpeedLimitHighFactory object = new OverSpeedLimitHighFactory();

    FineFactory fine = new FineFactory();

    Fine fin = fine.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);
    Fine fin2 = fine.getFine("AR56784", "BC7859", "0827684", "MinorOffence", false);
    Fine fin3 = fine.getFine("AR56784", "BC7859", "0827684", "MinorOffence", false);

    OverSpeedLimitHigh value = object.getOverSpeedLimit(60,100,"07/03/1990",fin);
    OverSpeedLimitHigh value2 = object.getOverSpeedLimit(60,120,"07/03/1990",fin2);
    OverSpeedLimitHigh value3 = object.getOverSpeedLimit(60,110,"07/03/1990",fin2);




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

        OverSpeedLimitHigh min = over.update(value3);

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

        OverSpeedLimitHigh min = over.read(element);

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