package com.wxapp.questionnaire.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author orangeboy
 * 用户类
 */
@Data
@AllArgsConstructor
public class User {
    private String userId;
    private String nickName;
    private String avatarUrl;
    private boolean gender;
    private Date birthday;
    private String openid;
    private int score;
}
