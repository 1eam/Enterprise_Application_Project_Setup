/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.service;

import com.appsdeveloperblog.photoapp.api.albums.data.ProfilePictureEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProfilePicturesServiceImpl implements ProfilePicturesService {

    @Override
    public List<ProfilePictureEntity> getProfilePictures(String userId) {
        List<ProfilePictureEntity> returnValue = new ArrayList<>();
        
        ProfilePictureEntity profilePictureEntity = new ProfilePictureEntity();
        profilePictureEntity.setUserId(userId);
        profilePictureEntity.setPhotoId("photo1Id");
        profilePictureEntity.setDescription("photo 1 description");
        profilePictureEntity.setId(1L);
        profilePictureEntity.setName("photo 1 name");
        profilePictureEntity.setLocation("https://duckduckgo.com/assets/common/dax-logo.svg");
        
        ProfilePictureEntity profilePictureEntity2 = new ProfilePictureEntity();
        profilePictureEntity2.setUserId(userId);
        profilePictureEntity2.setPhotoId("photo2Id");
        profilePictureEntity2.setDescription("photo 2 description");
        profilePictureEntity2.setId(2L);
        profilePictureEntity2.setName("photo 2 name");
        profilePictureEntity.setLocation("https://www.askideas.com/media/50/Funny-Jim-Carrey-Caricature-Face-Picture.jpg");


        returnValue.add(profilePictureEntity);
        returnValue.add(profilePictureEntity2);
        
        return returnValue;
    }
    
}
