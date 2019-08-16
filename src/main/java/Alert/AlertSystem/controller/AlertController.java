package Alert.AlertSystem.controller;

import Alert.AlertSystem.model.Alert;
import Alert.AlertSystem.services.AlertService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlertController {
    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }


    @PostMapping("/alert")
    public Alert addAlert(@RequestBody final Alert alert) {
        return    alertService.addAlert(alert);
    }

}
