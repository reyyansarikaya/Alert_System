package Alert.AlertSystem.services;

import Alert.AlertSystem.model.Alert;
import Alert.AlertSystem.model.Result;
import Alert.AlertSystem.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Configuration
@EnableAsync
public class Request {


    private final AlertRepository alertRepository;

    @Async
    public void sendRequest(Alert alert){
        SimpleDateFormat sfDate = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        Date nowDate = new Date();
        String Date =sfDate.format(nowDate);
        try{
            URL url = new URL(alert.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(alert.getMethod());
            connection.connect();
            Result resultSuc = new Result(null,1,nowDate,connection.getResponseMessage());
        }
        catch(Exception e){
            Result result = new Result(null,0,nowDate,e.getMessage());
        }
           
                    

    }
}
