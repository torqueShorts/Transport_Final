package Transport.Repository.Impl.FineRepoImplTests.MajorOffenseTests;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MajorOffenses.MajorOffense;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MajorOffenses.MajorOffenseFactory;
import Transport.Repository.Impl.FineRepoImplementations.MajorOffenses.MajorOffenceRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

public class MajorOffenceRepositoryImplTest {

    MajorOffenceRepositoryImpl majorFines = MajorOffenceRepositoryImpl.getRepo();
    MajorOffenseFactory object = new MajorOffenseFactory();

    FineFactory fine = new FineFactory();

    Fine fin = fine.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);
    Fine fin2 = fine.getFine("AR56784", "BC7859", "0827684", "MinorOffence", false);

    MajorOffense value = object.getMajorOffense("OverSpeedLimitLow", fin);
    MajorOffense value2 = object.getMajorOffense("DisobeySign",fin2);
    MajorOffense value3 = object.getMajorOffense("DisobeySign",fin2);


    @Test
    public void create()
    {
            majorFines.create(value);
            majorFines.create(value2);

            int amount = majorFines.getAll().size();

            Assert.assertEquals(2,amount);
    }

    @Test
    public void update()
    {
        majorFines.create(value);
        majorFines.create(value2);

        MajorOffense maj = majorFines.update(value3);

        Assert.assertEquals(value3, maj);
    }

    @Test
    public void delete()
    {
        majorFines.create(value);
        majorFines.create(value2);

        String element = value.getFine().getFineNum();

        majorFines.delete(element);

        int amount = majorFines.getAll().size();

        Assert.assertEquals(1,amount);

    }

    @Test
    public void read()
    {
        majorFines.create(value);
        majorFines.create(value2);

        String element = value.getFine().getFineNum();

        MajorOffense maj = majorFines.read(element);

        Assert.assertEquals(value, maj);

    }

    @Test
    public void getAll()
    {
        majorFines.create(value);
        majorFines.create(value2);

        int amount = majorFines.getAll().size();

        Assert.assertEquals(2,amount);



    }
}