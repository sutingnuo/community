package com.suspringboot.frame.community.Controller;


import com.suspringboot.frame.community.mapper.QuestionMapper;
import com.suspringboot.frame.community.mapper.UserMapper;
import com.suspringboot.frame.community.model.Question;
import com.suspringboot.frame.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class publishController {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String dopublish(@RequestParam("title") String title,
                            @RequestParam("description") String description,
                            @RequestParam("tag") String tag,
                            HttpServletRequest request,
                            Model model) {

        User user=null;
        Cookie [] cookies=request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                String token=cookie.getValue();
                user=userMapper.findByToken(token);
                if (user!=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        if(user==null){
            model.addAttribute("error","用户未登录");
        }

        Question question=new Question();
        question.setDescription(description);
        question.setTitle(title);
        question.setTag(tag);
        question.setCreateor(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtMdified(question.getGmtCreate());
        questionMapper.create(question);
        return  "redirect:/";
    }
}
