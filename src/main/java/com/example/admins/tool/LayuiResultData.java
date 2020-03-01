package com.example.admins.tool;

import lombok.Data;

@Data
public class LayuiResultData {
//这个应该不用声明把 我之前写这中格式的从没声明故 声明什么 不需要写这个个体set 不写怎么赋值 不用赋值的把 不赋值没办法用
    private Integer code;
    private String msg;
    private Integer count;
    private Object data;

    public LayuiResultData returnSuccess(String msg, Integer count, Object data){
        this.code=0;
        this.msg=msg;
        this.count=count;
        this.data=data;
        return this;
    }

  
    public LayuiResultData returnFail(String msg){
        this.code=1;
        this.count=0;
        this.msg=msg;
        return this;
    }
    
    public LayuiResultData returnSuccess(String msg){
        this.code=0;
        this.count=0;
        this.msg=msg;
        return this;
    }
   
}
