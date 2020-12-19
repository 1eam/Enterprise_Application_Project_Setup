package com.enterpriseapp.users_service_api.service;

import java.util.UUID;

public class UserServiceImpl implements IUserService {
    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        return null;
    }
}
