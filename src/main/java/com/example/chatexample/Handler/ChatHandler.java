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
    //  client가 접속 시 호출되는 메서드
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        list.add(session);

        System.out.printf(session + "클라이언트 접속");
    }
    // Client가 접속 해제 될 시 호출 되는 메서드
    public void afterConnectionClosed(WebSocketSession session , CloseStatus status) throws Exception {
        System.out.printf(session + "클라이언트 접속 헤제");
        list.remove(session);
    }
}
