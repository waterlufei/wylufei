package com.waterlufei.WyWork.web;

import com.waterlufei.WyWork.Enum.UserEnum;
import com.waterlufei.WyWork.service.UserService;
import com.waterlufei.WyWork.vo.BaseResponse;
import com.waterlufei.WyWork.vo.UserInfoRequest;
import com.waterlufei.WyWork.vo.UserInoResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 判断用户是否存在，如果存在返回用户信息
     * @param userInfoRequest
     * @return
     */
    @RequestMapping(value = "/logIn", method = {RequestMethod.GET,RequestMethod.POST})
    public BaseResponse userIsNotLogIn(@RequestBody UserInfoRequest userInfoRequest){
        BaseResponse result = new BaseResponse();
        try{
            UserInoResponse userInfo = userService.userIsNotLogIn(userInfoRequest);
            if (userInfo != null){
                result.setCode(UserEnum.SUCCESS.getCode());
                result.setMsg(UserEnum.SUCCESS.getMsg());
                result.setData(userInfo);
            }else {
                result.setCode(UserEnum.NO_FOUND_USER_INO.getCode());
                result.setMsg(UserEnum.NO_FOUND_USER_INO.getMsg());
            }
        }catch (Exception e){
            result.setCode(UserEnum.EXCEPTION.getCode());
            result.setMsg(UserEnum.EXCEPTION.getMsg());
            e.printStackTrace();
        }
        return result;
    }
}
