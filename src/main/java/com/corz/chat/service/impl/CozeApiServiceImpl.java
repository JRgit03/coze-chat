package com.corz.chat.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.corz.chat.common.Result;
import com.corz.chat.config.CozeHeader;
import com.corz.chat.response.ConversationObject;
import com.corz.chat.service.CozeApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class CozeApiServiceImpl implements CozeApiService {

    @Resource
    private CozeHeader cozeHeader;

    @Override
    public Result<ConversationObject> createConversation() {
        log.info("Authorization = {}, Content-Type = {}", cozeHeader.getAuthorization(), cozeHeader.getContentType());
        HttpResponse httpResponse = HttpRequest.post(" https://api.coze.cn/v1/conversation/create")
                .header("Authorization", cozeHeader.getAuthorization())
                .header("Content-Type", cozeHeader.getContentType())
                .execute();
        log.info("创建会话响应信息结果 = {}", httpResponse);
        Result result = JSONUtil.toBean(httpResponse.body(), Result.class);
        log.info("body = {}, result = {}", httpResponse.body(), result);
        return result;
    }
}
