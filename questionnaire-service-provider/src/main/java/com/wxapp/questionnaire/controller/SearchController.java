package com.wxapp.questionnaire.controller;

import com.wxapp.questionnaire.pojo.QuestionnaireBasic;
import com.wxapp.questionnaire.service.SearchService;
import com.wxapp.questionnaire.utils.ApiUtils;
import com.wxapp.questionnaire.vo.ApiVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author orangeboy
 * 搜索的Controller
 */

@Api(tags = "搜索")
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @ApiOperation("通过标题搜索基本问卷信息")
    @GetMapping("/basic")
    public ApiVO<Page<QuestionnaireBasic>> searchByTitle(
            @RequestParam("keyword") @ApiParam("关键词") String keyword,
            @RequestParam("page") @ApiParam("分页页数") int page,
            @RequestParam("size") @ApiParam("分页大小") int size){

        return ApiUtils.success(searchService.queryByTitle(keyword, page, size));
    }

    @ApiOperation("通过类型名称搜索问卷")
    @GetMapping("/type")
    public ApiVO<Page<QuestionnaireBasic>> searchByType(
            @RequestParam("keyword") @ApiParam("关键词") String keyword,
            @RequestParam("page") @ApiParam("分页页数") int page,
            @RequestParam("size") @ApiParam("分页大小") int size){

        return ApiUtils.success(searchService.queryByType(keyword, page, size));
    }




}
