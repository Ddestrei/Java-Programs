package org.ddestrei.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Slf4j
public class Client implements Runnable {
    int id;
    int amountOperations;
    RestTemplateBuilder restTemplateBuilder;
    RestTemplate restTemplate;
    ClientData data;
    String addUrl;
    String changeUrl;
    String deleteUrl;
    public boolean isWorking=false;
    String token;
    public Client(int id,String token){
        this.id = id;
        this.data = new ClientData();
        this.createData();
        this.restTemplateBuilder=new RestTemplateBuilder();
        this.restTemplate=restTemplateBuilder.build();
        this.addUrl="http://localhost:8081/api/v1/student/addStudent";
        this.changeUrl="http://localhost:8081/api/v1/student/changeData?email=";
        this.deleteUrl="http://localhost:8081/api/v1/student/deleteStudentByEmail?email=";
        this.token=token;
    }
    @Override
    public void run() {
        isWorking=true;
        this.addToDatabase();
        for (int i=0;i<10;i++){
            this.changeData();
            //log.info("Data has changed a {} times", i+1);
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.removeFromDatabase();
        isWorking=false;
    }

    public void createData(){
        Random rand = new Random();
        int x=rand.nextInt(1000000);
        data.setEmail(String.valueOf(x/10));
        data.setSurname(String.valueOf(x/100));
        data.setName(String.valueOf(x/1000));
        data.setAge(rand.nextInt(x/10000));
    }

    public void addToDatabase(){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        header.setBearerAuth(this.token);

        Map<String, Object> map = new HashMap<>();
        map.put("name", this.data.getName());
        map.put("surname", this.data.getSurname());
        map.put("age", this.data.getAge());
        map.put("email",this.data.getEmail());
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map, header);
        String response = this.restTemplate.postForObject(addUrl, entity, String.class);
        log.info("Student has been added to db with this email: {}", data.getEmail());
    }
    public void changeData(){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        header.setBearerAuth(this.token);

        Map<String, Object> map = new HashMap<>();
        map.put("name", this.data.getName());
        map.put("surname", this.data.getSurname());
        map.put("age", this.data.getAge());
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map, header);
        this.restTemplate.postForObject(changeUrl+this.data.getEmail(), entity, String.class);
    }
    public void removeFromDatabase(){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        header.setBearerAuth(this.token);

        Map<String, Object> map = new HashMap<>();
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map, header);
        this.restTemplate.exchange(deleteUrl+this.data.getEmail(),HttpMethod.DELETE,entity,String.class);
    }

}
