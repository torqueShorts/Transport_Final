package Transport.Controller.VehicleControllers;

import Transport.Domain.Vehicles.Bus;
import Transport.Service.VehicleServices.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Bus")

public class BusController
{
    @Autowired
    @Qualifier("BusServiceImpl")

    private BusService service;


    @PostMapping("/create")
    @ResponseBody
    public Bus create(Bus bus)
    {
        return service.create(bus);
    }

    @PostMapping("/update")
    @ResponseBody
    public Bus update(Bus bus)
    {
        return service.update(bus);
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
    public ArrayList<Bus> getAll()
    {
        return service.getAll();
    }
}
