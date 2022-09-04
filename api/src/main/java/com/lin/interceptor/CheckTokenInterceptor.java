package com.lin.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.fmmail.vo.ResultVO;
import io.jsonwebtoken.*;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method=request.getMethod();
        if (method.equalsIgnoreCase("OPTIONS")){
            return  true;
        }
        String token = request.getHeader("token");
        JwtParser parser = Jwts.parser();
        System.out.println(token);
        parser.setSigningKey("LIN666");
        if (token == null) {
            ResultVO resultVO = new ResultVO(10001, "登录过期请重新登录", null);
            doResponse(response,resultVO);
            return false;
        } else {
            //过期伪造抛异常
            try {
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                return true;
            } catch (ExpiredJwtException e) {
                ResultVO resultVO = new ResultVO(10001, "登录过期请重新登录", null);
                doResponse(response,resultVO);
                return false;
            } catch (UnsupportedJwtException e) {
                ResultVO resultVO = new ResultVO(10001, "token不合法", null);
                doResponse(response,resultVO);
            } catch (Exception e) {
                ResultVO resultVO = new ResultVO(10001, "请先登录", null);
                doResponse(response,resultVO);
            }
        }
        return false;
    }
    private void doResponse( HttpServletResponse response,ResultVO resultVO ) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String s=new ObjectMapper().writeValueAsString(resultVO);
        out.println(s);
        out.flush();
        out.close();
    }
}
