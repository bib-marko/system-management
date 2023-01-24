package com.marko.systemmanagement.module.sys.service.Impl;

import com.marko.systemmanagement.module.sys.model.User;
import com.marko.systemmanagement.module.sys.repository.UserRepository;
import com.marko.systemmanagement.module.sys.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author ef-mark.o
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveNewUser(User user) {
        return userRepository.save(user);
    }

}
