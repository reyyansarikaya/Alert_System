package Alert.AlertSystem.services;

import Alert.AlertSystem.model.Alert;
import Alert.AlertSystem.repository.AlertRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void deleteAlert(Long id){
        alertRepository.deleteByName(id);
    }

    public Alert updateAlert(Alert alert,Long id){
        Alert alertFromDB= alertRepository.findByName(id);
        if(alertFromDB!=null){
            id = alertFromDB.getId();
        alert.setId(id);
        return alertRepository.save(alert);
        }
        return null;
    }


}
