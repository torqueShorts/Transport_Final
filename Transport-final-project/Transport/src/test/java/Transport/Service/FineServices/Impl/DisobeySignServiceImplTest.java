package Transport.Service.FineServices.Impl;

import Transport.Domain.Fines.Fine;
import Transport.Domain.Fines.MinorOffenses.DisobeySigns;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MinorOffenses.DisobeySignsFactory;
import Transport.Repository.Impl.FineRepoImplementations.MinorOffenses.DisobeySignRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DisobeySignServiceImplTest {


    private DisobeySignRepositoryImpl repository;

    DisobeySignsFactory object = new DisobeySignsFactory();

    FineFactory fine = new FineFactory();

    Fine fin = fine.getFine("AR34895", "BC37584", "0817586", "MinorOffence", false);
    Fine fin2 = fine.getFine("AR56784", "BC7859", "0827684", "MinorOffence", false);

    DisobeySigns value = object.getDisobeySign("OverSpeedLimitLow",100, fin);
    DisobeySigns value2 = object.getDisobeySign("DisobeySign",200,fin2);
    DisobeySigns value3 = object.getDisobeySign("DisobeySign",300,fin2);


    @Before
    public void setUp() throws Exception
    {
        this.repository = DisobeySignRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<DisobeySigns> courts = this.repository.getAll();
        Assert.assertEquals(courts, this.repository.getAll());
    }

    @Test
    public void create()
    {
        DisobeySigns created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        DisobeySigns updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getFine().getFineNum());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        DisobeySigns saved = this.repository.read(value.getFine().getFineNum());

        Assert.assertEquals(value, saved);
    }
}