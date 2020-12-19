package com.enterpriseapp.users_service_api.service;

import java.util.UUID;

public class UsersServiceImpl implements IUsersService {
    @Override
    public UsersDto createUser(UsersDto usersDto) {
        usersDto.setUserId(UUID.randomUUID().toString());
        return null;
    }
}