package com.enterpriseapp.users_service_api.feignLayer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Todo: refactor names to: "profile-pictures-service"
//The Feign framework implements this Interface

@FeignClient(name = "albums-ws")
public interface ProfilePicturesClient {
    @GetMapping("/users/{id}/albums")
    public List<ProfilePicturesResponseModel> getProfilePictures(@PathVariable String id);
}
