package com.enterpriseapp.users_service_api.serviceLayer;

import com.enterpriseapp.users_service_api.service2serviceCommunicationLayer.ProfilePicturesResponseModel;

import java.io.Serializable;
import java.util.List;

public class UsersDto implements Serializable {
    private static final long serialVersionUID = 3765243991479728485L;

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
    private List<ProfilePicturesResponseModel> profilePictures;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public List<ProfilePicturesResponseModel> getProfilePictures() {
        return profilePictures;
    }

    public void setProfilePictures(List<ProfilePicturesResponseModel> profilePictures) {
        this.profilePictures = profilePictures;
    }
}
