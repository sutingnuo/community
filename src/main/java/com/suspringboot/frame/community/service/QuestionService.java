package com.suspringboot.frame.community.service;

import com.suspringboot.frame.community.dto.QuestionDTO;
import com.suspringboot.frame.community.mapper.QuestionMapper;
import com.suspringboot.frame.community.mapper.UserMapper;
import com.suspringboot.frame.community.model.Question;
import com.suspringboot.frame.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

//中间处理
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    public List<QuestionDTO> listquestion() {
            List<Question> questions=questionMapper.listquestion();
            List<QuestionDTO> questionsdtolist=new ArrayList<>();
            for (Question question:questions){
                User user=userMapper.findById(question.getCreator());
                QuestionDTO questionDTO=new QuestionDTO();
                BeanUtils.copyProperties(question,questionDTO);
                questionDTO.setUser(user);
                questionsdtolist.add(questionDTO);
            }return questionsdtolist;

    }
}
