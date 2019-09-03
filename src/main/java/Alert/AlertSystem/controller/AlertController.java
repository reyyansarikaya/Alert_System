package Alert.AlertSystem.controller;

import Alert.AlertSystem.model.Alert;
import Alert.AlertSystem.services.AlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping("/alert")
    public List<Alert> getAlerts() {
        return alertService.getAlert();
    }

    @GetMapping("/alert/{alertName}")
    public Alert getAlert(@PathVariable String alertName) {
        return alertService.getAlertByName(alertName);
    }

    @PostMapping("/alert")
    public Alert addAlert(@RequestBody final Alert alert) throws Exception {
        if(alert.getPeriyod() == null) throw new Exception();
        return alertService.addAlert(alert);
    }

    @DeleteMapping("/alert")
    public void deleteAlert(@RequestParam final Long id) {
        alertService.deleteAlert(id);
    }
  /*@PutMapping("/alert")
    public Alert updateAlert(@RequestBody final Alert alert, @RequestParam Long id) {
        return alertService.updateAlert(alert, id);
    }*/
}
