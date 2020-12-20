package com.enterpriseapp.users_service_api.serviceLayer;

import com.enterpriseapp.users_service_api.dataLayer.UserEntity;
import com.enterpriseapp.users_service_api.dataLayer.UsersRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {
    UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersDto createUser(UsersDto usersDTO) {
        usersDTO.setUserId(UUID.randomUUID().toString());

        //temporary hardcoded encryption value
        usersDTO.setEncryptedPassword("thisPWShouldBeEncrypted123");

        //Final map to userEntity model
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(usersDTO, UserEntity.class);

        usersRepository.save(userEntity);

        UsersDto returnValue = modelMapper.map(userEntity, UsersDto.class);
        return returnValue;
    }
}