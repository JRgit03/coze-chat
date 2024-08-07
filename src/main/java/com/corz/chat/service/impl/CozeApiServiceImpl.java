package com.corz.chat.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.corz.chat.common.Result;
import com.corz.chat.config.CozeHeader;
import com.corz.chat.request.MessageRequestBody;
import com.corz.chat.response.ConversationObject;
import com.corz.chat.response.MessageObject;
import com.corz.chat.service.CozeApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class CozeApiServiceImpl implements CozeApiService {

    @Resource
    private CozeHeader cozeHeader;

    public HttpRequest get(String url){
        return HttpRequest.get(url)
                .header("Authorization", cozeHeader.getAuthorization())
                .header("Content-Type", cozeHeader.getContentType());
    }

    public HttpRequest post(String url){
        return HttpRequest.post(url)
                .header("Authorization", cozeHeader.getAuthorization())
                .header("Content-Type", cozeHeader.getContentType());
    }

    @Override
    public Result<ConversationObject> createConversation() {
        log.info("Authorization = {}, Content-Type = {}", cozeHeader.getAuthorization(), cozeHeader.getContentType());
        HttpResponse httpResponse = post(" https://api.coze.cn/v1/conversation/create").execute();
        log.info("创建会话响应信息结果 = {}", httpResponse);
        Result result = JSONUtil.toBean(httpResponse.body(), Result.class);
        log.info("body = {}, result = {}", httpResponse.body(), result);
        return result;
    }

    @Override
    public Result<ConversationObject> retrieveConversation(String conversationId) {
        HttpResponse httpResponse = get(" https://api.coze.cn/v1/conversation/retrieve?conversation_id=" + conversationId).execute();
        return JSONUtil.toBean(httpResponse.body(), Result.class);
    }

    @Override
    public Result<MessageObject> createMessage(String conversationId, String content) {
        String responseStr = post(" https://api.coze.cn/v1/conversation/message/create?conversation_id=" + conversationId)
                .body(JSONUtil.toJsonStr(MessageRequestBody.builder()
                        .role("user")
                        .content(content)
                        .content_type("text")
                        .build()))
                .execute().body();
         return JSONUtil.toBean(responseStr, Result.class);
    }
}
