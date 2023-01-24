package com.marko.systemmanagement.module.sys.repository;

import com.marko.systemmanagement.module.sys.model.RO.UserReq;
import com.marko.systemmanagement.module.sys.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.email = :#{#ro.email} or u.username = :#{#ro.username} ")
    Page<User> findAllBy(@Param("ro") UserReq ro, Pageable pageable);
}
