package com.zealer.service.Impl;

import com.zealer.entity.Users;
import com.zealer.entity.UsersExample;
import com.zealer.mapping.UsersMapper;
import com.zealer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public List<Users> getAllUsers() {
        UsersExample usersExample = new UsersExample();
        return usersMapper.selectByExample(usersExample);
    }

    @Override
    public boolean validateUser(String uname, String pwd) {
        UsersExample usersExample = new UsersExample();
        usersExample.createCriteria().andPasswordEqualTo(pwd).andNicknameEqualTo(uname);
        List<Users> us = usersMapper.selectByExample(usersExample);
        return us.size() > 0 ? true : false ;
    }
}
