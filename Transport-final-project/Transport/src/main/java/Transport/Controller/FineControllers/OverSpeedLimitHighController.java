package Transport.Controller.FineControllers;

import Transport.Domain.Fines.MajorOffenses.OverSpeedLimitHigh;
import Transport.Service.FineServices.OverSpeedLimitHighService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/OverSpeedLimitHigh")

public class OverSpeedLimitHighController
{
    @Autowired
    @Qualifier("OverSpeedLimitHighServiceImpl")

    private OverSpeedLimitHighService service;


    @PostMapping("/create")
    @ResponseBody
    public OverSpeedLimitHigh create(OverSpeedLimitHigh overSpeedLimitHigh)
    {
        return service.create(overSpeedLimitHigh);
    }

    @PostMapping("/update")
    @ResponseBody
    public OverSpeedLimitHigh update(OverSpeedLimitHigh overSpeedLimitHigh)
    {
        return service.update(overSpeedLimitHigh);
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
    public ArrayList<OverSpeedLimitHigh> getAll()
    {
        return service.getAll();
    }
}
