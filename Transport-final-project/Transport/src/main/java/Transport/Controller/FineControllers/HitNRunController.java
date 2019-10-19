package Transport.Controller.FineControllers;


import Transport.Domain.Fines.MajorOffenses.HitNRun;
import Transport.Service.FineServices.HitNRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/HitNRun")

public class HitNRunController
{
    @Autowired
    @Qualifier("HitNRunServiceImpl")

    private HitNRunService service;


    @PostMapping("/create")
    @ResponseBody
    public HitNRun create(HitNRun hitNRun)
    {
        return service.create(hitNRun);
    }

    @PostMapping("/update")
    @ResponseBody
    public HitNRun update(HitNRun hitNRun)
    {
        return service.update(hitNRun);
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
    public ArrayList<HitNRun> getAll()
    {
        return service.getAll();
    }
}
