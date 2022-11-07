package com.example.chatexample.Config;

import com.example.chatexample.Handler.ChatHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    ChatHandler chatHandler;
    @Override
    public void registerWebSocketHandler(WebSocketHandlerRegistry registry){

        registry.addHandler(chatHandler,"ws/Chat").setAllowedOrigins("*");
    }
}