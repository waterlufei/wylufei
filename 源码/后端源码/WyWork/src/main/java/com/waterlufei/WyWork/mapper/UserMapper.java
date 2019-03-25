package com.waterlufei.WyWork.mapper;

import com.waterlufei.WyWork.vo.UserInfoRequest;
import com.waterlufei.WyWork.vo.UserInoResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserInoResponse selectUser(UserInfoRequest UserInfoRequest);
}

