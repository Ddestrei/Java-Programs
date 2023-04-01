package org.ddestrei.p.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AdditionalAuthenticationAspect {

    @Before("@annotation(authentication) && args(additionalCredentials,..)")
    public void before(AdditionalAuthentication authentication, AdditionalCredentials additionalCredentials){
        log.info("AdditionalAuthenticationAspect is working!!!");
        log.info(additionalCredentials.getUsername() + " :username");
        log.info(additionalCredentials.getPassword() + " :password");

        if(!(additionalCredentials.getPassword().equals("password") && additionalCredentials.getUsername().equals("patryk"))){
            throw new IllegalStateException("Wrong Password and Username");
        }

    }
}
