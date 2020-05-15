package com.wxapp.questionnaire.utils;

import com.wxapp.questionnaire.pojo.QuestionnaireBasic;
import io.swagger.models.auth.In;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/5/1 13:28
 * Redis工具类
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    final String PREFIX = "wx_ques";

    final String QUESTIONNAIRE_LIKE = PREFIX + ":" + "questionnaire_like" + ":";

    final String QUESTIONNAIRE_VIEW = PREFIX + ":" + "questionnaire_view" + ":";

    /**
     * 获取问卷赞数
     * @param questionnaireId 基本问卷id
     * @return 赞数
     */
    public Integer getQuestionnaireLike(@NotNull String questionnaireId){
        Integer like = getKey(QUESTIONNAIRE_LIKE + questionnaireId, Integer.class);

        if(like == null){
            setKey(QUESTIONNAIRE_LIKE + questionnaireId, 0);
            like = 0;
        }

        return like;
    }

    /**
     * 获取问卷赞数
     * @param questionnaireBasic 基本问卷
     * @return 赞数
     */
    public Integer getQuestionnaireLike(@NotNull QuestionnaireBasic questionnaireBasic){
        return getQuestionnaireLike(questionnaireBasic.getQuestionnaireId());
    }

    /**
     * 获取问卷浏览数
     * @param questionnaireId 基本问卷id
     * @return 浏览数
     */
    public Integer getQuestionnaireView(@NotNull String questionnaireId){
        Integer view = getKey(QUESTIONNAIRE_VIEW + questionnaireId, Integer.class);

        if(view == null){
            setKey(QUESTIONNAIRE_VIEW + questionnaireId, 0);
            view = 0;
        }

        return view;    }

    /**
     * 获取问卷浏览数
     * @param questionnaireBasic 基本问卷
     * @return 浏览数
     */
    public Integer getQuestionnaireView(@NotNull QuestionnaireBasic questionnaireBasic){
        return getQuestionnaireView(questionnaireBasic.getQuestionnaireId());
    }

    /**
     * 添加问卷赞数
     * @param questionnaireId 基本问卷id
     * @return 赞数
     */
    public long incrementQuestionnaireLike(@NotNull String questionnaireId){
        return increment(QUESTIONNAIRE_LIKE + questionnaireId);
    }

    /**
     * 添加问卷赞数
     * @param questionnaireBasic 基本问卷
     * @return 赞数
     */
    public long incrementQuestionnaireLike(@NotNull QuestionnaireBasic questionnaireBasic){
        return incrementQuestionnaireLike(questionnaireBasic.getQuestionnaireId());
    }

    /**
     * 添加问卷浏览数
     * @param questionnaireId 基本问卷id
     * @return 浏览数
     */

    public long incrementQuestionnaireView(@NotNull String questionnaireId){
        return increment(QUESTIONNAIRE_VIEW + questionnaireId);
    }

    /**
     * 添加问卷浏览数
     * @param questionnaireBasic 基本问卷
     * @return 浏览数
     */
    public long incrementQuestionnaireView(@NotNull QuestionnaireBasic questionnaireBasic){
        return incrementQuestionnaireView(questionnaireBasic.getQuestionnaireId());
    }





    //====下面是私有方法====

    private void setKey(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    private void setKey(String key, int value){
        redisTemplate.opsForValue().set(key, value);
    }

    private boolean setKeyAndExpired(String key, String value, long time, TimeUnit timeUnit){
        try{
            redisTemplate.opsForValue().set(key, value);
            redisTemplate.expire(key, time, timeUnit);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private Boolean expired(String key, long time, TimeUnit timeUnit) throws Exception{
        return redisTemplate.expire(key, time, timeUnit);
    }

    private <T> T getKey(String key, Class<T> resultType){
        try {
            Object o = redisTemplate.opsForValue().get(key);
            return (T)o;
        }catch (Exception e){
            return null;
        }
    }

    private Long increment(String key){
        return redisTemplate.opsForValue().increment(key);
    }

    private Boolean delete(String key){
        return redisTemplate.delete(key);
    }

}
