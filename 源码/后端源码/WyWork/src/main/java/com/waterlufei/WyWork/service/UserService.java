package com.waterlufei.WyWork.service;

import com.waterlufei.WyWork.vo.UserInfoRequest;
import com.waterlufei.WyWork.vo.UserInoResponse;

public interface UserService {

    /**
     * 判断用户是否存在
     * @param userInfoRequest
     * @return
     */
    UserInoResponse userIsNotLogIn(UserInfoRequest userInfoRequest);
}
