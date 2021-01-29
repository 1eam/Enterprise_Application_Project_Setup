package com.enterpriseapp.users_service_api.feignLayer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "profile-pictures-service")
public interface ProfilePicturesClient {
    @GetMapping("/users/{id}/profile-pictures")
    public List<ProfilePicturesResponseModel> getProfilePictures(@PathVariable String id);
}

//The Feign framework implements this Interface