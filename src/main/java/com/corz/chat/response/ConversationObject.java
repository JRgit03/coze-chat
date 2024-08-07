package com.corz.chat.response;

import lombok.Data;

import java.util.Map;

@Data
public class ConversationObject {
    /** Conversation ID */
    private String id;
    /** 会话创建的时间 */
    private Integer created_at;
    /** 创建消息时的附加消息 */
    private Map<String, String> meta_data;
}
