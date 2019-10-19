package Transport.Service.DepartmentServices.Impl;

import Transport.Domain.Department.TrafficDepartment;
import Transport.Factory.DepartmentFactoryTests.TrafficDepartmentFactory;
import Transport.Repository.Impl.DepartmentRepoImplementations.TrafficDepartmentRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TrafficDepartmentServiceImplTest {

    private TrafficDepartmentRepositoryImpl repository;


    TrafficDepartmentFactory object = new TrafficDepartmentFactory();


    TrafficDepartment value = object.getTrafficDepartment("57 Adeline street", "DP2938");
    TrafficDepartment value2 = object.getTrafficDepartment("27 Sehara denzine", "RD3456");
    TrafficDepartment value3 = object.getTrafficDepartment("62 Adeline street", "DP2938");



    @Before
    public void setUp() throws Exception
    {
        this.repository = TrafficDepartmentRepositoryImpl.getRepo();
    }

    @Test
    public void getAll()
    {
        this.repository.create(value);
        this.repository.create(value2);
        ArrayList<TrafficDepartment> chiefs = this.repository.getAll();
        Assert.assertEquals(chiefs, this.repository.getAll());
    }

    @Test
    public void create()
    {
        TrafficDepartment created = this.repository.create(value);
        Assert.assertNotNull(created);
        Assert.assertEquals(created,this.repository.create(value));
    }

    @Test
    public void update()
    {
        this.repository.create(value);
        this.repository.create(value2);
        TrafficDepartment updated = this.repository.update(value3);

        Assert.assertEquals(value3, updated);
    }

    @Test
    public void delete()
    {
        this.repository.create(value);
        this.repository.create(value2);

        this.repository.delete(value.getDeptCode());
        int amount = this.repository.getAll().size();


        Assert.assertEquals(1, amount);
    }

    @Test
    public void read()
    {
        this.repository.create(value);
        TrafficDepartment saved = this.repository.read(value.getDeptCode());

        Assert.assertEquals(value, saved);
    }
}