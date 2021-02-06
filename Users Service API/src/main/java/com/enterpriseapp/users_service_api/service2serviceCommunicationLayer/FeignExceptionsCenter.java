/*     This is a central class for Feign communication errors,
       we can analyze requests received by the other microsservice
       and throw a custom exception. In addition we can also analyze the request sent */

package com.enterpriseapp.users_service_api.service2serviceCommunicationLayer;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class FeignExceptionsCenter implements ErrorDecoder {

private Environment environment;

@Autowired
    public FeignExceptionsCenter(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                //return new BadRequestException(); - todo: create class
                break;
            case 404:{
                if (methodKey.contains("getProfilePictures")) {
                    return new ResponseStatusException(HttpStatus.valueOf(response.status()), environment.getProperty("profile-pictures.exceptions.profile-pictures-not-found"));
                }
                break;
            }
            default:
                return new Exception(response.reason());
        }
        return null;
    }
}