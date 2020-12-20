package com.enterpriseapp.users_service_api.dataLayer;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
}