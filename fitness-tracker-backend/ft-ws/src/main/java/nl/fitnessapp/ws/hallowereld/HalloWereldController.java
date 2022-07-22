package nl.fitnessapp.ws.hallowereld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "hallowereld")
public class HalloWereldController {

    @GetMapping
    public String halloWereld(){
        return "Ik leef!";
    }
}
