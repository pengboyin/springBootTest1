package com.ismartv.springBootTest.dao.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ismartv.springBootTest.entity.User;

public interface UserDaoInterface extends JpaRepository<User, String> {

}
