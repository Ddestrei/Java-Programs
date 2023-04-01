package org.ddestrei;

import lombok.extern.slf4j.Slf4j;
import org.ddestrei.client.Client;
import org.ddestrei.manager.ClientManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Slf4j
public class ClientManagerMain {
    public static void main(String[] args) throws IOException {
        //checkConnection();
        ClientManager clientManager = new ClientManager(20);
        long start = System.currentTimeMillis();
        clientManager.startRunning();
        clientManager.waitToEnd();
        long stop = System.currentTimeMillis();
        long timeElapsed=stop - start;
        log.info("It take a : "+timeElapsed);
    }
    public static void checkConnection(){
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "http://localhost:8080/api/v1/student/HelloWorld";
        log.info(restTemplate.getForObject(url, String.class));
    }
}
