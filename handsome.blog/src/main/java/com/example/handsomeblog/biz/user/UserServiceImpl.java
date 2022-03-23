package com.example.handsomeblog.biz.user;

import com.example.handsomeblog.dal.user.UserDo;
import com.example.handsomeblog.dal.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDo> getAllUser() {
        return userMapper.getAllUser();
    }
}
