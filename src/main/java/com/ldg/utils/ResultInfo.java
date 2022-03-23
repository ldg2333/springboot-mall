package com.ldg.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 返回前端的数据类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultInfo {
    private Integer code;
    private String message;
    private Object data;

    public ResultInfo(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    // 错误不带数据
    public static ResultInfo error(String message){
        return new ResultInfo (500,message);
    }
    // 错误带数据
    public static ResultInfo error(String message,Object data){
        return new ResultInfo (500,message,data);
    }
    // 成功不带数据
    public static ResultInfo success(String message){
        return new ResultInfo(200,message);
    }
    // 成功带数据
    public static ResultInfo success(String message,Object data){
        return new ResultInfo(200,message,data);
    }

}
