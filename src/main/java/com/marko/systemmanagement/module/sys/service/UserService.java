package com.marko.systemmanagement.module.sys.service;

import com.marko.systemmanagement.module.sys.model.RO.UserReq;
import com.marko.systemmanagement.module.sys.model.User;
import org.springframework.data.domain.Page;

public interface UserService {

    User saveNewUser(User user);

    Page<User> queryList(UserReq ro);
}
