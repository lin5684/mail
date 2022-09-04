package com.lin.controller;

import com.lin.fmmail.entity.Users;
import com.lin.fmmail.service.UserService;
import com.lin.fmmail.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@ResponseBody
@RequestMapping("/user")
@CrossOrigin//允许跨域
@Api(tags = "用户管理")
public class UserController {
    @Resource
    private UserService userService;
//    @ApiImplicitParam(name= "用户信息",required = true)
//    @RequestMapping(value = "/toLogin")
//    public String toLogin(User user){
//        return user.toString();
//    }
        @ApiOperation("用户登录接口")
        @ApiImplicitParams({
        @ApiImplicitParam(dataType = "string",name = "username",value = "用户登录账户",required = true),
        @ApiImplicitParam(dataType = "string",name = "password",value = "用户登录密码",required = true),
        })
    @GetMapping("/login")
    public ResultVO login(@RequestParam("username") String username, @RequestParam("password")String password){

        return userService.checkLogin(username,password);
    }
    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username",value = "用户注册账户",required = true),
            @ApiImplicitParam(dataType = "string",name = "password",value = "用户注册密码",required = true),
    })
    @PostMapping("/regist")

    public ResultVO regist(  @RequestBody Users users){
            System.out.println(users.getUsername());
        return userService.userRegist(users.getUsername(),users.getPassword());
    }
}
