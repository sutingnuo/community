package com.suspringboot.frame.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious=false;//是否有向前按钮
    private boolean showFistpage=false;//是否有第一按钮
    private boolean showNext=false;//是否有向后按钮
    private boolean showEndPag=false;//
    private Integer page=1;//当前页
    private Integer totalPage=1;
    private List<Integer> pages=new ArrayList<>();

    public void setPagination(Integer totalCount, Integer page, Integer size) {


            if (totalCount % size == 0&& totalCount>0) {
                totalPage = totalCount / size;
            } else {
            totalPage = (totalCount / size) + 1;
        }

        if(page<1){
            page=1;
        } else if (page>totalPage){
            page=totalPage;
        }   this.page=page;


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
