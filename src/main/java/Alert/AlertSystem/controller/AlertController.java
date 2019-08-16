package Alert.AlertSystem.controller;

import Alert.AlertSystem.model.Alert;
import Alert.AlertSystem.services.AlertService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    public class AlertController {
    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }
    @GetMapping("/alert")
    public List<Alert> getAlert(){
       return alertService.getAlert();
    }

    @PostMapping("/alert")
    public Alert addAlert(@RequestBody final Alert alert) {
        return    alertService.addAlert(alert);
    }
    @PutMapping("/alert")
    public  Alert updateAlert(@RequestBody final  Alert alert,@RequestParam String alertCode){
        return alertService.updateAlert(alert,alertCode);
    }

    @DeleteMapping("/alert")
    public void deleteAlert(@RequestParam final String alertCode){
       alertService.deleteAlert(alertCode);
    }

}
