package Alert.AlertSystem.services;

import Alert.AlertSystem.model.Alert;
import Alert.AlertSystem.model.Result;
import Alert.AlertSystem.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
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
    public void sendRequest(Alert alert)  {
        SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date();
        String Date = sfDate.format(nowDate);
        try {
            URL url = new URL(alert.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(alert.getMethod());
            connection.connect();
            System.out.println("Status : " + connection.getResponseCode());

            if (connection.getResponseCode()>=200&&connection.getResponseCode()<=300) {

                Result resultSuc = new Result(null, 1, nowDate, connection.getResponseMessage());
                alert.getResult().add(resultSuc);
            }
            else{
                Result resultErr1 = new Result(null, 0, nowDate, connection.getResponseMessage());
                alert.getResult().add(resultErr1);
                System.out.println("Error : "+connection.getResponseCode());

            }
        }
        catch (Exception e) {


            Result resultErr = new Result(null, 0, nowDate, e.getMessage());
            alert.getResult().add(resultErr);
            System.out.println("Error : ");
        }
        alert.setRemaning_time(alert.getPeriyod());
        alertRepository.save(alert);

    }





}

