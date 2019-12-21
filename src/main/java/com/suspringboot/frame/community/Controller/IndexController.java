package com.suspringboot.frame.community.Controller;
import com.suspringboot.frame.community.mapper.UserMapper;
import com.suspringboot.frame.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 初始化界面
 * 代码整理：宋甜宁
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(HttpServletRequest request) {
      Cookie[] cookies = request.getCookies();
      if(cookies!=null){
       for(Cookie cookie:cookies){
           if(cookie.getName().equals("token")){
               String token=cookie.getValue();
               User user=userMapper.findByToken(token);
               if(user!=null){
                   request.getSession().setAttribute("user",user);
               }
               break;
           }
       }
    }
        return "index";
    }
}
