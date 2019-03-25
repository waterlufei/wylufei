package com.waterlufei.WyWork.service.impl;

import com.waterlufei.WyWork.mapper.UserMapper;
import com.waterlufei.WyWork.service.UserService;
import com.waterlufei.WyWork.vo.UserInfoRequest;
import com.waterlufei.WyWork.vo.UserInoResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 判断用户是否存在
     * @param userInfoRequest
     * @return
     */
    public UserInoResponse userIsNotLogIn(UserInfoRequest userInfoRequest){
        return userMapper.selectUser(userInfoRequest);
    }
}
