package com.wxapp.questionnaire.controller;

import com.wxapp.questionnaire.pojo.QuestionnaireCommit;
import com.wxapp.questionnaire.pojo.QuestionnaireDetail;
import com.wxapp.questionnaire.service.QuestionnaireService;
import com.wxapp.questionnaire.utils.ApiUtils;
import com.wxapp.questionnaire.vo.ApiVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/5/2 17:07
 * 提交、保存问卷的Controller
 */
@Api(tags = "操作问卷")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @ApiOperation("根据问卷id查看问卷详情")
    @GetMapping("/get/{id}")
    public ApiVO getDetail(@PathVariable("id") @ApiParam("问卷id") String id){
        QuestionnaireDetail detail = questionnaireService.getDetail(id);
        if(detail == null){
            return ApiUtils.error(404, "没有找到问卷");
        }
        else{
            return ApiUtils.success(detail);
        }
    }

    @ApiOperation("提交问卷")
    @PostMapping("/post/")
    public ApiVO commit(QuestionnaireCommit commit){
        questionnaireService.commit(commit);
        return ApiUtils.success();
    }

    @ApiOperation("创建问卷")
    @PostMapping("/create/")
    public ApiVO commit(QuestionnaireDetail detail){
        questionnaireService.create(detail);
        return ApiUtils.success();
    }

}
