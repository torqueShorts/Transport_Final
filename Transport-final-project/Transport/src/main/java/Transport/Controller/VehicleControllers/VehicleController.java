package Transport.Controller.VehicleControllers;

import Transport.Domain.Vehicles.Vehicle;
import Transport.Service.VehicleServices.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Vehicle")

public class VehicleController
{
    @Autowired
    @Qualifier("VehicleServiceImpl")

    private VehicleService service;


    @PostMapping("/create")
    @ResponseBody
    public Vehicle create(Vehicle vehicle)
    {
        return service.create(vehicle);
    }

    @PostMapping("/update")
    @ResponseBody
    public Vehicle update(Vehicle vehicle)
    {
        return service.update(vehicle);
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
    public ArrayList<Vehicle> getAll()
    {
        return service.getAll();
    }
}
