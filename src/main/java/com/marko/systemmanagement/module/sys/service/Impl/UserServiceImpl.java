package com.marko.systemmanagement.module.sys.service.Impl;

import com.marko.systemmanagement.module.sys.model.RO.UserReq;
import com.marko.systemmanagement.module.sys.model.User;
import com.marko.systemmanagement.module.sys.repository.UserRepository;
import com.marko.systemmanagement.module.sys.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author ef-mark.o
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> queryList(UserReq ro) {
        Pageable pageable = PageRequest.of(ro.getPage(), ro.getSize());
        return userRepository.findAllBy(ro, pageable);
    }

}
