package Transport.Controller.DepartmentControllers;

import Transport.Domain.Department.TrafficOfficer;
import Transport.Service.DepartmentServices.TrafficOfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/TrafficOfficer")

public class TrafficOfficerController
{
    @Autowired
    @Qualifier("TrafficOfficerServiceImpl")
    private TrafficOfficerService service;


    @PostMapping("/create")
    @ResponseBody
    public TrafficOfficer create(TrafficOfficer officer)
    {
        return service.create(officer);
    }

    @PostMapping("/update")
    @ResponseBody
    public TrafficOfficer update(TrafficOfficer officer)
    {
        return service.update(officer);
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
    public ArrayList<TrafficOfficer> getAll()
    {
        return service.getAll();
    }

}
