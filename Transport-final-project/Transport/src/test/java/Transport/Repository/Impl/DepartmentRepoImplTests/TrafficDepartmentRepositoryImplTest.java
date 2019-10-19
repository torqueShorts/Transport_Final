package Transport.Repository.Impl.DepartmentRepoImplTests;

import Transport.Domain.Department.TrafficDepartment;
import Transport.Factory.DepartmentFactoryTests.TrafficDepartmentFactory;
import Transport.Repository.Impl.DepartmentRepoImplementations.TrafficDepartmentRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrafficDepartmentRepositoryImplTest
{
    TrafficDepartmentRepositoryImpl department = TrafficDepartmentRepositoryImpl.getRepo();
    TrafficDepartmentFactory object = new TrafficDepartmentFactory();

    TrafficDepartment value = object.getTrafficDepartment("57 Adeline street", "DP2938");
    TrafficDepartment value2 = object.getTrafficDepartment("27 Sehara denzine", "RD3456");
    TrafficDepartment value3 = object.getTrafficDepartment("62 Adeline street", "DP2938");


    @Test
    public void create()
    {
        department.create(value);
        department.create(value2);

        int amount = department.getAll().size();

        Assert.assertEquals(2,amount);
    }

    @Test
    public void update()
    {
        department.create(value);
        department.create(value2);

        TrafficDepartment depart = department.update(value3);

        Assert.assertEquals(value3,depart);

    }

    @Test
    public void delete()
    {
        department.create(value);
        department.create(value2);

        String element = value.getDeptCode();

        department.delete(element);

        int amount = department.getAll().size();

        Assert.assertEquals(1,amount);

    }

    @Test
    public void read()
    {
        department.create(value);
        department.create(value2);

        String element = value.getDeptCode();

        TrafficDepartment trafValue = department.read(element);

        Assert.assertEquals(department, trafValue);

    }

    @Test
    public void getAll()
    {
        department.create(value);
        department.create(value2);

        int amount = department.getAll().size();

        Assert.assertEquals(2,amount);
    }




}