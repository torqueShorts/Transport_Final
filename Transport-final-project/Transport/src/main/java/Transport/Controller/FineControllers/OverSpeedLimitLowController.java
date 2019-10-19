package Transport.Controller.FineControllers;

import Transport.Domain.Fines.MinorOffenses.OverSpeedLimitLow;
import Transport.Service.FineServices.OverSpeedLimitLowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/OverSpeedLimitLow")

public class OverSpeedLimitLowController
{
    @Autowired
    @Qualifier("OverSpeedLimitLowServiceImpl")

    private OverSpeedLimitLowService service;


    @PostMapping("/create")
    @ResponseBody
    public OverSpeedLimitLow create(OverSpeedLimitLow overSpeedLimitLow)
    {
        return service.create(overSpeedLimitLow);
    }

    @PostMapping("/update")
    @ResponseBody
    public OverSpeedLimitLow update(OverSpeedLimitLow overSpeedLimitLow)
    {
        return service.update(overSpeedLimitLow);
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
    public ArrayList<OverSpeedLimitLow> getAll()
    {
        return service.getAll();
    }
}
