package com.springforum.suforum.Controller;

import com.springforum.suforum.Provider.GithubProvider;
import com.springforum.suforum.dto.AccesstokenDTO;
import com.springforum.suforum.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 转发
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

//token= 355e99ba55e4a7546dba7f53d3ed3de26d460e9a
//转换到callback页面进行处理
    @GetMapping("/callback")
    public String Callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        AccesstokenDTO accesstokenDTO = new AccesstokenDTO();
        accesstokenDTO.setClient_id(clientId);
        accesstokenDTO.setCode(code);
        accesstokenDTO.setClient_secret(clientSecret);
        accesstokenDTO.setRedirect_uri(clientUri);
        accesstokenDTO.setState(state);
        String accessToken = githubProvider.getAccesstoken(accesstokenDTO);

        GithubUser user = githubProvider.getUser(accessToken);
        if(user!=null){
            //登录成功
            request.getSession().setAttribute("user",user);
            return  "redirect:/";
        }else {
            return  "redirect:/";
        }


    }
}
