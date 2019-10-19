package Transport.Controller.VehicleControllers;

import Transport.Domain.Vehicles.Car;
import Transport.Service.VehicleServices.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Car")

public class CarController
{
    @Autowired
    @Qualifier("CarServiceImpl")

    private CarService service;


    @PostMapping("/create")
    @ResponseBody
    public Car create(Car car)
    {
        return service.create(car);
    }

    @PostMapping("/update")
    @ResponseBody
    public Car update(Car car)
    {
        return service.update(car);
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
    public ArrayList<Car> getAll()
    {
        return service.getAll();
    }
}
