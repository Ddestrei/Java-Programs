package org.ddestrei.p.aop;

public class AdditionalCredentialsDto implements AdditionalCredentials{

    private String username;
    private String password;

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
