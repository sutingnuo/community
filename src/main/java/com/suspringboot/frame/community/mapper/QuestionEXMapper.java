package com.suspringboot.frame.community.mapper;

import com.suspringboot.frame.community.model.Question;
import com.suspringboot.frame.community.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionEXMapper {
    int incView(Question record);
}