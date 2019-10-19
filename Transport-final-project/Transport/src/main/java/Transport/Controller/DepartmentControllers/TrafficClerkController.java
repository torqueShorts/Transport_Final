package Transport.Controller.DepartmentControllers;


import Transport.Domain.Department.TrafficClerk;
import Transport.Service.DepartmentServices.TrafficClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/TrafficClerk")

public class TrafficClerkController
{

    @Autowired
    @Qualifier("TrafficClerkServiceImpl")
    private TrafficClerkService service;


    @PostMapping("/create")
    @ResponseBody
    public TrafficClerk create(TrafficClerk clerk)
    {
        return service.create(clerk);
    }

    @PostMapping("/update")
    @ResponseBody
    public TrafficClerk update(TrafficClerk clerk)
    {
        return service.update(clerk);
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
    public ArrayList<TrafficClerk> getAll()
    {
        return service.getAll();
    }


}
