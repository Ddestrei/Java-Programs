package org.ddestrei.p.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class RepositoryClass {
    public String helloWorld(){
        log.info("Repository!!!");
        return "Hello World!!!";
    }
}
