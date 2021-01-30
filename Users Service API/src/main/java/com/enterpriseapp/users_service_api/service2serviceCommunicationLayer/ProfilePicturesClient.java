package com.enterpriseapp.users_service_api.service2serviceCommunicationLayer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "profile-pictures-service")
public interface ProfilePicturesClient {
    @GetMapping("/users/{id}/profile-pictures")
    public List<ProfilePicturesModel_Response> getProfilePictures(@PathVariable String id);
}

//The Feign framework implements this Interface