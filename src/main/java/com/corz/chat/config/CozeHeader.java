package com.corz.chat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "coze.header")
public class CozeHeader {
    private String Authorization;
    private String ContentType;
}
