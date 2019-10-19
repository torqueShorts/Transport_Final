package Transport.Controller.VehicleControllers;

import Transport.Domain.Vehicles.Taxi;
import Transport.Service.VehicleServices.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Taxi")

public class TaxiController
{
    @Autowired
    @Qualifier("TaxiServiceImpl")

    private TaxiService service;


    @PostMapping("/create")
    @ResponseBody
    public Taxi create(Taxi taxi)
    {
        return service.create(taxi);
    }

    @PostMapping("/update")
    @ResponseBody
    public Taxi update(Taxi taxi)
    {
        return service.update(taxi);
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
    public ArrayList<Taxi> getAll()
    {
        return service.getAll();
    }
}
