package Transport.Controller.DriverControllers;

import Transport.Domain.Drivers.InternationalDriver;
import Transport.Service.DriverServices.InternationalDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/InternationalDriver")

public class InternationalDriverController
{
    @Autowired
    @Qualifier("InternationalDriverServiceImpl")

    private InternationalDriverService service;


    @PostMapping("/create")
    @ResponseBody
    public InternationalDriver create(InternationalDriver driver)
    {
        return service.create(driver);
    }

    @PostMapping("/update")
    @ResponseBody
    public InternationalDriver update(InternationalDriver driver)
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
    public ArrayList<InternationalDriver> getAll()
    {
        return service.getAll();
    }
}
