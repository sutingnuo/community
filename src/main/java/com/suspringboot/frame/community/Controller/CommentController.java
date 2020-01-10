package com.suspringboot.frame.community.Controller;

import com.suspringboot.frame.community.dto.CommentDTO;
import com.suspringboot.frame.community.dto.ResultDTO;
import com.suspringboot.frame.community.exception.CustomizeEerrorCode;
import com.suspringboot.frame.community.mapper.CommentMapper;
import com.suspringboot.frame.community.model.Comment;
import com.suspringboot.frame.community.model.User;
import com.suspringboot.frame.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentService commentService;
    @ResponseBody
    @RequestMapping(value = "/comment",method= RequestMethod.POST)
    public  Object post(@RequestBody CommentDTO commentDTO,
                        HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        if (user==null){
            return ResultDTO.errorof(CustomizeEerrorCode.NO_LOGIN);
        }
        Comment comment=new Comment();
        comment.setParent_id(commentDTO.getParent_id());
        comment.setContent(commentDTO.getContent());
        comment.setCom_type(commentDTO.getCom_type());
        comment.setGmt_create(System.currentTimeMillis());
        comment.setGmt_modified(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setCommentator(1);
        comment.setLike_count(0l);
        commentService.insert(comment);
        commentMapper.insert(comment);
        return null;
    }
}
