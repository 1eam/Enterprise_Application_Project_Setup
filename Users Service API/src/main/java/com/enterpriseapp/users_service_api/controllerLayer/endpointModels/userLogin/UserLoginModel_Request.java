package com.enterpriseapp.users_service_api.controllerLayer.endpointModels.userLogin;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginModel_Request {
    @NotNull(message = "Email field is Empty \n Please enter your email name")
    @Email(message = "invalid email input")
    private String email;

    @NotNull(message = "Password field is Empty \n Please enter a password name")
    @Size(min = 8, max = 32, message = "Password-size should be between 8 - 32")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
