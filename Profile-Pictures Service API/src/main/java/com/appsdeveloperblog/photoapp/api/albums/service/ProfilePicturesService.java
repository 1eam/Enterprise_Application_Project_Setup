package com.appsdeveloperblog.photoapp.api.albums.service;

import com.appsdeveloperblog.photoapp.api.albums.data.ProfilePictureEntity;

import java.util.List;

public interface ProfilePicturesService {
    List<ProfilePictureEntity> getProfilePictures(String userId);
}