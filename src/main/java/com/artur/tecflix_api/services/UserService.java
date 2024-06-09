package com.artur.tecflix_api.services;

import com.artur.tecflix_api.data.DTO.v1.UserDTO;
import com.artur.tecflix_api.exceptions.ResourceNotFoundException;
import com.artur.tecflix_api.mapper.Mapper;
import com.artur.tecflix_api.model.User;
import com.artur.tecflix_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class UserService {
    private final Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository userRepository;

    public UserDTO findById(UUID id) {
        logger.info("Finding one user");

        return Mapper.parseObject(
                userRepository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("No records found for this id")
                ),
                UserDTO.class
        );
    }

    public List<UserDTO> findAll() {
        logger.info("Finding all users");

        return Mapper.parseObjectList(userRepository.findAll(), UserDTO.class);
    }

    public UserDTO create(UserDTO userDTO) {
        logger.info("Creating one user");

        User user = Mapper.parseObject(userDTO, User.class);

        return Mapper.parseObject(userRepository.save(user), UserDTO.class);
    }

    public UserDTO update(UserDTO userDTO) {
        logger.info("Updating one user");

        User user = Mapper.parseObject(findById(userDTO.getId()), User.class);
        user.setFullName(userDTO.getFullName());
        user.setPassword(userDTO.getPassword());
        user.setActive(userDTO.getActive());

        return Mapper.parseObject(userRepository.save(user), UserDTO.class);
    }

    public void delete(UUID id) {
        logger.info("Deleting one person");

        User user = Mapper.parseObject(findById(id), User.class);

        userRepository.delete(user);
    }
}