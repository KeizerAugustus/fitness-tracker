package nl.fitnessapp.ws.hallowereld;

import fitnesstracker.api.HallowereldApi;
import fitnesstracker.model.HalloWereld;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalloWereldController implements HallowereldApi {


    @Override
    public ResponseEntity<HalloWereld> geefHalloTerug() {
       HalloWereld halloWereld = new HalloWereld();
       halloWereld.setBericht("Ik leef!");

       return ResponseEntity.ok(halloWereld);
    }
}
