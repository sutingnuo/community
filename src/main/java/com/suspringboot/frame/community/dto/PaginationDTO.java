package com.suspringboot.frame.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;//是否有向前按钮
    private boolean showFistpage;//是否有第一按钮
    private boolean showNext;//是否有向后按钮
    private boolean showEndPag;//
    private Integer page;//当前页
    private Integer totalPage;
    private List<Integer> pages=new ArrayList<>();

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        this.page=page;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = (totalCount / size) + 1;
        }
        if(page<1){
            page=1;
            this.page=1;
        }
        if (page>totalPage){
            page=totalPage;
            this.page=totalPage;
        }
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page-i>0){
                pages.add(0,page-i);
            }
            if (page+i<=totalPage){
                pages.add(page+i);
            }
        }

        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }
        if (pages.contains(1)) {
            showFistpage = false;
        } else {
            showFistpage = true;
        }
        if (pages.contains(totalPage)) {
            showEndPag = false;
        } else {
            showEndPag = true;
        }


    }
}
