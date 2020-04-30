package com.wxapp.questionnaire.utils;

import com.wxapp.questionnaire.vo.ApiVO;

/**
 * @author orangeboy
 * 返回包装
 */
public class ApiUtils {

    public static <T> ApiVO<T> success(T data){
        return new ApiVO<>(200, "Success request", data);
    }

    public static ApiVO<String> internalServerError(){
        return new ApiVO<>(500, null, null);
    }

    public static ApiVO<String> internalServerError(String message){
        return new ApiVO<>(500, message, null);
    }

    public static ApiVO<String> forbidden(){
        return new ApiVO<>(403, null, null);
    }

    public static ApiVO<String> forbidden(String message){
        return new ApiVO<>(403, message, null);
    }

    public static ApiVO<String> notFound(){
        return new ApiVO<>(404, null, null);
    }

    public static ApiVO<String> notFound(String message){
        return new ApiVO<>(404, message, null);
    }

    public static ApiVO<String> error(int code, String message){
        return new ApiVO<>(code, message, null);
    }
}
