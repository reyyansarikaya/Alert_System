package Alert.AlertSystem.services;

import Alert.AlertSystem.model.Alert;
import Alert.AlertSystem.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@EnableScheduling
public class Scheduler {
    final Request request;
    final AlertRepository alertRepository;

    @Scheduled(fixedRate = 1000)
    public void sendScheduled(){
        List<Alert> alerts=alertRepository.findAll();
        for(Alert alert:alerts){

            if(alert.getRemaning_time()==0L){
                request.sendRequest(alert);
            }
            else{
                alert.setRemaning_time(alert.getRemaning_time() -1L);
                alertRepository.save(alert);
            }
        }


    }
}
