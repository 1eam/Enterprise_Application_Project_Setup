package com.enterpriseapp.users_service_api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsersRegistrationModel {
    @NotNull(message = "First name field is Empty \n Please enter your first name")
    @Size(min = 2, max = 32, message = "Last name field-size should at least contain 2 and a maximum of 32 characters")
    private String firstName;

    @NotNull(message = "Last name field is Empty \n Please enter your last name")
    @Size(min = 2, max = 100, message = "Last name field-size should at least contain 2 and a maximum of 100 characters")
    private String lastName;

    @NotNull(message = "Email field is Empty \n Please enter your email name")
    @Email(message = "invalid email input")
    @Size(min = 2, max = 100, message = "email size exceeds on an input size over 100")
    private String email;

    @NotNull(message = "Password field is Empty \n Please enter a password name")
    @Size(min = 8, max = 32, message = "Password-size should be between 8 - 32")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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
