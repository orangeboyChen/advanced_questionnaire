package com.wxapp.questionnaire.vo;

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
public class ApiVO {
    private Integer status;
    private String message;
    private String error;
}
