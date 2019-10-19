package Transport.Repository.Impl.ExternalRepoImplTests;

import Transport.Domain.External.Trial;
import Transport.Factory.ExternalFactories.TrialFactory;
import Transport.Repository.Impl.ExternalRepoImplementations.TrialRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

public class TrialRepositoryImplTest {

    TrialRepositoryImpl trial = TrialRepositoryImpl.getRepo();
    TrialFactory object = new TrialFactory();

    Trial value = object.getTrial("RC2345", "12/08/2019", "0818274", "ARD12737");
    Trial value2 = object.getTrial("RA74739", "13/10/2019", "0828444", "AEW993843");
    Trial value3 = object.getTrial("RC2345", "12/08/2019", "0818274", "AET64857");


    @Test
    public void create()
    {
        trial.create(value);
        trial.create(value2);

        int amount = trial.getAll().size();

        Assert.assertEquals(2,amount);

    }

    @Test
    public void update()
    {
        trial.create(value);
        trial.create(value2);

        Trial tri = trial.update(value3);

        Assert.assertEquals(value3,tri);

    }

    @Test
    public void delete()
    {
        trial.create(value);
        trial.create(value2);

        String element = value.getTrialID();

        trial.delete(element);

        int amount = trial.getAll().size();

        Assert.assertEquals(1,amount);

    }

    @Test
    public void read()
    {
        trial.create(value);
        trial.create(value2);

        String element = value.getTrialID();

        Trial tri = trial.read(element);

        Assert.assertEquals(value, tri);

    }

    @Test
    public void getAll()
    {
        trial.create(value);
        trial.create(value2);

        int amount = trial.getAll().size();

        Assert.assertEquals(2,amount);
    }
}