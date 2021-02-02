package com.enterpriseapp.users_service_api.controllerLayer.endpointModels.userData;

import com.enterpriseapp.users_service_api.service2serviceCommunicationLayer.ProfilePicturesModel_Response;

import java.util.List;

public class UserModel_Response {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<ProfilePicturesModel_Response> profilePictures;

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

    public List<ProfilePicturesModel_Response> getProfilePictures() {
        return profilePictures;
    }

    public void setProfilePictures(List<ProfilePicturesModel_Response> profilePictures) {
        this.profilePictures = profilePictures;
    }
}
