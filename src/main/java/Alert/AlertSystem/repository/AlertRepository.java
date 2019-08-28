package Alert.AlertSystem.repository;


import Alert.AlertSystem.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    void deleteByName(Long id);
    Alert findByName(String alertName);
}
