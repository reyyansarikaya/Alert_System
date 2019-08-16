package Alert.AlertSystem.repository;


import Alert.AlertSystem.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, String> {
    void deletebyAlertCode (String alertCode);
    Alert findbyAlertCode(String alertCode);
}
