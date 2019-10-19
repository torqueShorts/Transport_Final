package Transport.Repository.Impl.ExternalRepoImplTests;

import Transport.Domain.External.Court;
import Transport.Factory.ExternalFactories.CourtFactory;
import Transport.Repository.Impl.ExternalRepoImplementations.CourtRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourtRepositoryImplTest {


    CourtRepositoryImpl court = CourtRepositoryImpl.getRepo();
    CourtFactory object = new CourtFactory();

    Court value = object.getCourt("Larrisons Court","AR3456", "Lucas Ericson");
    Court value2 = object.getCourt("SmithenWest Court", "AT3746", "John Doe");
    Court value3 = object.getCourt("JohnRiften Court", "AR7869", "Jeff Jeff");


    @Test
    public void create()
    {
        court.create(value);
        court.create(value2);

        int amount = court.getAll().size();

        Assert.assertEquals(2, amount);
    }

    @Test
    public void update()
    {
        court.create(value);
        court.create(value2);

        Court pay = court.update(value3);

        Assert.assertEquals(value3, pay);

    }

    @Test
    public void delete()
    {
        court.create(value);
        court.create(value2);

        String element = value.getCourtName();

        court.delete(element);

        int amount = court.getAll().size();

        Assert.assertEquals(1,amount);
    }

    @Test
    public void read()
    {
        court.create(value);
        court.create(value2);

        String element = value.getCourtName();

        Court payValue = court.read(element);

        Assert.assertEquals(value, payValue);
    }

    @Test
    public void getAll()
    {
        court.create(value);
        court.create(value2);

        int amount = court.getAll().size();

        Assert.assertEquals(2,amount);
    }
}