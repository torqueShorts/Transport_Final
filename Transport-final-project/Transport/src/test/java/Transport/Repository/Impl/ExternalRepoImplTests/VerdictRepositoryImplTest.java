package Transport.Repository.Impl.ExternalRepoImplTests;

import Transport.Domain.External.Verdict;
import Transport.Factory.ExternalFactories.VerdictFactory;
import Transport.Repository.Impl.ExternalRepoImplementations.VerdictRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

public class VerdictRepositoryImplTest {

    VerdictRepositoryImpl verdict = VerdictRepositoryImpl.getRepo();
    VerdictFactory object = new VerdictFactory();

    Verdict value = object.getVerdict("RC2345", false, 300, true);
    Verdict value2 = object.getVerdict("RD7435", true, 400, false);
    Verdict value3 = object.getVerdict("RC2345", true, 200, false);


    @Test
    public void create()
    {
        verdict.create(value);
        verdict.create(value2);

        int amount = verdict.getAll().size();

        Assert.assertEquals(2, amount);

    }

    @Test
    public void update()
    {
        verdict.create(value);
        verdict.create(value2);

        Verdict verd = verdict.update(value3);

        Assert.assertEquals(value3, verd);

    }

    @Test
    public void delete()
    {
        verdict.create(value);
        verdict.create(value2);

        String element = value.getFineNum();

        verdict.delete(element);

        int amount = verdict.getAll().size();

        Assert.assertEquals(1,amount);

    }

    @Test
    public void read()
    {
        verdict.create(value);
        verdict.create(value2);

        String element = value.getFineNum();

        Verdict verd = verdict.read(element);

        Assert.assertEquals(value, verd);

    }

    @Test
    public void getAll()
    {
        verdict.create(value);
        verdict.create(value2);

        int amount = verdict.getAll().size();

        Assert.assertEquals(2,amount);
    }
}