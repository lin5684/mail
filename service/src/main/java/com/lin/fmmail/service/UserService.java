package com.lin.fmmail.service;

import com.lin.fmmail.vo.ResultVO;

public interface UserService {
    //用户注册
    ResultVO userRegist(String username, String pwd);
    //用户登录
    ResultVO checkLogin(String username, String pwd);
}
