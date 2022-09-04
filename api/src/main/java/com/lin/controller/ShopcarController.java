package com.lin.controller;


import com.lin.fmmail.utils.Base64Utils;
import com.lin.fmmail.vo.ResultVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shopcart")
@CrossOrigin
@Api(tags = "购物车板块接口")
public class ShopcarController {

    @ApiOperation("购物车列表接口")
    @GetMapping("/list")
//    @ApiImplicitParam(dataType = "string",name = "token",value = "授权令牌",required = true)
    public ResultVO listCars(@RequestHeader("token") String token) {

            return  new ResultVO(10000,"success",null);

    }
}
