package Transport.Controller.VehicleControllers;

import Transport.Domain.Vehicles.Motorbike;
import Transport.Repository.Repositories.VehicleRepositories.MotorbikeRepository;
import Transport.Service.VehicleServices.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Motorbike")

public class MotorbikeController
{
    @Autowired
    @Qualifier("MotorbikeServiceImpl")

    private MotorbikeService service;


    @PostMapping("/create")
    @ResponseBody
    public Motorbike create(Motorbike motorbike)
    {
        return service.create(motorbike);
    }

    @PostMapping("/update")
    @ResponseBody
    public Motorbike update(Motorbike motorbike)
    {
        return service.update(motorbike);
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
    public ArrayList<Motorbike> getAll()
    {
        return service.getAll();
    }
}
