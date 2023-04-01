package org.ddestrei.p.starter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class Starter {
    String token;
    RestTemplate restTemplate;
    HttpHeaders header;
    private final String registerURL= "http://localhost:8080/auth/postService/register";
    private final String addPostURL= "http://localhost:8080/post/add";
    private final String addCommentURL= "http://localhost:8080/post/addComment?id=";
    public  void start(){
        this.token=null;
        this.header=new HttpHeaders();
        this.restTemplate= new RestTemplate();
        this.header.setContentType(MediaType.APPLICATION_JSON);
        this.header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        this.loginToService();
        this.addPostsWithComment();
    }
    private void loginToService(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Patryk");
        map.put("email", "ddestrei@gmail.com");
        map.put("password", "test");
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map, header);
        String bearerToken = restTemplate.postForObject(registerURL, entity, String.class);
        if(bearerToken!=null) {
            this.token = bearerToken.substring(10, bearerToken.length() - 2);
            System.out.println("##############################:"+this.token+":##############################");
        }
        else {
            throw new IllegalArgumentException("TOKEN IS NULL!!!");
        }
    }
    private void addPostsWithComment(){
        for (int i=0;i<10;i++){
            Map<String, Object> map = new HashMap<>();
            map.put("title", "Title-"+i);
            map.put("content", "Content-"+i);
            map.put("createTime", LocalDateTime.now());
            this.header.setBearerAuth(this.token);
            HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map, header);
            restTemplate.postForObject(addPostURL, entity, String.class);
            for (int j = 0; j < 5; j++) {
                Map<String, Object> mapC = new HashMap<>();
                mapC.put("content", "Content-" + j);
                mapC.put("createTime", LocalDateTime.now());
                this.header.setBearerAuth(this.token);
                HttpEntity<Map<String, Object>> entityC = new HttpEntity<>(mapC, header);
                restTemplate.postForObject(addCommentURL + (i + 1), entityC, String.class);
            }
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
}
