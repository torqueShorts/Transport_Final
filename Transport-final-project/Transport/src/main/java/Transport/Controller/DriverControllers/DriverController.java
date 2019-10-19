package Transport.Controller.DriverControllers;

import Transport.Domain.Drivers.Driver;
import Transport.Repository.Repositories.DriverRepositories.DriverRepository;
import Transport.Service.DriverServices.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Driver")

public class DriverController
{
    @Autowired
    @Qualifier("DriverServiceImpl")
    private DriverService service;


    @PostMapping("/create")
    @ResponseBody
    public Driver create(Driver driver)
    {
        return service.create(driver);
    }

    @PostMapping("/update")
    @ResponseBody
    public Driver update(Driver driver)
    {
        return service.update(driver);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id)
    {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public void read(@PathVariable String id)
    {
        service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public ArrayList<Driver> getAll()
    {
        return service.getAll();
    }

}
