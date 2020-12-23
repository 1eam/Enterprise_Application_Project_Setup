package com.enterpriseapp.users_service_api.serviceLayer;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
    UsersDto createUser(UsersDto usersDto);
}