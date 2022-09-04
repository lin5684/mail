package com.lin.fmmail.service.impl;



import com.lin.fmmail.dao.UsersMapper;
import com.lin.fmmail.entity.Users;
import com.lin.fmmail.service.UserService;
import com.lin.fmmail.utils.Base64Utils;
import com.lin.fmmail.utils.MD5Utils;
import com.lin.fmmail.vo.ResultVO;


import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import tk.mybatis.mapper.entity.Example;
@Service
public class UserServieImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Transactional
    public ResultVO userRegist(String username, String pwd){
        synchronized (this) {
            Example example = new Example(Users.class);
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("username",username);
            List<Users> users=usersMapper.selectByExample(example);
            if (users.size()==0) {
                String md5pwd = MD5Utils.md5(pwd);
                Users user=new Users();
                user.setUsername(username);
                user.setPassword(md5pwd);
                user.setUserImg("img/defaul.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                int i = usersMapper.insertUseGeneratedKeys(user);
                if (i > 0) {
                    return new ResultVO(10000, "注册成功", user);
                } else {
                    return new ResultVO(10002, "注册失败", null);
                }
            } else {
                return new ResultVO(10001, "用户名已被注册", null);
            }
        }
    }

    @Override
    public ResultVO checkLogin(String username, String pwd) {
        Example example = new Example(Users.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("username",username);
        List<Users> users=usersMapper.selectByExample(example);
        if (users.size()==0) {
            return new ResultVO(10001, "用户不存在", null);
        }else {
            String md5pwd=MD5Utils.md5(pwd);
            if (users.get(0).getPassword().equals(md5pwd)){
                //生成token令牌
                HashMap<String,Object> map=new HashMap<>();
                map.put("key1","lin");
                JwtBuilder jwtBuilder= Jwts.builder();

                String token = jwtBuilder.setSubject(username)//token中携带的数据
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                        .setId(users.get(0).getUserId() + "")//设置用户信息为tokenid
                        .setClaims(map)//map可存储用户权限信息
                        .signWith(SignatureAlgorithm.HS256, "LIN666")
                        .compact();
//                String token= Base64Utils.encode(username+"Lin123");//设置加密方式和密码

                return new ResultVO(10000, token, users .get(0));
            }else {
                return  new ResultVO(10001, "用户密码不正确", null);
            }
        }
    }
}
