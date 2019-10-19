package Transport.Controller.DriverControllers;


import Transport.Domain.Drivers.NationalDriver;
import Transport.Service.DriverServices.NationalDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/NationalDriver")

public class NationalDriverController
{
    @Autowired
    @Qualifier("NationalDriverServiceImpl")

    private NationalDriverService service;


    @PostMapping("/create")
    @ResponseBody
    public NationalDriver create(NationalDriver driver)
    {
        return service.create(driver);
    }

    @PostMapping("/update")
    @ResponseBody
    public NationalDriver update(NationalDriver driver)
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
    public ArrayList<NationalDriver> getAll()
    {
        return service.getAll();
    }
}
