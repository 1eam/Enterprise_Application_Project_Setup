package com.enterpriseapp.users_service_api.serviceLayer;

import com.enterpriseapp.users_service_api.databaseLayer.UserEntity;
import com.enterpriseapp.users_service_api.databaseLayer.UsersRepository;
import com.enterpriseapp.users_service_api.service2serviceCommunicationLayer.ProfilePicturesClient;
import com.enterpriseapp.users_service_api.service2serviceCommunicationLayer.ProfilePicturesModel_Response;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ProfilePicturesClient profilePicturesClient;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ProfilePicturesClient profilePicturesClient) {
        this.usersRepository = usersRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.profilePicturesClient = profilePicturesClient;
    }

    @Override
    public UsersDto createUser(UsersDto usersDTO) {
        //set public userID
        usersDTO.setUserId(UUID.randomUUID().toString());

        //password encryption
        usersDTO.setEncryptedPassword(bCryptPasswordEncoder.encode(usersDTO.getPassword()));

        //maps usersDto-type to userEntity model -> for save
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(usersDTO, UserEntity.class);

        //calls actual save-method on userEntity-type
        usersRepository.save(userEntity);

        //converts userEntity back to response value (usersDTO)
        UsersDto returnValue = modelMapper.map(userEntity, UsersDto.class);
        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = usersRepository.findByEmail(email);

        if (userEntity==null) throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail(),
                        userEntity.getEncryptedPassword(),
                true, true, true, true, new ArrayList<>());
    }

    @Override
    public UsersDto getUserDetailsByEmail(String email) {
        UserEntity userEntity = usersRepository.findByEmail(email);

        if (userEntity==null) throw new UsernameNotFoundException(email);

        return new ModelMapper().map(userEntity, UsersDto.class);
    }

    @Override
    public UsersDto getUserByUserId(String userId) {

        UserEntity userEntity = usersRepository.findByUserId(userId);
        if(userEntity == null) throw new UsernameNotFoundException("User not found");

        UsersDto usersDto = new ModelMapper().map(userEntity, UsersDto.class);

        logger.info("before calling Profile-Pictures microservice");
        List<ProfilePicturesModel_Response> profilePicturesList = profilePicturesClient.getProfilePictures(userId);
        logger.info("after calling Profile-Pictures microservice");

        usersDto.setProfilePictures(profilePicturesList);

        return usersDto;
    }
}