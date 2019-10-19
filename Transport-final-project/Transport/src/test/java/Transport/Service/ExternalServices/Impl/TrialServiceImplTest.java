package Transport.Service.ExternalServices.Impl;

import Transport.Domain.External.Trial;
import Transport.Factory.ExternalFactories.TrialFactory;
import Transport.Repository.Impl.ExternalRepoImplementations.TrialRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TrialServiceImplTest {

    private TrialRepositoryImpl repository;

    TrialFactory object = new TrialFactory();

    Trial value = object.getTrial("RC2345", "12/08/2019", "0818274", "ARD12737");
    Trial value2 = object.getTrial("RA74739", "13/10/2019", "0828444", "AEW993843");
    Trial value3 = object.getTrial("RC2345", "12/08/2019", "0818274", "AET64857");


    @Before
    public void setUp() throws Exception
    {
        this.repository = TrialRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<Trial> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        Trial created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        Trial updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getTrialID());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        Trial saved = this.repository.read(value.getTrialID());

        Assert.assertEquals(value, saved);
    }
}