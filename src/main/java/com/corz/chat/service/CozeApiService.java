package com.corz.chat.service;

import com.corz.chat.common.Result;
import com.corz.chat.response.ConversationObject;

public interface CozeApiService {
    Result<ConversationObject> createConversation();
}
