package com.enterpriseapp.users_service_api.presentationLayer;

import com.enterpriseapp.users_service_api.feignLayer.ProfilePicturesResponseModel;

import java.util.List;

public class UserResponseModel {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
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

    public List<ProfilePicturesResponseModel> getProfilePictures() {
        return profilePictures;
    }

    public void setProfilePictures(List<ProfilePicturesResponseModel> profilePictures) {
        this.profilePictures = profilePictures;
    }
}
