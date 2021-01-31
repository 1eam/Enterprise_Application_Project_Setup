package com.enterpriseapp.users_service_api.service2serviceCommunicationLayer;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FeignExceptionsCenter implements ErrorDecoder {
//    This is a central class for Feign communication errors,
//    we can analyze requests received by the other microsservice
//    and throw a custom exception. In addition we can also analyze the request sent

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
//                return new BadRequestException();
                break;
            case 404:{
                if (methodKey.contains("getProfilePictures")) {
                    return new ResponseStatusException(HttpStatus.valueOf(response.status()),"User profile picture(s) not found");
                }
                break;
            }
            default:
        return new Exception(response.reason());
        }
        return null;
    }
}