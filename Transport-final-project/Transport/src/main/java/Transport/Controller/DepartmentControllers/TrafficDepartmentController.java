package Transport.Controller.DepartmentControllers;

import Transport.Domain.Department.TrafficDepartment;
import Transport.Service.DepartmentServices.TrafficDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/TrafficDepartment")

public class TrafficDepartmentController
{
    @Autowired
    @Qualifier("TrafficDepartmentServiceImpl")
    private TrafficDepartmentService service;


    @PostMapping("/create")
    @ResponseBody
    public TrafficDepartment create(TrafficDepartment department)
    {
        return service.create(department);
    }

    @PostMapping("/update")
    @ResponseBody
    public TrafficDepartment update(TrafficDepartment department)
    {
        return service.update(department);
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
    public ArrayList<TrafficDepartment> getAll()
    {
        return service.getAll();
    }

}
