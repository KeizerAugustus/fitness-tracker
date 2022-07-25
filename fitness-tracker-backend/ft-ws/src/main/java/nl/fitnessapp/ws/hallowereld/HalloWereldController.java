package nl.fitnessapp.ws.hallowereld;

import nl.fitnessapp.api.HallowereldApi;
import nl.fitnessapp.model.HalloWereld;
import org.springframework.http.ResponseEntity;
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
