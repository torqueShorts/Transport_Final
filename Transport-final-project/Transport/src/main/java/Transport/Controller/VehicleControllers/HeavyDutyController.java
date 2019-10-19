package Transport.Controller.VehicleControllers;


import Transport.Domain.Vehicles.HeavyDuty;
import Transport.Service.VehicleServices.HeavyDutyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/HeavyDuty")

public class HeavyDutyController
{
    @Autowired
    @Qualifier("HeavyDutyServiceImpl")

    private HeavyDutyServices service;


    @PostMapping("/create")
    @ResponseBody
    public HeavyDuty create(HeavyDuty heavyDuty)
    {
        return service.create(heavyDuty);
    }

    @PostMapping("/update")
    @ResponseBody
    public HeavyDuty update(HeavyDuty heavyDuty)
    {
        return service.update(heavyDuty);
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
    public ArrayList<HeavyDuty> getAll()
    {
        return service.getAll();
    }
}
