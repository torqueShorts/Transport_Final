package Transport.Controller.DepartmentControllers;


import Transport.Domain.Department.TrafficChief;
import Transport.Service.DepartmentServices.TrafficChiefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/TrafficChief")
public class TrafficChiefController
{
    @Autowired
    @Qualifier("TrafficChiefServiceImpl")
    private TrafficChiefService service;


    @PostMapping("/create")
    @ResponseBody
    public TrafficChief create(TrafficChief chief)
    {
        return service.create(chief);
    }

    @PostMapping("/update")
    @ResponseBody
    public TrafficChief update(TrafficChief chief)
    {
        return service.update(chief);
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
    public ArrayList<TrafficChief> getAll()
    {
        return service.getAll();
    }




}
