package com.suspringboot.frame.community.Controller;

import com.suspringboot.frame.community.Provider.GithubProvider;
import com.suspringboot.frame.community.dto.AccesstokenDTO;
import com.suspringboot.frame.community.dto.GithubUser;


import com.suspringboot.frame.community.model.User;
import com.suspringboot.frame.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 登录后会将转回index
 * 对账户的处理
 * 代码整理：宋甜宁
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.client.url}")
    private String clientUri;

    @Autowired
    private UserService userService;
//token= 355e99ba55e4a7546dba7f53d3ed3de26d460e9a
//转换到callback页面进行处理
    @GetMapping("/callback")
    public String Callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        AccesstokenDTO accesstokenDTO = new AccesstokenDTO();
        accesstokenDTO.setClient_id(clientId);
        accesstokenDTO.setCode(code);
        accesstokenDTO.setClient_secret(clientSecret);
        accesstokenDTO.setRedirect_uri(clientUri);
        accesstokenDTO.setState(state);
        String accessToken = githubProvider.getAccesstoken(accesstokenDTO);

        GithubUser githubUser  = githubProvider.getUser(accessToken);
        if(githubUser!=null&&githubUser.getId()!=null){
           User user=new User();
           String token=UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccount_id(githubUser.getId());

            user.setAvatar_url(githubUser.getAvatar_url());
            response.addCookie(new Cookie("token",token));
            userService.CreateOrUpdate(user);

            //登录成功
            request.getSession().setAttribute("user",githubUser);
            return  "redirect:/";
        }else {
            return  "redirect:/";
        }


    }
    @GetMapping("/logout")
    private String logiout(HttpServletRequest request,
                           HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie=new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/" ;
    }
}
