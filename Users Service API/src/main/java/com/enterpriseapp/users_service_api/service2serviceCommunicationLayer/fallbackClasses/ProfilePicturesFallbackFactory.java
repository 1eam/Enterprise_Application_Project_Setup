package com.enterpriseapp.users_service_api.service2serviceCommunicationLayer.fallbackClasses;

import com.enterpriseapp.users_service_api.service2serviceCommunicationLayer.ProfilePicturesClient;
import com.enterpriseapp.users_service_api.service2serviceCommunicationLayer.ProfilePicturesModel_Response;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfilePicturesFallbackFactory implements FallbackFactory<ProfilePicturesClient> {

    @Override
    public ProfilePicturesClient create(Throwable cause) {
        return new ProfilePicturesClientFallback(cause);
    }
}

//---CLASS 2---//
// This class runs a fallback method when the Profile-Pictures-MicroService doesnt respond after the getProfilePictures method (using Feign) gets called.
// Slightly before we return our fallback to the client (api-side), this bean logs the error-details to the console for developers to view.

class ProfilePicturesClientFallback implements ProfilePicturesClient {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Throwable cause;

    public ProfilePicturesClientFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public List<ProfilePicturesModel_Response> getProfilePictures(String id) {

        //  logs details to console for developers to view

        if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
            logger.error("404 error took place when getAlbums was called with userId: " + id + ". Error message: "
                    + cause.getLocalizedMessage());
        } else {
            logger.error("Other error took place: " + cause.getLocalizedMessage());
        }

        //  returns back fallback method to client: an empty array []
        return new ArrayList<>();
    }
}