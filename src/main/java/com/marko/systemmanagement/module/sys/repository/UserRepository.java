package com.marko.systemmanagement.module.sys.repository;

import com.marko.systemmanagement.module.sys.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
