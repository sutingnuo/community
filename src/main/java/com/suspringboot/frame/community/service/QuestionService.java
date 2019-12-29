package com.suspringboot.frame.community.service;

import com.suspringboot.frame.community.dto.PaginationDTO;
import com.suspringboot.frame.community.dto.QuestionDTO;
import com.suspringboot.frame.community.mapper.QuestionMapper;
import com.suspringboot.frame.community.mapper.UserMapper;
import com.suspringboot.frame.community.model.Question;
import com.suspringboot.frame.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//中间处理
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    //page页数
    //size 行数
    public PaginationDTO listquestion(Integer page, Integer size) {


        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount, page, size);

        Integer offset = size * (paginationDTO.getPage() - 1);

        List<Question> questions = questionMapper.listquestion(offset, size);
        List<QuestionDTO> questionsdtolist = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionsdtolist.add(questionDTO);
        }
        paginationDTO.setQuestions(questionsdtolist);

        return paginationDTO;
    }

    public PaginationDTO listquestion(Integer userId, Integer page, Integer size) {


        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.countByUser(userId);
        paginationDTO.setPagination(totalCount, page, size);

        Integer offset = size * (paginationDTO.getPage() - 1);

        List<Question> questions = questionMapper.listByUserId(userId,offset,size);
        List<QuestionDTO> questionsdtolist = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionsdtolist.add(questionDTO);
        }
        paginationDTO.setQuestions(questionsdtolist);

        return paginationDTO;
    }
}