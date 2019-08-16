package Alert.AlertSystem.services;

import Alert.AlertSystem.model.Alert;
import Alert.AlertSystem.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@Transactional


public class AlertService {
    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public List<Alert> getAlert() {
        return alertRepository.findAll();
    }


    public Alert addAlert(final Alert alert){
        return alertRepository.save(alert);
    }

    public void deleteAlert(String alertCode){
        alertRepository.deletebyAlertCode(alertCode);
    }

    public Alert updateAlert(Alert alert,String alertCode){
        Alert alertFromDB= alertRepository.findbyAlertCode(alertCode);
        if(alertCode!=null){
        String url = alertFromDB.getUrl();
        alert.setUrl(url);
        return alertRepository.save(alert);
        }
        return null;
    }


}
