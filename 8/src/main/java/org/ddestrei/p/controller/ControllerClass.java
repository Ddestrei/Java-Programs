package org.ddestrei.p.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ddestrei.p.aop.AdditionalAuthentication;
import org.ddestrei.p.aop.AdditionalCredentialsDto;
import org.ddestrei.p.service.ServiceClass;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller")
@Slf4j
@RequiredArgsConstructor
public class ControllerClass {

    private final ServiceClass service;

    @PostMapping("/Hello World")
    @AdditionalAuthentication
    public String HelloWorld(@RequestBody AdditionalCredentialsDto additionalCredentialsDto){
        log.info("Controller!!!");
        return service.helloWorld();
    }

}
