package com.enterpriseapp.users_service_api.service2serviceCommunicationLayer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfilePicturesRequestFallback implements ProfilePicturesClient{

    @Override
    public List<ProfilePicturesModel_Response> getProfilePictures(String id) {
        return new ArrayList<>();
    }
}
