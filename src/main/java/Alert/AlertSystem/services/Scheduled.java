package Alert.AlertSystem.services;

import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling

public class Scheduled {
    @org.springframework.scheduling.annotation.Scheduled(fixedRate = 1000)
    public void sendSecheduled(){

    }
}
