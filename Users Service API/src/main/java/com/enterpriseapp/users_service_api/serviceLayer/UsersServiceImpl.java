package com.enterpriseapp.users_service_api.serviceLayer;

import com.enterpriseapp.users_service_api.dataLayer.UserEntity;
import com.enterpriseapp.users_service_api.dataLayer.UsersRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {
    UsersRepository usersRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersRepository = usersRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UsersDto createUser(UsersDto usersDTO) {
        //set public userID
        usersDTO.setUserId(UUID.randomUUID().toString());

        //password encryption
        usersDTO.setEncryptedPassword(bCryptPasswordEncoder.encode(usersDTO.getPassword()));

        //final map to userEntity model
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(usersDTO, UserEntity.class);
        usersRepository.save(userEntity);

        //convert userEntity back to responsevalue (usersDTO)
        UsersDto returnValue = modelMapper.map(userEntity, UsersDto.class);
        return returnValue;
    }
}