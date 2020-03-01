package com.example.admins.tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class Results<T>implements Serializable {

    int count;//数据数量
    Integer code;//代码
    String msg;//信息
    List<T> datas;//返回数据
    T data;//任何类型条件

    public Results() {
    }
    public Results(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }


    public Results(Integer code, String msg, T data, Integer count, List<T> datas) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
        this.datas = datas;
    }



    /* 分页数据传输的 成功返回 */
    public static <T> Results<T> success(Integer count, List<T> datas) {
        return new Results<T>(ResponseCode.TABLE_SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage(),null,count, datas);
    }

    /* 单个数据传输的 成功返回 */
    public static <T> Results<T> success(T data) {
        return new Results<T>( ResponseCode.SUCCESS.getCode(),  ResponseCode.SUCCESS.getMessage(), data, 0, null);
    }

    /* 无数据传输的 失败返回 */
    public static <T> Results<T> failure() {
        return new Results<T>( ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMessage());
    }


    public static Results ok() {
        return new Results();
    }
}
