package com.corz.chat.response;

import lombok.Data;

import java.util.Map;

@Data
public class MessageObject {
    private String id;
    private String conversation_id;
    private String bot_id;
    private String chat_id;
    private Map<String, String> meta_data;
    private String role;
    private String content;
    private String content_type;
    private Integer created_at;
    private Integer updated_at;
    private String type;
}
