/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.io.controllers;

import com.appsdeveloperblog.photoapp.api.albums.data.ProfilePictureEntity;
import com.appsdeveloperblog.photoapp.api.albums.service.ProfilePicturesService;
import com.appsdeveloperblog.photoapp.api.albums.ui.model.ProfilePictureResponseModel;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import java.lang.reflect.Type;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/users/{id}/profile-pictures")
public class ProfilePicturesController {
    
    @Autowired
    ProfilePicturesService profilePicturesService;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping( 
            produces = { 
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
            })
    public List<ProfilePictureResponseModel> userProfilePictures(@PathVariable String id) {

        List<ProfilePictureResponseModel> returnValue = new ArrayList<>();
        
        List<ProfilePictureEntity> photoEntities = profilePicturesService.getProfilePictures(id);
        
        if(photoEntities == null || photoEntities.isEmpty())
        {
            return returnValue;
        }
        
        Type listType = new TypeToken<List<ProfilePictureResponseModel>>(){}.getType();
 
        returnValue = new ModelMapper().map(photoEntities, listType);
        logger.info("Returning " + returnValue.size() + " profile pictures");
        return returnValue;
    }
}
