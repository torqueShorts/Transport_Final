package Transport.Service.ExternalServices.Impl;

import Transport.Domain.External.Verdict;
import Transport.Factory.ExternalFactories.VerdictFactory;
import Transport.Repository.Impl.ExternalRepoImplementations.VerdictRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class VerdictServiceImplTest {

    private VerdictRepositoryImpl repository;

    VerdictFactory object = new VerdictFactory();

    Verdict value = object.getVerdict("RC2345", false, 300, true);
    Verdict value2 = object.getVerdict("RD7435", true, 400, false);
    Verdict value3 = object.getVerdict("RC2345", true, 200, false);

    @Before
    public void setUp() throws Exception
    {
        this.repository = VerdictRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<Verdict> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        Verdict created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        Verdict updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getFineNum());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        Verdict saved = this.repository.read(value.getFineNum());

        Assert.assertEquals(value, saved);
    }
}