package com.suspringboot.frame.community.Controller;

import com.suspringboot.frame.community.dto.PaginationDTO;
import com.suspringboot.frame.community.dto.QuestionDTO;
import com.suspringboot.frame.community.mapper.UserMapper;

import com.suspringboot.frame.community.model.User;
import com.suspringboot.frame.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 主页
 * 代码整理：宋甜宁
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "size",defaultValue = "5")Integer size  ) {
        //检验登录状态
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        //查询信息

       PaginationDTO pagination=questionService.listquestion(page,size);
        model.addAttribute("pagination",pagination);
        return "index";

    }





}
