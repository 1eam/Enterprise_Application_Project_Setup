/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.service;


import com.appsdeveloperblog.photoapp.api.albums.data.ProfilePictureEntity;
import java.util.List;

public interface ProfilePicturesService {
    List<ProfilePictureEntity> getProfilePictures(String userId);
}
