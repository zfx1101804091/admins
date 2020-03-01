package com.example.admins.tool;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageTableRequest implements Serializable {
    private Integer page;//页面
    private Integer limit;//每页显示数据
    private Integer offset;//从0开始

    //这里使用的是mysql的limit排序，limit5,10  ---检索6-15
    public void countOffset(){
        if(null==this.page||null==this.limit){
            this.offset=0;
            return;
        }
        this.offset=(this.page-1)*limit;
    }
}
