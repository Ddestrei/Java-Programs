package org.ddestrei.p.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ddestrei.p.repository.RepositoryClass;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServiceClass {

    private final RepositoryClass repository;

    public String helloWorld() {
        log.info("Service!!!");
        return repository.helloWorld();
    }
}
