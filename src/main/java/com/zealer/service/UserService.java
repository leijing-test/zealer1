package com.zealer.service;

import com.zealer.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<Users> getAllUsers();

    public boolean validateUser(String uname,String pwd);
}
