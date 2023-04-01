package org.ddestrei.manager;

import lombok.extern.slf4j.Slf4j;
import org.ddestrei.client.Client;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ClientManager {
    int amountOfClients;
    ArrayList<Client> clients;

    RestTemplateBuilder restTemplateBuilder;
    RestTemplate restTemplate;
    String registerURL;
    String token;
    public ClientManager(int amountOfClients){
        this.restTemplateBuilder=new RestTemplateBuilder();
        this.restTemplate=restTemplateBuilder.build();
        this.registerURL = "http://localhost:8081/student/auth/register";
        registerToDb();
        this.amountOfClients = amountOfClients;
        this.clients = new ArrayList<>();
        for (int i=1;i<=amountOfClients;i++){
            Client client = new Client(i,token);
            clients.add(client);
        }
    }

    public void registerToDb(){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Patryk");
        map.put("email","ddestrei@gmail.com");
        map.put("password","12345");
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map, header);
        String response = this.restTemplate.postForObject(registerURL, entity, String.class);
        if(response!=null){
            //log.info("Response:"+response);
            token = response.substring(10,response.length() - 2);
            log.info("Token:"+token);
        }
        else {
            log.error("Sth goes wrong!!!");
        }
    }

    public void startRunning(){
        for (int i=0;i<amountOfClients;i++){
            Thread t = new Thread(clients.get(i));
            t.start();
        }
    }

    public void waitToEnd(){
        boolean isWorking=true;
        while (isWorking) {
            int workers=0;
            for(int i=0;i<clients.size(); i++){
                if(clients.get(i).isWorking) workers+=1;
            }
            if(workers==0) isWorking=false;
        }
    }
}
