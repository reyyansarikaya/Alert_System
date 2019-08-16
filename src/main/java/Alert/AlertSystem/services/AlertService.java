package Alert.AlertSystem.services;

import Alert.AlertSystem.model.Alert;
import Alert.AlertSystem.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional


public class AlertService {
    private final AlertRepository alertRepository;
    public List<Alert> getAlert() {
        return alertRepository.findAll();}

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }
    public Alert addAlert(final Alert alert){
        return     alertRepository.save(alert);
    }


}
