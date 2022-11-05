package com.example.chatexample.Config;

import com.example.chatexample.Handler.ChatHandler;
import com.sun.xml.txw2.output.CharacterEscapeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    ChatHandler chatHandler;

}