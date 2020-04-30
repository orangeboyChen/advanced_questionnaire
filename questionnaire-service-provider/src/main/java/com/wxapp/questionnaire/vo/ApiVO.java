package com.wxapp.questionnaire.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author orangeboy
 * 返回包装类
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ApiVO<T> {
    private Integer status;
    private String message;
    private T data;
}
