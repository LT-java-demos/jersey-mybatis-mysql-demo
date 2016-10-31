package com.lt.rs.mapper;

import com.lt.rs.bean.User;

import java.util.List;

public interface UserMapper {
    User getUserById(int id);

    List<User> getAllUsers();
}
