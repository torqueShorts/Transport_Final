package Transport.Repository.Impl.ExternalRepoImplTests;

import Transport.Domain.External.Warrant;
import Transport.Factory.ExternalFactories.WarrantFactory;
import Transport.Repository.Impl.ExternalRepoImplementations.WarrantRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

public class WarrantRepositoryImplTest {

    WarrantRepositoryImpl warrant = WarrantRepositoryImpl.getRepo();
    WarrantFactory object = new WarrantFactory();

    Warrant value = object.getWarrant("RD2345", "08453627", "RC3627463", true);
    Warrant value2 = object.getWarrant("RD2672", "0817364", "RC7384003", true);
    Warrant value3 = object.getWarrant("RD2345", "08453627", "RC3627463", false);


    @Test
    public void create()
    {
        warrant.create(value);
        warrant.create(value2);

        int amount = warrant.getAll().size();

        Assert.assertEquals(2,amount);

    }

    @Test
    public void update()
    {
        warrant.create(value);
        warrant.create(value2);

        Warrant war =  warrant.update(value3);

        Assert.assertEquals(value3,war);

    }

    @Test
    public void delete()
    {
        warrant.create(value);
        warrant.create(value2);

        String element = value.getWarrantID();

        warrant.delete(element);

        int amount = warrant.getAll().size();

        Assert.assertEquals(1,amount);

    }

    @Test
    public void read()
    {
        warrant.create(value);
        warrant.create(value2);

        String element = value.getWarrantID();

        Warrant war = warrant.read(element);

        Assert.assertEquals(value, war);

    }

    @Test
    public void getAll()
    {
        warrant.create(value);
        warrant.create(value2);

        int amount = warrant.getAll().size();

        Assert.assertEquals(2,amount);

    }
}