package com.example.chatexample.Handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChatHandler extends TextWebSocketHandler {

    private static List<WebSocketSession>list = new ArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message ) throws Exception {
        String payload = message.getPayload();
        System.out.printf("payload:" + payload);

        for (WebSocketSession sess : list) {
            sess.sendMessage(message);
        }
    }

}
