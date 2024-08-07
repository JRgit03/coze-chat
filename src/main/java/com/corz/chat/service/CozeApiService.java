package com.corz.chat.service;

import com.corz.chat.common.Result;
import com.corz.chat.response.ConversationObject;
import com.corz.chat.response.MessageObject;

public interface CozeApiService {
    Result<ConversationObject> createConversation();

    Result<ConversationObject> retrieveConversation(String conversationId);

    Result<MessageObject> createMessage(String conversationId, String content);
}
