package com.corz.chat.request;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class MessageRequestBody {
    private String role;
    private String content;
    private String content_type;
    private Map<String, String> mete_data;
}
