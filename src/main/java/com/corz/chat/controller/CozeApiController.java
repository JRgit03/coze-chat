package com.corz.chat.controller;

import com.corz.chat.common.Result;
import com.corz.chat.config.CozeHeader;
import com.corz.chat.response.ConversationObject;
import com.corz.chat.service.CozeApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author: JRCoder
 * @descption: 接口封装
 * @link: <a href="https://www.coze.cn/docs/developer_guides/coze_api_overview">扣子接口文档地址</a>
 */
@Slf4j
@RequestMapping("/coze/api/v1")
@RestController
public class CozeApiController {

    @Resource
    private CozeApiService cozeApiService;

    @GetMapping("/test")
    public String test(){
        return "ok";
    }

    @PostMapping("/conversation/create")
    public Result<ConversationObject> createConversation(){
        return cozeApiService.createConversation();
    }
}
