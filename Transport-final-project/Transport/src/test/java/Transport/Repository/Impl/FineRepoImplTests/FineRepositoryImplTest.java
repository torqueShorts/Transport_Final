package Transport.Repository.Impl.FineRepoImplTests;

import Transport.Domain.Fines.Fine;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Repository.Impl.FineRepoImplementations.FineRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

public class FineRepositoryImplTest {

    FineRepositoryImpl fine = FineRepositoryImpl.getRepo();
    FineFactory fi = new FineFactory();

    Fine value = fi.getFine("AR2390","AC7465993","081475354", "MinorOffence", false);
    Fine value2 = fi.getFine("BW37484","AC465498", "081374657", "MajorOffence", true);
    Fine value3 = fi.getFine("AR2390","AC461234", "081374657", "MinorOffence", false);

    @Test
    public void create()
    {
        fine.create(value);
        fine.create(value2);

        int amount = fine.getAll().size();

        Assert.assertEquals(2, amount);

    }

    @Test
    public void update()
    {
        fine.create(value);
        fine.create(value2);

        Fine fin = fine.update(value3);

        Assert.assertEquals(value3, fin);

    }

    @Test
    public void delete()
    {
        fine.create(value);
        fine.create(value2);

        String element = value.getDriverID();

        fine.delete(element);

        int amount = fine.getAll().size();

        Assert.assertEquals(1,amount);

    }

    @Test
    public void read()
    {
        fine.create(value);
        fine.create(value2);

        String element = value.getDriverID();

        Fine fineValue = fine.read(element);

        Assert.assertEquals(value, fineValue);
    }

    @Test
    public void getAll()
    {
        fine.create(value);
        fine.create(value2);

        int amount = fine.getAll().size();

        Assert.assertEquals(2, amount);

    }
}