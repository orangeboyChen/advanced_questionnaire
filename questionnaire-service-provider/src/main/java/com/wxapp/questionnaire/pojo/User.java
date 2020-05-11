package com.wxapp.questionnaire.pojo;

import lombok.*;
import lombok.experimental.Accessors;


/**
 * @author orangeboy
 * 用户类
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;
    private String nickName;
    private String avatarUrl;
    private int gender;
    private String openid;
    private int score;

    public User(String avatarUrl, String nickName, String openid, int gender){
        this.avatarUrl = avatarUrl;
        this.nickName = nickName;
        this.openid = openid;
        this.gender = gender;
    }
}
